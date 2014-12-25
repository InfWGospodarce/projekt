package org.pwr.transporter.server.web.controllers.base.enums;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.enums.base.AddrStreetPrefix;
import org.pwr.transporter.server.web.controllers.GenericController;
import org.pwr.transporter.server.web.services.enums.AddrStreetPrefixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * <pre>
 *    Control sites related with {@link AddrStreetPrefix}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.4
 */
@Controller
public class StreetPrefixController extends GenericController {

	private static Logger LOGGER = Logger.getLogger(StreetPrefixController.class);

	@Autowired
	AddrStreetPrefixService addrStreetPrefixService;

	@RequestMapping(value = "/admin/streetPrefixList", method = RequestMethod.GET)
	public String getList( HttpServletRequest request, HttpServletResponse response, Model model ) {

		List<AddrStreetPrefix> streetPrefixList = getList(addrStreetPrefixService, request);
		request.setAttribute("prefixList", streetPrefixList);

		return "Views/admin/streetPrefixList";
	}

	@RequestMapping(value = "/admin/streetPrefixEdit", method = RequestMethod.GET)
	public String getPrefix( HttpServletRequest request, HttpServletResponse response, Model model ) {

		LOGGER.debug("Get prefix edit");
		Long id = getId(request.getParameter("id"));
		AddrStreetPrefix streetPrefix = null;
		if ( id == null ) {
			streetPrefix = new AddrStreetPrefix();
		} else {
			streetPrefix = addrStreetPrefixService.getByID(id);
			if ( streetPrefix == null || streetPrefix.getId() == null ) {
				streetPrefix = new AddrStreetPrefix();
			}
		}

		model.addAttribute("streetPrefix", streetPrefix);

		return "Views/base/enums/streetPrefixEdit";
	}

	@RequestMapping(value = "/admin/streetPrefixEdit", method = RequestMethod.POST)
	public String postPrefix( HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("streetPrefix")/* @Validated */AddrStreetPrefix streetPrefix, BindingResult formBindeings ) {

		LOGGER.debug("Post prefix");
		// FIXME VALIDATION
		if ( streetPrefix.getId() != null ) {
			LOGGER.debug("Id not null");
			addrStreetPrefixService.update(streetPrefix);
		} else {
			addrStreetPrefixService.insert(streetPrefix);
		}

		return "redirect:../admin/streetPrefixList?page=" + getPage(request);
	}

}
