package org.pwr.transporter.server.web.controllers.account;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.server.web.form.UserForm;
import org.pwr.transporter.server.web.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * <pre>
 *    Show login or logout page.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.5
 */
@Controller
public class LoginController {

	private static Logger LOGGER = Logger.getLogger(LoginController.class);

	@Autowired
	UsersService usersService;

	@RequestMapping(value = "/log/login", method = RequestMethod.GET)
	public String doGetLogin( HttpServletRequest request, HttpServletResponse response, Model model ) {
		model.addAttribute("user", new UserForm());
		LOGGER.debug("Get login");
		return "/Views/log/login";
	}

	@RequestMapping(value = "/log/login", method = RequestMethod.POST)
	public String doPostLogin( HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user") UserForm user,
			BindingResult bindings, Model model ) {

		if ( !usersService.checkUserLogin(user) ) {
			bindings.rejectValue("username", "login.failed");
			model.addAttribute("user", user);
			LOGGER.debug("Login failed");
			return "/Views/log/login";
		}

		request.getSession().setAttribute("userctx", usersService.getByUserName(user.getUsername()));
		// model.addAttribute("user",
		// usersService.getByUserName(user.getUsername()));

		LOGGER.debug("POST login");
		return "redirect:../index";
	}

	@RequestMapping(value = "/log/logout", method = RequestMethod.GET)
	public String doGetLogout( HttpServletRequest request, HttpServletResponse response ) {
		request.getSession().removeAttribute("userctx");
		return "/Views/log/logout";
	}
}
