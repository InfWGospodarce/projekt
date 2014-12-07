package org.pwr.transporter.server.web.validators;


import org.pwr.transporter.entity.base.Customer;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;



/**
 * <pre>
 *    Validate customer form
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.4
 */
public class CustomerValidator implements Validator {

    private String prefix;


    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Customer.class);
    }


    public CustomerValidator(String prefix) {
        this.prefix = prefix;
    }


    @Override
    public void validate(Object obj, Errors errors) {
        Customer customer = (Customer) obj;
        if( customer.isCompany() ) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, prefix + "companyName", "valid.customer.name.not.empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, prefix + "nip", "valid.customer.nip.not.empty");
        }
        ( new PersonValidator(prefix) ).validate(obj, errors);
    }
}
