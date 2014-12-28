package org.pwr.transporter.server.web.controllers.account;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.Role;
import org.pwr.transporter.entity.UserAcc;
import org.pwr.transporter.entity.base.Country;
import org.pwr.transporter.entity.enums.base.AddrStreetPrefix;
import org.pwr.transporter.entity.enums.base.EmployeeType;
import org.pwr.transporter.server.web.controllers.GenericController;
import org.pwr.transporter.server.web.form.CustomerAccountForm;
import org.pwr.transporter.server.web.services.AddressService;
import org.pwr.transporter.server.web.services.CountryService;
import org.pwr.transporter.server.web.services.CustomerService;
import org.pwr.transporter.server.web.services.RoleService;
import org.pwr.transporter.server.web.services.UserService;
import org.pwr.transporter.server.web.services.enums.AddrStreetPrefixService;
import org.pwr.transporter.server.web.services.enums.EmployeeTypeService;
import org.pwr.transporter.server.web.validators.forms.CustomerAccountValidator;
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
 *    Account show / edit controller for employees.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.2
 */
@Controller
public class UserController extends GenericController {

	private static Logger LOGGER = Logger.getLogger(UserController.class);

	@Autowired
	private AddrStreetPrefixService addrStreetPrefixService;

	@Autowired
	private CountryService countryService;

	@Autowired
	private UserService userService;

	@Autowired
	private AddressService addressService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CustomerAccountValidator validator;

	@Autowired
	private RoleService roleService;

	@Autowired
	private EmployeeTypeService emplyeeTypeService;

	@RequestMapping(value = "/admin/userList", method = RequestMethod.GET)
	public String getUserList( HttpServletRequest request, HttpServletResponse response, Model model ) {

		List<UserAcc> list = getList(userService, request);
		model.addAttribute("list", list);

		return "/Views/admin/userList";
	}

	// @RequestMapping(value = "/log/register", method = RequestMethod.GET)
	public String doGetRegister( HttpServletRequest request, HttpServletResponse response, Model model ) {

		List<AddrStreetPrefix> addrStreetPrefixs = addrStreetPrefixService.getList();
		List<Country> countires = countryService.getList();

		model.addAttribute("addrStreetPrefixs", addrStreetPrefixs);
		model.addAttribute("countries", countires);
		model.addAttribute("customerAccountForm", new CustomerAccountForm());

		return "/Views/log/register";
	}

	// @RequestMapping(value = "/admin/createUser", method = RequestMethod.GET)
	public String doGetEmployeeRegister( HttpServletRequest request, HttpServletResponse response, Model model ) {

		List<AddrStreetPrefix> addrStreetPrefixs = addrStreetPrefixService.getList();
		List<Country> countires = countryService.getList();
		List<Role> roles = roleService.getList();
		List<EmployeeType> emplyeeTypes = emplyeeTypeService.getList();

		model.addAttribute("addrStreetPrefixs", addrStreetPrefixs);
		model.addAttribute("countries", countires);
		model.addAttribute("roles", roles);
		model.addAttribute("emplyeeTypes", emplyeeTypes);
		model.addAttribute("customerAccountForm", new CustomerAccountForm());

		return "/Views/log/register";
	}

	// @RequestMapping(value = "/log/register", method = RequestMethod.POST)
	public String doPostRegister( HttpServletRequest request, @ModelAttribute("customerAccountForm") @Validated CustomerAccountForm accountForm,
			BindingResult formBindeings, Model model ) {

		validator.validate(accountForm, formBindeings);

		if ( formBindeings.hasErrors() ) {
			LOGGER.info("Validation fails");
			List<AddrStreetPrefix> addrStreetPrefixs = addrStreetPrefixService.getList();
			List<Country> countires = countryService.getList();
			model.addAttribute("addrStreetPrefixs", addrStreetPrefixs);
			model.addAttribute("countries", countires);
			model.addAttribute("customerAccountForm", accountForm);
			LOGGER.debug(formBindeings.getFieldErrors().toString());
			return "/Views/log/register";
		}

		Long id = userService.insert(accountForm);
		// model.addAttribute("user", usersService.getByID(id));
		request.getSession().setAttribute("userctx", userService.getByID(id));

		LOGGER.debug("Password: " + accountForm.getUser().getPassword());
		LOGGER.debug("Userame: " + accountForm.getUser().getUsername());
		LOGGER.debug("email: " + accountForm.getUser().getEmail());
		LOGGER.debug("salt: " + accountForm.getUser().getSalt());

		return "redirect:/log/login";
	}
}
