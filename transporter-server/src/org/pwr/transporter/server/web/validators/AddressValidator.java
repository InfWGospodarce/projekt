package org.pwr.transporter.server.web.validators;


import org.pwr.transporter.entity.base.Address;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;



/**
 * <pre>
 *    Validate address.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.3
 */
public class AddressValidator implements Validator {

    private String prefix;


    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Address.class);
    }


    public AddressValidator() {
        prefix = "";
    }


    public AddressValidator(String prefix) {
        this.prefix = prefix;
    }


    @Override
    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, prefix + "city", "valid.address.city");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, prefix + "local", "valid.address.local");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, prefix + "postCity", "valid.address.postCity");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, prefix + "zipCode", "valid.address.zipCode");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, prefix + "street", "valid.address.street");
    }
}
