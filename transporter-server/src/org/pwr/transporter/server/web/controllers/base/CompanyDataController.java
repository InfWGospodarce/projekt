package org.pwr.transporter.server.web.controllers.base;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.base.CompanyData;
import org.pwr.transporter.entity.base.Country;
import org.pwr.transporter.entity.enums.base.AddrStreetPrefix;
import org.pwr.transporter.entity.enums.base.EmployeeType;
import org.pwr.transporter.server.web.controllers.GenericController;
import org.pwr.transporter.server.web.services.CompanyDataService;
import org.pwr.transporter.server.web.services.CountryService;
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
 *    Control sites related with {@link EmployeeType}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.6
 */
@Controller
public class CompanyDataController extends GenericController {

	private static Logger LOGGER = Logger.getLogger(CompanyDataController.class);

	@Autowired
	private CompanyDataService companyDataService;

	@Autowired
	private AddrStreetPrefixService addrStreetPrefixService;

	@Autowired
	private CountryService countryService;

	@RequestMapping(value = "/admin/companyData", method = RequestMethod.GET)
	public String get( HttpServletRequest request, HttpServletResponse response, Model model ) {

		CompanyData companyData = companyDataService.getCompanyData();
		if ( companyData == null || companyData.getId() == null ) {
			companyData = new CompanyData();
		}

		model.addAttribute("companyData", companyData);

		return "Views/admin/companyData";
	}

	@RequestMapping(value = "/admin/companyDataEdit", method = RequestMethod.GET)
	public String getPost( HttpServletRequest request, HttpServletResponse response, Model model ) {

		CompanyData companyData = companyDataService.getCompanyData();
		if ( companyData == null || companyData.getId() == null ) {
			companyData = new CompanyData();
		}

		List<AddrStreetPrefix> addrStreetPrefixs = addrStreetPrefixService.getList();
		List<Country> countires = countryService.getList();

		model.addAttribute("companyData", companyData);
		model.addAttribute("addrStreetPrefixs", addrStreetPrefixs);
		model.addAttribute("countries", countires);

		return "Views/admin/companyDataEdit";
	}

	@RequestMapping(value = "/admin/companyDataEdit", method = RequestMethod.POST)
	public String post( HttpServletRequest request, HttpServletResponse response, @ModelAttribute("companyData") CompanyData companyData,
			BindingResult formBindeings ) {

		LOGGER.debug(companyData.getAddress().getCity());
		// FIXME VALIDATION
		if ( companyData.getId() != null ) {
			LOGGER.debug("Update company data");
			companyDataService.update(companyData);
		} else {
			LOGGER.debug("Insert company data");
			companyDataService.insert(companyData);
		}

		return "redirect:../admin/companyData";
	}

}
