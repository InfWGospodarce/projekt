package org.pwr.transporter.server.web.validators.documents.purchase;


import org.pwr.transporter.entity.purchase.PurchaseOrderRow;
import org.pwr.transporter.server.web.validators.documents.GenericDocumentRowValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



/**
 * <pre>
 *     Validate {@link PurchaseOrderRow}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class PurchaseOrderRowValidator implements Validator {

    private String prefix;

    GenericDocumentRowValidator genericDocumentRowValidator;


    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(PurchaseOrderRow.class);
    }


    public PurchaseOrderRowValidator(String prefix) {
        this.prefix = prefix;
    }


    public PurchaseOrderRowValidator() {
        prefix = "";
    }


    @Override
    public void validate(Object obj, Errors errors) {

        genericDocumentRowValidator.validate(obj, errors);
        // TODO
    }

}
