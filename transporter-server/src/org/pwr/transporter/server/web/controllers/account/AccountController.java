package org.pwr.transporter.server.web.controllers.account;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.Role;
import org.pwr.transporter.entity.UserAcc;
import org.pwr.transporter.entity.base.Country;
import org.pwr.transporter.entity.base.Customer;
import org.pwr.transporter.entity.base.Employee;
import org.pwr.transporter.entity.base.Person;
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
 *    Account show / edit controller.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.1.1
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
    private RoleService roleService;

    @Autowired
    private EmployeeTypeService emplyeeTypeService;


    @RequestMapping(value = "/log/register", method = RequestMethod.GET)
    public String doGetRegister(HttpServletRequest request, HttpServletResponse response, Model model) {

        loadData(model, false);
        CustomerAccountForm customerAccountForm = new CustomerAccountForm();
        customerAccountForm.setCustomer(new Customer());
        model.addAttribute("customerAccountForm", customerAccountForm);

        return "/Views/log/register";
    }


    @RequestMapping(value = "/admin/userEdit", method = RequestMethod.GET)
    public String doGetEmployeeRegister(HttpServletRequest request, HttpServletResponse response, Model model) {

        prepareData(request, model);

        return "/Views/admin/userEdit";
    }


    private void prepareData(HttpServletRequest request, Model model) {

        loadData(model, true);

        CustomerAccountForm customerAccountForm = new CustomerAccountForm();

        Long id = getId(request.getParameter("id"));
        UserAcc user = null;
        Employee employee = new Employee();
        Person person = employee;
        if( id == null ) {
            user = new UserAcc();
            customerAccountForm.setEmployee(employee);
        } else {
            user = userService.getByID(id);
            if( user == null || user.getId() == null ) {
                user = new UserAcc();
            } else {
                employee = user.getEmployee();
                if( employee == null ) {
                    person = user.getCustomer();
                    customerAccountForm.setCustomer(user.getCustomer());
                } else {
                    person = employee;
                    customerAccountForm.setEmployee(employee);
                    customerAccountForm.setEmployeeTypeId(employee.getEmplyeeType().getId().toString());
                }
            }
        }
        customerAccountForm.setUser(user);
        customerAccountForm.setBaseAddress(person.getBaseAddress());
        customerAccountForm.setCorrespondeAddress(person.getContacAddress());
        customerAccountForm.setCorespondeAddress(person.getContacAddress() != null);

        model.addAttribute("customerAccountForm", customerAccountForm);
    }


    private void loadData(Model model, boolean more) {
        List<AddrStreetPrefix> addrStreetPrefixs = addrStreetPrefixService.getList();
        List<Country> countires = countryService.getList();

        model.addAttribute("addrStreetPrefixs", addrStreetPrefixs);
        model.addAttribute("countries", countires);

        if( more ) {
            List<Role> roles = roleService.getList();
            List<EmployeeType> employeeTypes = emplyeeTypeService.getList();
            model.addAttribute("roles", roles);
            model.addAttribute("employeeTypes", employeeTypes);
        }
    }


    @RequestMapping(value = "/admin/userEdit", method = RequestMethod.POST)
    public String doPostUser(HttpServletRequest request, @ModelAttribute("customerAccountForm") @Validated CustomerAccountForm accountForm,
            BindingResult formBindeings, Model model) {

        validator.validate(accountForm, formBindeings);

        if( formBindeings.hasErrors() ) {
            LOGGER.info("Validation fails");
            loadData(model, true);
            model.addAttribute("customerAccountForm", accountForm);
            LOGGER.debug(formBindeings.getFieldErrors().toString());
            return "/Views/log/register";
        }

        if( accountForm.getUser().getId() == null ) {
            userService.insert(accountForm);
        } else {
            userService.update(accountForm);
        }
        return "redirect:../admin/userList?page=" + getPage(request);
    }


    @RequestMapping(value = "/log/register", method = RequestMethod.POST)
    public String doPostRegister(HttpServletRequest request, @ModelAttribute("customerAccountForm") @Validated CustomerAccountForm accountForm,
            BindingResult formBindeings, Model model) {

        validator.validate(accountForm, formBindeings);

        if( formBindeings.hasErrors() ) {
            LOGGER.info("Validation fails");
            loadData(model, false);
            model.addAttribute("customerAccountForm", accountForm);
            LOGGER.debug(formBindeings.getFieldErrors().toString());
            return "/Views/log/register";
        }

        Role userRole = roleService.getByName("USER");
        Role customerRole = roleService.getByName("CUSTOMER");
        accountForm.getUser().getRole().add(customerRole);
        accountForm.getUser().getRole().add(userRole);
        userService.insert(accountForm);

        return "redirect:/log/login";
    }
}
