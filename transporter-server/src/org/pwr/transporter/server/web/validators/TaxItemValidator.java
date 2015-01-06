package org.pwr.transporter.server.web.validators;


import org.pwr.transporter.entity.base.TaxItem;
import org.springframework.validation.Errors;
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
public class TaxItemValidator implements Validator {

    private String prefix;


    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(TaxItem.class);
    }


    public TaxItemValidator() {
        prefix = "";
    }


    public TaxItemValidator(String prefix) {
        this.prefix = prefix;
    }


    @Override
    public void validate(Object obj, Errors errors) {
        // TODO
    }

}
