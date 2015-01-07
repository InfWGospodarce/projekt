package org.pwr.transporter.server.web.validators.warehouse;


import org.pwr.transporter.entity.Generic;
import org.pwr.transporter.entity.warehouse.Shelf;
import org.pwr.transporter.entity.warehouse.Warehouse;
import org.pwr.transporter.server.dao.impl.ObjectDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;



/**
 * <pre>
 * Validate
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.2
 */
public class ShelfValidator implements Validator {

    private String prefix;

    @Autowired
    ObjectDAOImpl objectDAOImpl;


    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Shelf.class);
    }


    public ShelfValidator() {
        prefix = "";
    }


    public ShelfValidator(String prefix) {
        this.prefix = prefix;
    }


    @Override
    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, prefix + "warehouseId", "valid.warehouse.warehouseid");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, prefix + "searchKey", "entity.searchKey");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, prefix + "name", "entity.name");

        Shelf shelf = (Shelf) obj;

        if( shelf.getWarehouseId() != null && !shelf.getWarehouseId().isEmpty() ) {
            Generic warehouse = objectDAOImpl.getByID(Long.getLong(shelf.getWarehouseId()));
            if( warehouse == null || !( warehouse instanceof Warehouse ) ) {
                errors.rejectValue("warehouseId", "valid.warehouse.warehouseid.inncorect");
            }
        }

    }
}
