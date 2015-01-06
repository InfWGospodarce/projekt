package org.pwr.transporter.server.web.validators.article;


import org.pwr.transporter.entity.article.Prices;
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
public class PricesValidator implements Validator {

    private String prefix;


    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Prices.class);
    }


    public PricesValidator() {
        prefix = "";
    }


    public PricesValidator(String prefix) {
        this.prefix = prefix;
    }


    @Override
    public void validate(Object obj, Errors errors) {
        // TODO
    }

}
