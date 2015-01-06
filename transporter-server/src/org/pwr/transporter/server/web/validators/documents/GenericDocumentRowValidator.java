package org.pwr.transporter.server.web.validators.documents;


import org.pwr.transporter.entity.base.GenericDocument;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



/**
 * <pre>
 *     Validate generic document
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class GenericDocumentRowValidator implements Validator {

    private String prefix;


    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(GenericDocument.class);
    }


    public GenericDocumentRowValidator() {
        prefix = "";
    }


    public GenericDocumentRowValidator(String prefix) {
        this.prefix = prefix;
    }


    @Override
    public void validate(Object obj, Errors errors) {
        // TODO
    }

}
