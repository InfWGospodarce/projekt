package org.pwr.transporter.server.web.controllers.mag;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.warehouse.Shelf;
import org.pwr.transporter.entity.warehouse.Warehouse;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.web.controllers.GenericController;
import org.pwr.transporter.server.web.services.warehouse.ShelfService;
import org.pwr.transporter.server.web.services.warehouse.WarehouseService;
import org.pwr.transporter.server.web.validators.warehouse.ShelfValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 * <pre>
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.4
 */
@Controller
public class ShelfController extends GenericController {

    private static Logger LOGGER = Logger.getLogger(ShelfController.class);

    @Autowired
    ShelfService shelfService;

    @Autowired
    ShelfValidator validator;

    @Autowired
    WarehouseService warehauseService;


    @RequestMapping(value = "/mag/shelfList", method = RequestMethod.GET)
    public String getList(HttpServletRequest request, HttpServletResponse response, Model model) {

        Criteria criteria = restoreCriteria(request);
        List<Warehouse> list = getListWithCriteria(shelfService, request, criteria);
        request.setAttribute("list", list);

        return "Views/mag/shelfList";
    }


    @RequestMapping(value = "/mag/shelfEdit", method = RequestMethod.GET)
    public String get(HttpServletRequest request, HttpServletResponse response, Model model) {

        Long id = getId(request.getParameter("id"));
        Shelf object = null;
        if( id == null ) {
            object = new Shelf();
        } else {
            object = shelfService.getByID(id);
            if( object == null || object.getId() == null ) {
                object = new Shelf();
            }
        }

        loadData(model);
        model.addAttribute("object", object);

        return "Views/mag/shelfEdit";
    }


    public void loadData(Model model) {
    }


    @RequestMapping(value = "/mag/shelfEdit", method = RequestMethod.POST)
    public String post(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("object") @Validated Shelf object,
            BindingResult formBindeings, Model model) {

        if( !validate(object, model, formBindeings, validator) ) {
            return "/Views/mag/shelfEdit";
        }

        LOGGER.debug("Id: " + object.getId());

        if( object.getId() != null ) {
            LOGGER.debug("Id not null");
            shelfService.update(object);
        } else {
            shelfService.insert(object);
        }

        return "redirect:../mag/shelfList?page=" + getPage(request);
    }

}
