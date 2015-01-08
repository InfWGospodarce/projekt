package org.pwr.transporter.server.web.controllers.mag;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.warehouse.Warehouse;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.web.controllers.GenericController;
import org.pwr.transporter.server.web.services.CountryService;
import org.pwr.transporter.server.web.services.enums.AddrStreetPrefixService;
import org.pwr.transporter.server.web.services.warehouse.WarehouseService;
import org.pwr.transporter.server.web.validators.warehouse.WarehouseValidator;
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
public class WarhouseController extends GenericController {

    private static Logger LOGGER = Logger.getLogger(WarhouseController.class);

    @Autowired
    WarehouseService warehouseService;

    @Autowired
    AddrStreetPrefixService addrStreetPrefixService;

    @Autowired
    CountryService countryService;

    @Autowired
    WarehouseValidator validator;


    @RequestMapping(value = "/mag/warehouseList", method = RequestMethod.GET)
    public String getList(HttpServletRequest request, HttpServletResponse response, Model model) {

        Criteria criteria = restoreCriteria(request);
        List<Warehouse> list = getListWithCriteria(warehouseService, request, criteria);
        request.setAttribute("list", list);

        return "Views/mag/warehouseList";
    }


    @RequestMapping(value = "/mag/warehouseEdit", method = RequestMethod.GET)
    public String get(HttpServletRequest request, HttpServletResponse response, Model model) {

        Long id = getId(request.getParameter("id"));
        Warehouse object = null;
        if( id == null ) {
            object = new Warehouse();
        } else {
            object = warehouseService.getByID(id);
            if( object == null || object.getId() == null ) {
                object = new Warehouse();
            }
        }

        loadData(model);
        model.addAttribute("object", object);

        return "Views/mag/warehouseEdit";
    }


    public void loadData(Model model) {
        model.addAttribute("addrStreetPrefixs", addrStreetPrefixService.getList());
        model.addAttribute("countries", countryService.getList());
    }


    @RequestMapping(value = "/mag/warehouseEdit", method = RequestMethod.POST)
    public String post(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("object") @Validated Warehouse object,
            BindingResult formBindeings, Model model) {

        if( !validate(object, model, formBindeings, validator) ) {
            return "/Views/mag/warehouseEdit";
        }

        LOGGER.debug("Id: " + object.getId());

        if( object.getId() != null ) {
            LOGGER.debug("Id not null");
            warehouseService.update(object);
        } else {
            warehouseService.insert(object);
        }

        return "redirect:../mag/warehouseList?page=" + getPage(request);
    }

}
