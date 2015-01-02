package org.pwr.transporter.server.web.controllers.base;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.Role;
import org.pwr.transporter.server.web.controllers.GenericController;
import org.pwr.transporter.server.web.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * <pre>
 *    Control sites related with {@link Role}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.2
 */
@Controller
public class RoleController extends GenericController {

	private static Logger LOGGER = Logger.getLogger(RoleController.class);

	@Autowired
	RoleService roleService;

	@RequestMapping(value = "/admin/rolesList", method = RequestMethod.GET)
	public String getList( HttpServletRequest request, HttpServletResponse response, Model model ) {

		List<Role> roleList = getList(roleService, request);
		request.setAttribute("list", roleList);

		return "Views/admin/rolesList";
	}

	@RequestMapping(value = "/admin/roleEdit", method = RequestMethod.GET)
	public String getPrefix( HttpServletRequest request, HttpServletResponse response, Model model ) {

		Long id = getId(request.getParameter("id"));
		Role role = null;
		if ( id == null ) {
			role = new Role();
		} else {
			role = roleService.getByID(id);
			if ( role == null || role.getId() == null ) {
				role = new Role();
			}
		}

		model.addAttribute("role", role);

		return "Views/base/roleEdit";
	}

	@RequestMapping(value = "/admin/roleEdit", method = RequestMethod.POST)
	public String postPrefix( HttpServletRequest request, HttpServletResponse response, @ModelAttribute("role") Role role, BindingResult formBindeings ) {

		// FIXME VALIDATION
		if ( role.getId() != null ) {
			roleService.update(role);
		} else {
			roleService.insert(role);
		}

		return "redirect:../admin/rolesList?page=" + getPage(request);
	}

}
