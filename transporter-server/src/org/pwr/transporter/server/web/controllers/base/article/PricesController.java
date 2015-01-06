package org.pwr.transporter.server.web.controllers.base.article;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.article.Prices;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.core.hb.criteria.Criteria.SortOptions;
import org.pwr.transporter.server.web.controllers.GenericController;
import org.pwr.transporter.server.web.services.article.PricesService;
import org.pwr.transporter.server.web.validators.article.PricesValidator;
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
 *    Controller for {@link Prices}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
@Controller
public class PricesController extends GenericController {

    private static Logger LOGGER = Logger.getLogger(PricesController.class);

    @Autowired
    PricesService service;

    @Autowired
    PricesValidator validator;


    @RequestMapping(value = "/seller/pricesList", method = RequestMethod.GET)
    public String getList(HttpServletRequest request, HttpServletResponse response, Model model) {

        Criteria criteria = restoreCriteria(request);
        criteria.getSortCriteria().put("date", SortOptions.DESC);
        List<Prices> list = getListWithCriteria(service, request, criteria);

        model.addAttribute("list", list);

        return "/Views/seller/pricesList";
    }


    @RequestMapping(value = "/seller/pricesEdit", method = RequestMethod.GET)
    public String get(HttpServletRequest request, HttpServletResponse response, Model model) {

        Long id = getId(request.getParameter("id"));
        loadData(model);
        Prices object = null;
        if( id == null ) {
            object = new Prices();
        } else {
            object = service.getByID(id);
            if( object == null || object.getId() == null ) {
                object = new Prices();
            }
        }

        model.addAttribute("object", object);

        return "Views/seller/pricesEdit";
    }


    @RequestMapping(value = "/seller/pricesEdit", method = RequestMethod.POST)
    public String post(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("object") @Validated Prices object,
            BindingResult formBindeings, Model model) {

        if( !validate(object, model, formBindeings, validator) ) {
            return "/Views/seller/pricesEdit";
        }

        if( object.getId() != null ) {
            LOGGER.debug("Id not null");
            service.update(object);
        } else {
            service.insert(object);
        }

        return "redirect:../seller/pricesList?page=" + getPage(request);
    }


    @Override
    public void loadData(Model model) {
        // TODO Auto-generated method stub

    }
}
