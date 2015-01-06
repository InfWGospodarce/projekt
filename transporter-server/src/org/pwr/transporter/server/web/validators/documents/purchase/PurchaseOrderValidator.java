package org.pwr.transporter.server.web.validators.documents.purchase;


import org.pwr.transporter.entity.purchase.PurchaseOrder;
import org.pwr.transporter.entity.purchase.PurchaseOrderRow;
import org.pwr.transporter.server.web.validators.documents.GenericDocumentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



/**
 * <pre>
 *     Validate {@link PurchaseOrder}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class PurchaseOrderValidator implements Validator {

    private String prefix;

    @Autowired
    GenericDocumentValidator genericDocumentValidator;

    @Autowired
    PurchaseOrderRowValidator purchaseOrderRowValidator;


    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(PurchaseOrder.class);
    }


    public PurchaseOrderValidator(String prefix) {
        this.prefix = prefix;
    }


    public PurchaseOrderValidator() {
        prefix = "";
    }


    @Override
    public void validate(Object obj, Errors errors) {

        genericDocumentValidator.validate(obj, errors);

        PurchaseOrder ent = (PurchaseOrder) obj;
        for( PurchaseOrderRow row : ent.getRows() ) {
            purchaseOrderRowValidator.validate(row, errors);
        }
        // TODO
    }

}
