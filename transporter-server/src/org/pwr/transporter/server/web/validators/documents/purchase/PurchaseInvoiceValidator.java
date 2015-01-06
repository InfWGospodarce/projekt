package org.pwr.transporter.server.web.validators.documents.purchase;


import org.pwr.transporter.entity.purchase.PurchaseInvoice;
import org.pwr.transporter.entity.purchase.PurchaseInvoiceRow;
import org.pwr.transporter.server.web.validators.documents.GenericDocumentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



/**
 * <pre>
 *     Validate {@link PurchaseInvoice}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class PurchaseInvoiceValidator implements Validator {

    private String prefix;

    @Autowired
    GenericDocumentValidator genericDocumentValidator;

    @Autowired
    PurchaseInvoiceRowValidator purchaseInvoiceRowValidator;


    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(PurchaseInvoice.class);
    }


    public PurchaseInvoiceValidator(String prefix) {
        this.prefix = prefix;
    }


    public PurchaseInvoiceValidator() {
        prefix = "";
    }


    @Override
    public void validate(Object obj, Errors errors) {

        genericDocumentValidator.validate(obj, errors);

        PurchaseInvoice ent = (PurchaseInvoice) obj;
        for( PurchaseInvoiceRow row : ent.getRows() ) {
            purchaseInvoiceRowValidator.validate(row, errors);
        }
        // TODO
    }

}
