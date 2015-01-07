package org.pwr.transporter.server.web.validators;


import org.pwr.transporter.entity.base.Currency;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;



/**
 * <pre>
 * Validate
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class CurrencyValidator implements Validator {

    private String prefix;


    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Currency.class);
    }


    public CurrencyValidator() {
        prefix = "";
    }


    public CurrencyValidator(String prefix) {
        this.prefix = prefix;
    }


    @Override
    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, prefix + "searchKey", "entity.searchKey");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, prefix + "name", "entity.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, prefix + "code", "entity.code");
    }

}
