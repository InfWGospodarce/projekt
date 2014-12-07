package org.pwr.transporter.server.web.validators;


import org.pwr.transporter.entity.base.Person;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;



/**
 * <pre>
 *     Validate shared person fields
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.2
 */
public class PersonValidator implements Validator {

    private String prefix;


    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Person.class);
    }


    public PersonValidator(String prefix) {
        this.prefix = prefix;
    }


    @Override
    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, prefix + "name", "valid.person.name.not.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, prefix + "surname", "valid.person.surname.not.empty");
        // ValidationUtils.rejectIfEmptyOrWhitespace(errors, prefix + "email", "valid.person.email.not.empty");
    }

}
