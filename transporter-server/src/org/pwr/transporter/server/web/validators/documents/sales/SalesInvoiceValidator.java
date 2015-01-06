package org.pwr.transporter.server.web.validators.documents.sales;


import org.pwr.transporter.entity.sales.SalesInvoice;
import org.pwr.transporter.entity.sales.SalesInvoiceRow;
import org.pwr.transporter.server.web.validators.documents.GenericDocumentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



/**
 * <pre>
 *     Validate {@link SalesInvoice}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class SalesInvoiceValidator implements Validator {

    private String prefix;

    @Autowired
    private GenericDocumentValidator genericDocumentValidator;

    @Autowired
    private SalesInvoiceRowValidator salesInvoiceRowValidator;


    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(SalesInvoice.class);
    }


    public SalesInvoiceValidator(String prefix) {
        this.prefix = prefix;
    }


    public SalesInvoiceValidator() {
        prefix = "";
    }


    @Override
    public void validate(Object obj, Errors errors) {

        genericDocumentValidator.validate(obj, errors);

        SalesInvoice ent = (SalesInvoice) obj;
        for( SalesInvoiceRow row : ent.getRows() ) {
            salesInvoiceRowValidator.validate(row, errors);
        }
        // TODO
    }

}
