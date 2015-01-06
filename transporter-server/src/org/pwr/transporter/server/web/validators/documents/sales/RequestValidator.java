package org.pwr.transporter.server.web.validators.documents.sales;


import org.pwr.transporter.entity.sales.Request;
import org.pwr.transporter.entity.sales.RequestRow;
import org.pwr.transporter.server.web.validators.documents.GenericDocumentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



/**
 * <pre>
 *     Validate {@link Request}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class RequestValidator implements Validator {

    private String prefix;

    @Autowired
    GenericDocumentValidator genericDocumentValidator;

    @Autowired
    RequestRowValidator requestRowValidator;


    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Request.class);
    }


    public RequestValidator() {
        prefix = "";
    }


    public RequestValidator(String prefix) {
        this.prefix = prefix;
    }


    @Override
    public void validate(Object obj, Errors errors) {

        genericDocumentValidator.validate(obj, errors);

        Request ent = (Request) obj;
        for( RequestRow row : ent.getRows() ) {
            requestRowValidator.validate(row, errors);
        }
        // TODO
    }

}
