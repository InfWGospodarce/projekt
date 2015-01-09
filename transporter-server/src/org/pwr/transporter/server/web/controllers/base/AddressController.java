package org.pwr.transporter.server.web.controllers.base;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.base.Address;
import org.pwr.transporter.entity.base.Currency;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.web.controllers.GenericController;
import org.pwr.transporter.server.web.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * <pre>
 *    Controller for {@link Currency}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
@Controller
public class AddressController extends GenericController {

	private static Logger LOGGER = Logger.getLogger(AddressController.class);

	@Autowired
	AddressService service;

	public String getList( HttpServletRequest request, HttpServletResponse response, Model model ) {

		Criteria criteria = restoreCriteria(request);
		List<Currency> list = getListWithCriteria(service, request, criteria);

		model.addAttribute("list", list);

		return "/Views/admin/currencyList";
	}

	@RequestMapping(value = "/seller/customerSelectedAddress", method = RequestMethod.GET)
	public String getAddress( HttpServletRequest request, HttpServletResponse response, Model model ) {

		Long id = getId(request.getParameter("id"));
		loadData(model);
		Address object = null;
		if ( id == null ) {
			object = new Address();
		} else {
			object = service.getByID(id);
			if ( object == null || object.getId() == null ) {
				object = new Address();
			}
		}

		model.addAttribute("object", object);

		return "Views/seller/customer/customerSelectedAddress";
	}

	@Override
	public void loadData( Model model ) {
		// TODO Auto-generated method stub

	}
}
