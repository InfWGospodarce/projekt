package org.pwr.transporter.server.web.controllers.base;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.enums.base.EmployeeType;
import org.pwr.transporter.entity.sales.Request;
import org.pwr.transporter.server.web.controllers.GenericController;
import org.pwr.transporter.server.web.services.CountryService;
import org.pwr.transporter.server.web.services.CustomerService;
import org.pwr.transporter.server.web.services.enums.AddrStreetPrefixService;
import org.pwr.transporter.server.web.services.sales.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
public class CustomerController extends GenericController {

    private static Logger LOGGER = Logger.getLogger(CustomerController.class);

    @Autowired
    CustomerService customerService;

    @Autowired
    AddrStreetPrefixService addrStreetPrefixService;

    @Autowired
    CountryService countryService;


    @Override
    public void loadData(Model model) {
        model.addAttribute("addrStreetPrefixs", addrStreetPrefixService.getList());
        model.addAttribute("countries", countryService.getList());

    }

}
