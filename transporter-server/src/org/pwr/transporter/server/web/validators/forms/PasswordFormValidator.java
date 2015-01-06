package org.pwr.transporter.server.web.validators.forms;


import org.apache.log4j.Logger;
import org.pwr.transporter.entity.base.UserAcc;
import org.pwr.transporter.server.web.form.PasswordForm;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


/**
 * Validate password change form
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class PasswordFormValidator implements Validator {

	private static Logger logger = Logger.getLogger(PasswordFormValidator.class);

	@Override
	public boolean supports( Class<?> clazz ) {
		return PasswordForm.class.equals(clazz);
	}

	@Override
	public void validate( Object obj, Errors errors ) {

		PasswordForm passwordForm = (PasswordForm) obj;

		if ( passwordForm.getUser().getId() != null ) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "oldPassword", "valid.account.password.empty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newPassword", "valid.account.password.empty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newPasswordRe", "valid.account.password.empty");

			UserAcc user = passwordForm.getUser();
			if ( !user.checkPassword(passwordForm.getOldPassword()) ) {
				errors.rejectValue("oldPassword", "valid.account.password.old.wrong");
			}

			UserAcc testUser = new UserAcc();
			testUser.setUsername(user.getUsername());
			testUser.setPassAndSalt(passwordForm.getNewPassword(), user.getSalt());

			logger.debug("OLD: " + user.getPassword());
			logger.debug("OLD: " + testUser.getPassword());

			if ( user.getPassword().equals(testUser.getPassword()) ) {
				errors.rejectValue("newPassword", "valid.account.password.old.same.as.new");
			}

			if ( !passwordForm.getNewPassword().equals(passwordForm.getNewPasswordRe()) ) {
				errors.rejectValue("newPassword", "valid.account.passwords.not.equals");
				errors.rejectValue("newPasswordRe", "valid.account.passwords.not.equals");
			}
		}
	}

}
