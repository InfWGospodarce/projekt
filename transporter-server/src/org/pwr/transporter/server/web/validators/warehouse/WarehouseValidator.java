package org.pwr.transporter.server.web.validators.warehouse;


import org.pwr.transporter.entity.warehouse.Warehouse;
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
public class WarehouseValidator implements Validator {

    private String prefix;


    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Warehouse.class);
    }


    public WarehouseValidator() {
        prefix = "";
    }


    public WarehouseValidator(String prefix) {
        this.prefix = prefix;
    }


    @Override
    public void validate(Object obj, Errors errors) {
        // TODO
    }

}
