package org.pwr.transporter.server.web.validators.article;


import org.pwr.transporter.entity.article.Bundle;
import org.springframework.beans.factory.annotation.Autowired;
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
public class BundleValidator implements Validator {

    private String prefix;

    @Autowired
    WareValidator wareValidator;


    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Bundle.class);
    }


    public BundleValidator() {
        prefix = "";
    }


    public BundleValidator(String prefix) {
        this.prefix = prefix;
    }


    @Override
    public void validate(Object obj, Errors errors) {

        wareValidator.validate(obj, errors);
        // TODO
    }

}
