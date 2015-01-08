package org.pwr.transporter.server.web.validators.warehouse;


import org.pwr.transporter.entity.warehouse.Shelf;
import org.pwr.transporter.server.web.services.warehouse.WarehouseService;
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
	WarehouseService warehouseService;

	@Override
	public boolean supports( Class<?> clazz ) {
		return clazz.equals(Shelf.class);
	}

	public ShelfValidator() {
		prefix = "";
	}

	public ShelfValidator( String prefix ) {
		this.prefix = prefix;
	}

	@Override
	public void validate( Object obj, Errors errors ) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, prefix + "warehouseId", "valid.warehouse.warehouseid");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, prefix + "searchKey", "entity.searchKey");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, prefix + "name", "entity.name");
	}
}
