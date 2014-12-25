package org.pwr.transporter.server.web.controllers.base;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.enums.base.EmployeeType;
import org.pwr.transporter.server.web.controllers.GenericController;
import org.pwr.transporter.server.web.services.enums.EmployeeTypeService;
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
public class CompanyDataController extends GenericController {

	private static Logger LOGGER = Logger.getLogger(CompanyDataController.class);

	@Autowired
	EmployeeTypeService employeeTypeService;

	@RequestMapping(value = "/admin/companyDataEdit", method = RequestMethod.GET)
	public String get( HttpServletRequest request, HttpServletResponse response, Model model ) {

		LOGGER.debug("Get employee type edit");
		Long id = getId(request.getParameter("id"));
		EmployeeType employeeType = null;
		if ( id == null ) {
			employeeType = new EmployeeType();
		} else {
			employeeType = employeeTypeService.getByID(id);
			if ( employeeType == null || employeeType.getId() == null ) {
				employeeType = new EmployeeType();
			}
		}

		model.addAttribute("employeeType", employeeType);

		return "Views/base/enums/employeeTypeEdit";
	}

	@RequestMapping(value = "/admin/companyDataEdit", method = RequestMethod.POST)
	public String postPrefix( HttpServletRequest request, HttpServletResponse response, @ModelAttribute("employeeType") EmployeeType employeeType,
			BindingResult formBindeings ) {

		// FIXME VALIDATION
		if ( employeeType.getId() != null ) {
			LOGGER.debug("Id not null");
			employeeTypeService.update(employeeType);
		} else {
			employeeTypeService.insert(employeeType);
		}

		return "redirect:../admin/employeeTypeList?page=" + getPage(request);
	}

}
