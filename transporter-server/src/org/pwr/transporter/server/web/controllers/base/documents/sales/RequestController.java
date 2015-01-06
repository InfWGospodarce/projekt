package org.pwr.transporter.server.web.controllers.base.documents.sales;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.sales.Request;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.web.controllers.base.documents.GenericDocumentController;
import org.pwr.transporter.server.web.services.CurrencyService;
import org.pwr.transporter.server.web.services.UnitService;
import org.pwr.transporter.server.web.services.sales.RequestService;
import org.pwr.transporter.server.web.validators.documents.sales.RequestValidator;
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
 *    Controller for {@link Request}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
@Controller
public class RequestController extends GenericDocumentController {

    private static Logger LOGGER = Logger.getLogger(RequestController.class);

    @Autowired
    RequestService requestService;

    @Autowired
    CurrencyService currencyService;

    @Autowired
    UnitService unitService;

    @Autowired
    RequestValidator validator;


    @RequestMapping(value = "/seller/requestList", method = RequestMethod.GET)
    public String getList(HttpServletRequest request, HttpServletResponse response, Model model) {

        Criteria criteria = restoreCriteria(request);
        List<Request> list = getListWitchCriteria(requestService, request, criteria);

        model.addAttribute("list", list);

        return "/Views/seller/requestList";
    }


    @RequestMapping(value = "/seller/requestEdit", method = RequestMethod.GET)
    public String get(HttpServletRequest request, HttpServletResponse response, Model model) {

        Long id = getId(request.getParameter("id"));
        loadData(model);
        Request object = null;
        if( id == null ) {
            object = new Request();
        } else {
            object = requestService.getByID(id);
            if( object == null || object.getId() == null ) {
                object = new Request();
            }
        }

        model.addAttribute("object", object);

        return "Views/seller/requestEdit";
    }


    private void loadData(Model model) {
        model.addAttribute("currencies", currencyService.getList());
        model.addAttribute("units", unitService.getList());
    }


    @RequestMapping(value = "/seller/requestEdit", method = RequestMethod.POST)
    public String post(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("object") @Validated Request object,
            BindingResult formBindeings, Model model) {

        validator.validate(object, formBindeings);

        if( formBindeings.hasErrors() ) {
            LOGGER.info("Validation fails");
            model.addAttribute("object", object);
            loadData(model);
            LOGGER.debug(formBindeings.getFieldErrors().toString());
            return "/Views/seller/requestEdit";
        }

        if( object.getId() != null ) {
            LOGGER.debug("Id not null");
            requestService.update(object);
        } else {
            requestService.insert(object);
        }

        return "redirect:../seller/requestList?page=" + getPage(request);
    }
}
