package org.pwr.transporter.server.web.validators.logistic;


import org.pwr.transporter.entity.logistic.Vehicle;
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
public class VehicleValidator implements Validator {

    private String prefix;


    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Vehicle.class);
    }


    public VehicleValidator() {
        prefix = "";
    }


    public VehicleValidator(String prefix) {
        this.prefix = prefix;
    }


    @Override
    public void validate(Object obj, Errors errors) {
        // TODO
    }

}
