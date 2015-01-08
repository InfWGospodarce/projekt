package org.pwr.transporter.server.web.controllers.base;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.base.TaxItem;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.web.controllers.GenericController;
import org.pwr.transporter.server.web.services.TaxItemService;
import org.pwr.transporter.server.web.validators.TaxItemValidator;
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
 *    Controller for {@link TaxItem}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
@Controller
public class TaxItemController extends GenericController {

	private static Logger LOGGER = Logger.getLogger(TaxItemController.class);

	@Autowired
	TaxItemService service;

	@Autowired
	TaxItemValidator validator;

	@RequestMapping(value = { "/admin/taxItemList", "/account/taxItemList" }, method = RequestMethod.GET)
	public String getList( HttpServletRequest request, HttpServletResponse response, Model model ) {

		Criteria criteria = restoreCriteria(request);
		List<TaxItem> list = getListWithCriteria(service, request, criteria);

		model.addAttribute("list", list);

		return "/Views/admin/taxItemList";
	}

	@RequestMapping(value = { "/admin/taxItemEdit", "/account/taxItemEdit" }, method = RequestMethod.GET)
	public String get( HttpServletRequest request, HttpServletResponse response, Model model ) {

		Long id = getId(request.getParameter("id"));
		loadData(model);
		TaxItem object = null;
		if ( id == null ) {
			object = new TaxItem();
		} else {
			object = service.getByID(id);
			if ( object == null || object.getId() == null ) {
				object = new TaxItem();
			}
		}

		model.addAttribute("object", object);

		return "Views/base/taxItemEdit";
	}

	@RequestMapping(value = { "/admin/taxItemEdit", "/account/taxItemEdit" }, method = RequestMethod.POST)
	public String post( HttpServletRequest request, HttpServletResponse response, @ModelAttribute("object") @Validated TaxItem object,
			BindingResult formBindeings, Model model ) {

		if ( !validate(object, model, formBindeings, validator) ) {
			return "/Views/base/taxItemEdit";
		}

		if ( object.getId() != null ) {
			LOGGER.debug("Id not null");
			service.update(object);
		} else {
			service.insert(object);
		}
		if ( request.getContextPath().contains("account") ) {
			return "redirect:../account/taxItemList?page=" + getPage(request);
		}
		return "redirect:../admin/taxItemList?page=" + getPage(request);
	}

	@Override
	public void loadData( Model model ) {
		// TODO Auto-generated method stub

	}
}
