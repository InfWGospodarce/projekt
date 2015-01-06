package org.pwr.transporter.server.web.validators.warehouse;


import org.pwr.transporter.entity.warehouse.InventoryBalance;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



/**
 * <pre>
 * Validate
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class InventoryBalanceValidator implements Validator {

    private String prefix;


    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(InventoryBalance.class);
    }


    public InventoryBalanceValidator() {
        prefix = "";
    }


    public InventoryBalanceValidator(String prefix) {
        this.prefix = prefix;
    }


    @Override
    public void validate(Object obj, Errors errors) {
        // TODO
    }

}
