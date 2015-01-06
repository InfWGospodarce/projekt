package org.pwr.transporter.server.web.validators;


import org.pwr.transporter.entity.base.UserAcc;
import org.pwr.transporter.server.web.services.UserService;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;



/**
 * <pre>
 *     Validate new user
 * </pre>
 * <hr/>
 * 
 * @author x0r
 * @version 0.0.6
 */
public class UserValidator implements org.springframework.validation.Validator {

    private String prefix;

    UserService usersService;


    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(UserAcc.class);
    }


    public UserValidator(String prefix, UserService usersService) {
        this.prefix = prefix;
        this.usersService = usersService;
    }


    @Override
    public void validate(Object obj, Errors errors) {
        UserAcc user = (UserAcc) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, prefix + "email", "valid.user.email.empty");

        if( user.getId() == null ) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, prefix + "username", "valid.user.username.empty");
            if( user.getUsername() != null ) {
                UserAcc testUser = usersService.getByUserName(user.getUsername());
                if( testUser != null ) {
                    errors.rejectValue(prefix + "username", "valid.user.username.occupied");
                }
            }
        }

        if( user.getEmail() != null ) {
            UserAcc testUser2 = usersService.getByUserEmail(user.getEmail());
            if( testUser2 != null && !testUser2.getId().equals(user.getId()) ) {
                errors.rejectValue(prefix + "email", "valid.user.email.occupied");
            }
        }
    }
}
