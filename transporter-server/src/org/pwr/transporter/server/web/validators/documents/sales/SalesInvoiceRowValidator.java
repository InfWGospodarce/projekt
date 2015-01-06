package org.pwr.transporter.server.web.validators.documents.sales;


import org.pwr.transporter.entity.sales.SalesInvoiceRow;
import org.pwr.transporter.server.web.validators.documents.GenericDocumentRowValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



/**
 * <pre>
 *     Validate {@link SalesInvoiceRow}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class SalesInvoiceRowValidator implements Validator {

    private String prefix;

    GenericDocumentRowValidator genericDocumentRowValidator;


    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(SalesInvoiceRow.class);
    }


    public SalesInvoiceRowValidator(String prefix) {
        this.prefix = prefix;
    }


    public SalesInvoiceRowValidator() {
        prefix = "";
    }


    @Override
    public void validate(Object obj, Errors errors) {
        genericDocumentRowValidator.validate(obj, errors);
        // TODO
    }

}
