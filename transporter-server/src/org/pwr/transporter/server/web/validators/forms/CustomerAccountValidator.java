package org.pwr.transporter.server.web.validators.forms;


import org.pwr.transporter.server.web.form.CustomerAccountForm;
import org.pwr.transporter.server.web.services.UserService;
import org.pwr.transporter.server.web.validators.AddressValidator;
import org.pwr.transporter.server.web.validators.CustomerValidator;
import org.pwr.transporter.server.web.validators.EmployeeValidator;
import org.pwr.transporter.server.web.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;



/**
 * <pre>
 *    Validator for {@link CustomerAccountForm}.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.4
 */
public class CustomerAccountValidator implements Validator {

    @Autowired
    UserService usersService;


    @Override
    public boolean supports(Class<?> clazz) {
        return CustomerAccountForm.class.equals(clazz);
    }


    @Override
    public void validate(Object obj, Errors errors) {
        CustomerAccountForm accountForm = (CustomerAccountForm) obj;

        ( new AddressValidator("baseAddress.") ).validate(accountForm.getBaseAddress(), errors);
        if( accountForm.isCorespondeAddress() ) {
            ( new AddressValidator("correspondeAddress.") ).validate(accountForm.getCorrespondeAddress(), errors);
        }
        ( new UserValidator("user.", usersService) ).validate(accountForm.getUser(), errors);
        if( accountForm.getCustomer() != null ) {
            ( new CustomerValidator("customer.") ).validate(accountForm.getCustomer(), errors);
        }
        if( accountForm.getEmployee() != null ) {
            ( new EmployeeValidator("employee.") ).validate(accountForm.getEmployee(), errors);
            if( accountForm.getUserRoleIds() == null || accountForm.getUserRoleIds().size() <= 1 ) {
                errors.rejectValue("userRoleIds", "valid.account.roles.to.less");
            }
        }

        if( accountForm.getUser().getId() == null ) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "valid.account.password.empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password2", "valid.account.password.empty");
            if( !accountForm.getPassword().equals(accountForm.getPassword2()) ) {
                errors.rejectValue("password", "valid.account.passwords.not.equals");
                errors.rejectValue("password2", "valid.account.passwords.not.equals");
            }
        }
    }
}
