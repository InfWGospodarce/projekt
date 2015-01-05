package org.pwr.transporter.server.web.form;


import org.pwr.transporter.entity.UserAcc;


public class PasswordForm {

	String oldPassword;
	String newPassword;
	String newPasswordRe;
	private UserAcc user;

	public PasswordForm() {
	}

	public String getNewPassword() {
		return newPassword;
	}

	public String getNewPasswordRe() {
		return newPasswordRe;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setNewPassword( String newPassword ) {
		this.newPassword = newPassword;
	}

	public void setNewPasswordRe( String newPasswordRe ) {
		this.newPasswordRe = newPasswordRe;
	}

	public void setOldPassword( String oldPassword ) {
		this.oldPassword = oldPassword;
	}

	public UserAcc getUser() {
		return user;
	}

	public void setUser( UserAcc user ) {
		this.user = user;
	}

}
