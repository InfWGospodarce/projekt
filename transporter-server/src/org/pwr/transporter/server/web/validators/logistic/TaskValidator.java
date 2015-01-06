package org.pwr.transporter.server.web.validators.logistic;


import org.pwr.transporter.entity.logistic.Task;
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
public class TaskValidator implements Validator {

    private String prefix;


    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Task.class);
    }


    public TaskValidator() {
        prefix = "";
    }


    public TaskValidator(String prefix) {
        this.prefix = prefix;
    }


    @Override
    public void validate(Object obj, Errors errors) {
        // TODO
    }

}
