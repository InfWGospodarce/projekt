package org.pwr.transporter.server.web.controllers.account;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.Role;
import org.pwr.transporter.entity.UserAcc;
import org.pwr.transporter.entity.base.Address;
import org.pwr.transporter.entity.base.Country;
import org.pwr.transporter.entity.base.Customer;
import org.pwr.transporter.entity.base.Employee;
import org.pwr.transporter.entity.base.Person;
import org.pwr.transporter.entity.enums.base.AddrStreetPrefix;
import org.pwr.transporter.entity.enums.base.EmployeeType;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.core.sec.CustomUserDetails;
import org.pwr.transporter.server.web.controllers.GenericController;
import org.pwr.transporter.server.web.form.CustomerAccountForm;
import org.pwr.transporter.server.web.form.PasswordForm;
import org.pwr.transporter.server.web.services.AddressService;
import org.pwr.transporter.server.web.services.CountryService;
import org.pwr.transporter.server.web.services.CustomerService;
import org.pwr.transporter.server.web.services.RoleService;
import org.pwr.transporter.server.web.services.UserService;
import org.pwr.transporter.server.web.services.enums.AddrStreetPrefixService;
import org.pwr.transporter.server.web.services.enums.EmployeeTypeService;
import org.pwr.transporter.server.web.validators.forms.CustomerAccountValidator;
import org.pwr.transporter.server.web.validators.forms.PasswordFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * <pre>
 *    Account show / edit controller.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.1.8
 */
@Controller
public class AccountController extends GenericController {

	private static Logger LOGGER = Logger.getLogger(AccountController.class);

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
	private PasswordFormValidator passwordValidator;

	@Autowired
	private RoleService roleService;

	@Autowired
	private EmployeeTypeService emplyeeTypeService;

	@Autowired
	@Qualifier("sessionRegistry")
	private SessionRegistry sessionRegistry;

	@RequestMapping(value = "/log/register", method = RequestMethod.GET)
	public String doGetRegister( HttpServletRequest request, HttpServletResponse response, Model model ) {

		loadData(model, false);
		CustomerAccountForm customerAccountForm = new CustomerAccountForm();
		customerAccountForm.setCustomer(new Customer());
		model.addAttribute("customerAccountForm", customerAccountForm);

		return "/Views/log/register";
	}

	@RequestMapping(value = "/admin/userEdit", method = RequestMethod.GET)
	public String doGetEmployeeRegister( HttpServletRequest request, HttpServletResponse response, Model model ) {

		prepareData(request, model);

		return "/Views/base/userEdit";
	}

	private void prepareData( HttpServletRequest request, Model model ) {
		prepareData(request, model, false);
	}

	private boolean prepareData( HttpServletRequest request, Model model, boolean simpleModel ) {

		loadData(model, !simpleModel);

		CustomerAccountForm customerAccountForm = new CustomerAccountForm();

		Long id = getId(request.getParameter("id"));
		if ( simpleModel ) {
			UserAcc us = (UserAcc) request.getSession().getAttribute("userctx");
			if ( us != null ) {
				id = us.getId();
			} else {
				return false;
			}
		}
		UserAcc user = null;
		Employee employee = null;
		Customer customer = null;
		Person person = null;

		String custParam = request.getParameter("customer");
		if ( custParam != null && custParam.equals("1") ) {
			customer = new Customer();
			person = customer;
		} else {
			employee = new Employee();
			person = employee;
		}

		if ( id == null ) {
			user = new UserAcc();
		} else {
			user = userService.getByID(id);
			if ( user == null || user.getId() == null ) {
				user = new UserAcc();
			} else {
				for( Role role : user.getRole() ) {
					customerAccountForm.getUserRoleIds().add(role.getId().toString());
				}
				employee = user.getEmployee();
				if ( employee == null ) {
					person = user.getCustomer();
					customer = user.getCustomer();
				} else {
					person = employee;
					customerAccountForm.setEmployeeTypeId(employee.getEmployeeType().getId().toString());
				}
			}
		}
		customerAccountForm.setUser(user);
		if ( person != null ) {
			customerAccountForm.setBaseAddress(person.getBaseAddress());
			customerAccountForm.setCorrespondeAddress(person.getContacAddress());
			customerAccountForm.setCorespondeAddress(person.getContacAddress() != null);
		} else {
			customerAccountForm.setBaseAddress(new Address());
			customerAccountForm.setCorrespondeAddress(new Address());
			customerAccountForm.setCorespondeAddress(false);
		}

		customerAccountForm.setCustomer(customer);
		customerAccountForm.setEmployee(employee);

		model.addAttribute("customerAccountForm", customerAccountForm);

		return true;
	}

