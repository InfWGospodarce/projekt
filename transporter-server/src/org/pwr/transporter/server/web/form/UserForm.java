package org.pwr.transporter.server.web.form;


/**
 * <pre>
 *    Form class used for login.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class UserForm {

    private String username;
    private String password;


    public String getPassword() {
        return this.password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getUsername() {
        return this.username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

}
