package org.pwr.transporter.server.web.validators;


import org.pwr.transporter.entity.Users;
import org.pwr.transporter.server.web.services.UsersService;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;



/**
 * <pre>
 *     Validate new user
 * </pre>
 * <hr/>
 * 
 * @author x0r
 * @version 0.0.5
 */
public class UserValidator implements org.springframework.validation.Validator {

    private String prefix;

    UsersService usersService;


    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Users.class);
    }


    public UserValidator(String prefix, UsersService usersService) {
        this.prefix = prefix;
        this.usersService = usersService;
    }


    @Override
    public void validate(Object obj, Errors errors) {
        Users user = (Users) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, prefix + "username", "valid.user.username.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, prefix + "email", "valid.user.email.empty");

        if( user.getUsername() != null ) {
            Users testUser = usersService.getByUserName(user.getUsername());
            if( testUser != null ) {
                errors.rejectValue(prefix + "username", "valid.user.username.occupied");
            }
        }
        if( user.getEmail() != null ) {
            Users testUser2 = usersService.getByUserEmail(user.getEmail());
            if( testUser2 != null ) {
                errors.rejectValue(prefix + "email", "valid.user.email.occupied");
            }
        }

    }
}