	private void loadData( Model model, boolean more ) {
		List<AddrStreetPrefix> addrStreetPrefixs = addrStreetPrefixService.getList();
		List<Country> countires = countryService.getList();

		model.addAttribute("addrStreetPrefixs", addrStreetPrefixs);
		model.addAttribute("countries", countires);

		if ( more ) {
			List<Role> roles = roleService.getList();
			List<EmployeeType> employeeTypes = emplyeeTypeService.getList();
			model.addAttribute("roles", roles);
			model.addAttribute("employeeTypes", employeeTypes);
		}
	}

	@RequestMapping(value = "/admin/userEdit", method = RequestMethod.POST)
	public String doPostUser( HttpServletRequest request, @ModelAttribute("customerAccountForm") @Validated CustomerAccountForm accountForm,
			BindingResult formBindeings, Model model ) {

		validator.validate(accountForm, formBindeings);

		if ( formBindeings.hasErrors() ) {
			LOGGER.info("Validation fails");
			loadData(model, true);
			model.addAttribute("customerAccountForm", accountForm);
			LOGGER.debug(formBindeings.getFieldErrors().toString());
			return "/Views/base/userEdit";
		}

		accountForm.getUser().setRole(new HashSet<Role>());
		if ( accountForm.getCustomer() == null ) {
			for( String id : accountForm.getUserRoleIds() ) {
				Long idx = Long.valueOf(id);
				Role role = roleService.getByID(idx);
				if ( role != null ) {
					accountForm.getUser().getRole().add(role);
				}
			}
		} else {
			Role userRole = roleService.getByName("USER");
			Role customerRole = roleService.getByName("CUSTOMER");
			accountForm.getUser().getRole().add(customerRole);
			accountForm.getUser().getRole().add(userRole);
		}

		if ( accountForm.getUser().getId() == null ) {
			userService.insert(accountForm);
		} else {
			userService.update(accountForm);
		}
		return "redirect:../admin/userList?page=" + getPage(request);
	}

	@RequestMapping(value = "/log/register", method = RequestMethod.POST)
	public String doPostRegister( HttpServletRequest request, @ModelAttribute("customerAccountForm") @Validated CustomerAccountForm accountForm,
			BindingResult formBindeings, Model model ) {

		validator.validate(accountForm, formBindeings);
		accountForm.getUser().setId(null);

		if ( formBindeings.hasErrors() ) {
			LOGGER.info("Validation fails");
			loadData(model, false);
			model.addAttribute("customerAccountForm", accountForm);
			LOGGER.debug(formBindeings.getFieldErrors().toString());
			return "/Views/log/register";
		}

		accountForm.getUser().setRole(new HashSet<Role>());
		Role userRole = roleService.getByName("USER");
		Role customerRole = roleService.getByName("CUSTOMER");
		accountForm.getUser().getRole().add(customerRole);
		accountForm.getUser().getRole().add(userRole);
		userService.insert(accountForm);

		return "redirect:/log/login";
	}

	@RequestMapping(value = "/admin/userList", method = RequestMethod.GET)
	public String getUserList( HttpServletRequest request, HttpServletResponse response, Model model ) {

		Criteria criteria = restoreCriteria(request);
		criteria.setOrderBy("username");

		List<UserAcc> list = getListWitchCriteria(userService, request, criteria);
		List<Object> principals = sessionRegistry.getAllPrincipals();

		List<String> usersNamesList = new ArrayList<String>();

		for( Object principal : principals ) {
			LOGGER.debug("Found: " + principal.toString());
			if ( principal instanceof CustomUserDetails ) {
				usersNamesList.add(((CustomUserDetails) principal).getUsername());
			}
		}

		Map<UserAcc, Boolean> loggedUsers = new HashMap<UserAcc, Boolean>();
		for( UserAcc user : list ) {
			if ( usersNamesList.contains(user.getUsername()) ) {
				loggedUsers.put(user, true);
			} else {
				loggedUsers.put(user, false);
			}
		}

		model.addAttribute("list", loggedUsers);

		return "/Views/admin/userList";
	}

	@RequestMapping(value = "/user/profile", method = RequestMethod.GET)
	public String getUserProfile( HttpServletRequest request, HttpServletResponse response, Model model ) {

		if ( !prepareData(request, model, true) ) {
			return "/Views/log/login";
		}
		return "/Views/user/profile";
	}

