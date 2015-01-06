package org.pwr.transporter.server.web.validators.documents.sales;


import org.pwr.transporter.entity.sales.SalesOrderRow;
import org.pwr.transporter.server.web.validators.documents.GenericDocumentRowValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



/**
 * <pre>
 *     Validate {@link SalesOrderRow}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class SalesOrderRowValidator implements Validator {

    private String prefix;

    GenericDocumentRowValidator genericDocumentRowValidator;


    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(SalesOrderRow.class);
    }


    public SalesOrderRowValidator(String prefix) {
        this.prefix = prefix;
    }


    public SalesOrderRowValidator() {
        prefix = "";
    }


    @Override
    public void validate(Object obj, Errors errors) {

        genericDocumentRowValidator.validate(obj, errors);
        // TODO
    }

}
