package org.pwr.transporter.server.web.validators.documents.sales;


import org.pwr.transporter.entity.sales.RequestRow;
import org.pwr.transporter.server.web.validators.documents.GenericDocumentRowValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



/**
 * <pre>
 *     Validate {@link RequestRow}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class RequestRowValidator implements Validator {

    private String prefix;

    GenericDocumentRowValidator genericDocumentRowValidator;


    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(RequestRow.class);
    }


    public RequestRowValidator(String prefix) {
        this.prefix = prefix;
    }


    public RequestRowValidator() {
        prefix = "";
    }


    @Override
    public void validate(Object obj, Errors errors) {

        genericDocumentRowValidator.validate(obj, errors);
        // TODO
    }

}
