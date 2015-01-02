package org.pwr.transporter.server.web.validators;


import org.pwr.transporter.entity.base.Employee;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



/**
 * <pre>
 *    Validate Employee form
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.2
 */
public class EmployeeValidator implements Validator {

    private String prefix;


    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Employee.class);
    }


    public EmployeeValidator(String prefix) {
        this.prefix = prefix;
    }


    @Override
    public void validate(Object obj, Errors errors) {
        ( new PersonValidator(prefix) ).validate(obj, errors);
    }
}
