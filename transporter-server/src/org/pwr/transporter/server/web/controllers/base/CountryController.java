package org.pwr.transporter.server.web.controllers.base;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.base.Country;
import org.pwr.transporter.entity.enums.base.EmployeeType;
import org.pwr.transporter.server.web.controllers.GenericController;
import org.pwr.transporter.server.web.services.CountryService;
import org.pwr.transporter.server.web.services.CurrencyService;
import org.pwr.transporter.server.web.validators.CurrencyValidator;
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
 *    Control sites related with {@link EmployeeType}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.2
 */
@Controller
public class CountryController extends GenericController {

    private static Logger LOGGER = Logger.getLogger(CountryController.class);

    @Autowired
    CountryService countryService;

    @Autowired
    CurrencyService currencyService;

    @Autowired
    CurrencyValidator validator;


    @RequestMapping(value = "/admin/countriesList", method = RequestMethod.GET)
    public String getList(HttpServletRequest request, HttpServletResponse response, Model model) {

        List<EmployeeType> countryList = getList(countryService, request);
        request.setAttribute("list", countryList);

        return "Views/admin/countriesList";
    }


    @RequestMapping(value = "/admin/countryEdit", method = RequestMethod.GET)
    public String getPrefix(HttpServletRequest request, HttpServletResponse response, Model model) {

        Long id = getId(request.getParameter("id"));
        Country country = null;
        if( id == null ) {
            country = new Country();
        } else {
            country = countryService.getByID(id);
            if( country == null || country.getId() == null ) {
                country = new Country();
            } else {
                if( country.getCurrency() != null ) {
                    country.setCurrencyId(country.getCurrency().getId().toString());
                }
            }
        }
        loadData(model);
        model.addAttribute("country", country);

        return "Views/base/countryEdit";
    }


    @RequestMapping(value = "/admin/countryEdit", method = RequestMethod.POST)
    public String postPrefix(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("country") @Validated Country object,
            BindingResult formBindeings, Model model) {

        if( !validate(object, model, formBindeings, validator) ) {
            return "/Views/admin/unitEdit";
        }

        if( object.getId() != null ) {
            LOGGER.debug("Id not null");
            countryService.update(object);
        } else {
            countryService.insert(object);
        }

        return "redirect:../admin/countriesList?page=" + getPage(request);
    }


    @Override
    public void loadData(Model model) {
        model.addAttribute("currencies", currencyService.getList());
    }
}
