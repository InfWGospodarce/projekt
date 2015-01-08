package org.pwr.transporter.server.web.controllers.base;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.base.Customer;
import org.pwr.transporter.entity.base.UserAcc;
import org.pwr.transporter.entity.logistic.Task;
import org.pwr.transporter.entity.sales.Request;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.core.hb.criteria.Criteria.SortOptions;
import org.pwr.transporter.server.web.services.sales.RequestService;
import org.pwr.transporter.server.web.services.CountryService;
import org.pwr.transporter.entity.enums.base.EmployeeType;
import org.pwr.transporter.server.web.services.enums.AddrStreetPrefixService;
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

	@Autowired
	RequestService requestService;
	
	 @Autowired
	    AddrStreetPrefixService addrStreetPrefixService;

	    @Autowired
	    CountryService countryService;
	
	    
	    @Override
		public void loadData(Model model) {
			 model.addAttribute("addrStreetPrefixs", addrStreetPrefixService.getList());
		        model.addAttribute("countries", countryService.getList());
			
		}
	    
	    
	@RequestMapping(value = "/customer/customerHistory", method = RequestMethod.GET)
	public String getList( HttpServletRequest request, HttpServletResponse response, Model model ) {

		 UserAcc user = (UserAcc) request.getSession().getAttribute("userctx");

	        Criteria criteria = restoreCriteria(request);
	        criteria.getEqualCriteria().put("active", true);
	        criteria.getSortCriteria().put("modifyDate", SortOptions.DESC);
	        if( user.getCustomer() != null ) {
	            criteria.getIdsCriteria().put("customer.id", user.getCustomer().getId());
	        } 

	        List<Request> taskList = getListWithCriteria(requestService, request, criteria);
	        model.addAttribute("list", taskList);
		return "Views/customer/customerHistory";
	}
	
	

	@RequestMapping(value = "/customer/customerHistoryEdit", method = RequestMethod.GET)
	public String getEdit( HttpServletRequest request, HttpServletResponse response, Model model ) {

		Long id = getId(request.getParameter("id"));
		Request requestOBJ = null;
		if ( id == null ) {
			requestOBJ = new Request();
		} else {
			requestOBJ = requestService.getByID(id);
			if ( requestOBJ == null || requestOBJ.getId() == null ) {
				requestOBJ = new Request();
			}
		}
		  loadData(model);
	   
		model.addAttribute("object", requestOBJ);

		return "Views/customer/customerHistoryEdit";
		//return "Views/customer/customerHistory";
	}
	
	  @RequestMapping(value = "/customer/customerHistoryEdit", method = RequestMethod.POST)
	    public String postEdit(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("object") Request requestOBJ,
	            BindingResult formBindeings, Model model) {

	        // FIXME VALIDATION
	        if( requestOBJ.getId() != null ) {
	            LOGGER.debug("Id not null");
//	            requestService.update(requestOBJ);
	            LOGGER.debug("1:Update");
	        }
	        else {
	        	       	
	        	requestService.insert(requestOBJ);
	        	  LOGGER.debug("2:Insert");
	        }
	        LOGGER.debug("3");
	        return "redirect:../admin/customerHistory";
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
