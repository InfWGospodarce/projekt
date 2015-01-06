package org.pwr.transporter.server.web.controllers.base;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.base.Customer;
import org.pwr.transporter.entity.enums.base.EmployeeType;
import org.pwr.transporter.server.web.controllers.GenericController;
import org.pwr.transporter.server.web.services.CustomerService;
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

	@RequestMapping(value = "/customer/customerHistory", method = RequestMethod.GET)
	public String getList( HttpServletRequest request, HttpServletResponse response, Model model ) {

		//List<EmployeeType> customerList = getList(customerService, request);
		//request.setAttribute("list", customerList);

		return "Views/customer/customerHistory";
	}

	@RequestMapping(value = "/customer/customerHistoryEdit", method = RequestMethod.GET)
	public String getPrefix( HttpServletRequest request, HttpServletResponse response, Model model ) {

//		Long id = getId(request.getParameter("id"));
//		Customer customer = null;
//		if ( id == null ) {
//			customer = new Customer();
//		} else {
//			customer = customerService.getById(id);
//			if ( customer == null || customer.getId() == null ) {
//				customer = new Customer();
//			}
//		}
//
//		model.addAttribute("request", customer);

		return "Views/customer/customerHistoryyEdit";
		//return "Views/customer/customerHistory";
	}
	
	
	@RequestMapping(value = "/customer/customerMonitorList", method = RequestMethod.GET)
	public String getListMonitList( HttpServletRequest request, HttpServletResponse response, Model model ) {

		

		return "Views/customer/customerMonitorList";
	}
	
	@RequestMapping(value = "/customer/customerMonit/0001", method = RequestMethod.GET)
	public String getListMonitNr( HttpServletRequest request, HttpServletResponse response, Model model ) {

		

		return "Views/customer/customerMonit";
	}
	
	
	

//
//	@RequestMapping(value = "/customer/customerHistory", method = RequestMethod.POST)
//	public String postPrefix( HttpServletRequest request, HttpServletResponse response, @ModelAttribute("country") Country country,
//			BindingResult formBindeings ) {
//
//		// FIXME VALIDATION
//		if ( country.getId() != null ) {
//			LOGGER.debug("Id not null");
//			countryService.update(country);
//		} else {
//			countryService.insert(country);
//		}
//
//		return "redirect:../admin/countriesList?page=" + getPage(request);
//	}

}
