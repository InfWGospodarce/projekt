package org.pwr.transporter.server.web.controllers.base;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.base.Unit;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.web.controllers.GenericController;
import org.pwr.transporter.server.web.services.UnitService;
import org.pwr.transporter.server.web.validators.UnitValidator;
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
 *    Controller for {@link Unit}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
@Controller
public class UnitController extends GenericController {

    private static Logger LOGGER = Logger.getLogger(UnitController.class);

    @Autowired
    UnitService service;

    @Autowired
    UnitValidator validator;


    @RequestMapping(value = "/admin/unitList", method = RequestMethod.GET)
    public String getList(HttpServletRequest request, HttpServletResponse response, Model model) {

        Criteria criteria = restoreCriteria(request);
        List<Unit> list = getListWithCriteria(service, request, criteria);

        model.addAttribute("list", list);

        return "/Views/admin/unitList";
    }


    @RequestMapping(value = "/admin/unitEdit", method = RequestMethod.GET)
    public String get(HttpServletRequest request, HttpServletResponse response, Model model) {

        Long id = getId(request.getParameter("id"));
        loadData(model);
        Unit object = null;
        if( id == null ) {
            object = new Unit();
        } else {
            object = service.getByID(id);
            if( object == null || object.getId() == null ) {
                object = new Unit();
            }
        }

        model.addAttribute("object", object);

        return "Views/base/unitEdit";
    }


    @RequestMapping(value = "/admin/unitEdit", method = RequestMethod.POST)
    public String post(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("object") @Validated Unit object,
            BindingResult formBindeings, Model model) {

        if( !validate(object, model, formBindeings, validator) ) {
            return "/Views/base/unitEdit";
        }

        if( object.getId() != null ) {
            LOGGER.debug("Id not null");
            service.update(object);
        } else {
            service.insert(object);
        }

        return "redirect:../admin/unitList?page=" + getPage(request);
    }


    @Override
    public void loadData(Model model) {
        // TODO Auto-generated method stub
    }
}
