package org.pwr.transporter.server.web.validators.documents.sales;


import org.pwr.transporter.entity.sales.SalesOrder;
import org.pwr.transporter.entity.sales.SalesOrderRow;
import org.pwr.transporter.server.web.validators.documents.GenericDocumentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



/**
 * <pre>
 *     Validate {@link SalesOrder}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class SalesOrderValidator implements Validator {

    private String prefix;

    @Autowired
    GenericDocumentValidator genericDocumentValidator;

    @Autowired
    SalesOrderRowValidator salesOrderRowValidator;


    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(SalesOrder.class);
    }


    public SalesOrderValidator(String prefix) {
        this.prefix = prefix;
    }


    public SalesOrderValidator() {
        prefix = "";
    }


    @Override
    public void validate(Object obj, Errors errors) {

        genericDocumentValidator.validate(obj, errors);

        SalesOrder ent = (SalesOrder) obj;
        for( SalesOrderRow row : ent.getRows() ) {
            salesOrderRowValidator.validate(row, errors);
        }
        // TODO
    }

}