	@RequestMapping(value = "/user/profileEdit", method = RequestMethod.GET)
	public String getUserProfileEdit( HttpServletRequest request, HttpServletResponse response, Model model ) {

		if ( !prepareData(request, model, true) ) {
			return "/Views/log/login";
		}

		return "/Views/user/profileEdit";
	}

	@RequestMapping(value = "/user/profileEdit", method = RequestMethod.POST)
	public String postUserProfileEdit( HttpServletRequest request, HttpServletResponse response, Model model,
			@ModelAttribute("customerAccountForm") @Validated CustomerAccountForm accountForm, BindingResult formBindeings ) {

		UserAcc contextUser = (UserAcc) request.getSession().getAttribute("userctx");
		if ( contextUser != null ) {
			accountForm.getUser().setRole(contextUser.getRole());
			for( Role role : contextUser.getRole() ) {
				accountForm.getUserRoleIds().add(role.getId().toString());
			}

			if ( accountForm.getEmployee() != null ) {
				accountForm.setEmployeeTypeId(contextUser.getEmployee().getEmployeeType().getId().toString());
			}
		} else {
			return "/Views/log/login";
		}

		validator.validate(accountForm, formBindeings);

		if ( formBindeings.hasErrors() ) {
			LOGGER.info("Validation fails");
			loadData(model, true);
			model.addAttribute("customerAccountForm", accountForm);
			LOGGER.debug(formBindeings.getFieldErrors().toString());
			return "/Views/user/profileEdit";
		}

		if ( accountForm.getUser().getId() == null ) {
			userService.insert(accountForm);
		} else {
			userService.update(accountForm);
		}
		return "redirect:../user/profile";
	}

	@RequestMapping(value = "/user/properties", method = RequestMethod.GET)
	public String getUserProperties( HttpServletRequest request, HttpServletResponse response, Model model ) {

		if ( !prepareUserProperties(request, model) ) {
			return "/Views/log/login";
		}
		return "/Views/user/userProperties";
	}

	private boolean prepareUserProperties( HttpServletRequest request, Model model ) {
		UserAcc userctx = new UserAcc();
		UserAcc contextUser = (UserAcc) request.getSession().getAttribute("userctx");
		if ( contextUser != null ) {
			userctx.setRowsPerPage(contextUser.getRowsPerPage());
			model.addAttribute("user", userctx);
			return true;
		}
		return false;
	}

	@RequestMapping(value = "/user/propertiesEdit", method = RequestMethod.GET)
	public String getUserPropertiesEdit( HttpServletRequest request, HttpServletResponse response, Model model ) {

		if ( !prepareUserProperties(request, model) ) {
			return "/Views/log/login";
		}

		return "/Views/user/userPropertiesEdit";
	}

	@RequestMapping(value = "/user/propertiesEdit", method = RequestMethod.POST)
	public String postUserPropertiesEdit( HttpServletRequest request, HttpServletResponse response, Model model,
			@ModelAttribute("customerAccountForm") @Validated UserAcc user, BindingResult formBindeings ) {

		UserAcc contextUser = (UserAcc) request.getSession().getAttribute("userctx");
		if ( contextUser != null ) {
			UserAcc origUser = userService.getByID(contextUser.getId());
			origUser.setRowsPerPage(user.getRowsPerPage());
			userService.update(origUser);

			origUser = userService.getByID(contextUser.getId());
			request.getSession().setAttribute("userctx", origUser);
		}

		return "redirect:../user/properties";
	}

	@RequestMapping(value = "/user/passwordEdit", method = RequestMethod.GET)
	public String getPasswordeEdit( HttpServletRequest request, HttpServletResponse response, Model model ) {

		model.addAttribute("password", new PasswordForm());
		return "/Views/user/passwordEdit";
	}

	@RequestMapping(value = "/user/passwordEdit", method = RequestMethod.POST)
	public String postPasswordeEdit( HttpServletRequest request, HttpServletResponse response, Model model,
			@ModelAttribute("password") @Validated PasswordForm password, BindingResult formBindeings ) {

		UserAcc contextUser = (UserAcc) request.getSession().getAttribute("userctx");
		if ( contextUser == null ) {
			return "/Views/log/login";
		}
		password.setUser(contextUser);
		passwordValidator.validate(password, formBindeings);

		if ( formBindeings.hasErrors() ) {
			LOGGER.info("Validation fails");
			model.addAttribute("password", password);
			LOGGER.debug(formBindeings.getFieldErrors().toString());
			return "/Views/user/passwordEdit";
		}

		contextUser.setPassword(password.getNewPassword());
		userService.update(contextUser);
		request.getSession().setAttribute("userctx", contextUser);

		return "redirect:../user/profile";
	}
}
