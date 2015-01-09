package org.pwr.transporter.server.web.controllers.base;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.base.Address;
import org.pwr.transporter.entity.base.Customer;
import org.pwr.transporter.entity.enums.base.EmployeeType;
import org.pwr.transporter.entity.sales.Request;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.web.controllers.GenericController;
import org.pwr.transporter.server.web.services.AddressService;
import org.pwr.transporter.server.web.services.CountryService;
import org.pwr.transporter.server.web.services.CustomerService;
import org.pwr.transporter.server.web.services.enums.AddrStreetPrefixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	AddressService addressService;

	@Autowired
	CustomerService service;

	@Autowired
	AddrStreetPrefixService addrStreetPrefixService;

	@Autowired
	CountryService countryService;

	@RequestMapping(value = "/seller/customerList", method = RequestMethod.GET)
	public String getList( HttpServletRequest request, HttpServletResponse response, Model model ) {

		Criteria criteria = restoreCriteria(request);
		List<Request> list = getListWithCriteria(service, request, criteria);
		model.addAttribute("list", list);

		String ret = "/Views/seller/customer/customerList";
		return ret;
	}

	@RequestMapping(value = "/seller/customerSelectAddress", method = RequestMethod.GET)
	public String getCustomerAddreses( HttpServletRequest request, HttpServletResponse response, Model model ) {

		Long id = getId(request.getParameter("id"));
		List<Address> deliveryAddresses = new ArrayList<Address>();
		Customer object = new Customer();
		if ( id != null ) {
			object = service.getByID(id);
			Map<String, Object> crit = new HashMap<String, Object>();
			crit.put("customer.id", id);
			deliveryAddresses = addressService.search(crit);
			if ( object.getBaseAddress() != null ) {
				deliveryAddresses.add(object.getBaseAddress());
			}
			if ( object.getContacAddress() != null ) {
				deliveryAddresses.add(object.getContacAddress());
			}
		}

		model.addAttribute("deliveryAddressSelector", "");
		LOGGER.debug("Found: " + deliveryAddresses.size());
		model.addAttribute("deliveryAddresses", deliveryAddresses);

		return "/Views/seller/customer/customerSelectAddress";
	}

	@RequestMapping(value = "/seller/customerSimple", method = RequestMethod.GET)
	public String getSimple( HttpServletRequest request, HttpServletResponse response, Model model ) {

		Long id = getId(request.getParameter("id"));
		Customer object = null;
		if ( id != null ) {
			object = service.getByID(id);
		} else {
			object = service.getByID(id);
			if ( object == null || object.getId() == null ) {
				object = new Customer();
			}
		}

		model.addAttribute("object", object);

		String ret = "/Views/seller/customer/customerSimple";
		return ret;
	}

	@Override
	public void loadData( Model model ) {
		model.addAttribute("addrStreetPrefixs", addrStreetPrefixService.getList());
		model.addAttribute("countries", countryService.getList());
	}

}
