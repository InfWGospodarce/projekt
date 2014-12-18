package org.pwr.transporter.entity;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.base.Customer;
import org.pwr.transporter.entity.base.Employee;
import org.springframework.security.crypto.codec.Hex;



/**
 * <pre>
 *    Define users table
 * </pre>
 * <hr/>
 * 
 * @author x0r
 * @version 0.1.2
 */
@Entity
@Table(name = NamesForHibernate.USERS)
public class Users extends GenericEntity {

    /**  */
    private static final long serialVersionUID = 911729503700444961L;

    private static final int SALT_LENGTH = 16;

    private static final Logger LOGGER = Logger.getLogger(Users.class);

    // *******************************************************************************************************************************
    // ****** FIELDS
    // *******************************************************************************************************************************

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "username", updatable = false, unique = true, nullable = false)
    private String username;

    @Column(name = "salt", nullable = false)
    private String salt;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = UserRoles.class)
    @JoinTable(name = "user_roles", joinColumns = { @JoinColumn(name = NamesForHibernate.USER_ROLES_ID, nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = NamesForHibernate.ROLE_ID, nullable = false, updatable = false) })
    private List<Role> roles;

    @Column(name = "email", nullable = false)
    private String email;

    @OneToOne
    private Customer customer;

    @OneToOne
    private Employee emplyee;


    // *******************************************************************************************************************************
    // ****** LOGIC
    // *******************************************************************************************************************************

    public static byte[] nextSalt() throws NoSuchAlgorithmException {
        byte[] salt = new byte[SALT_LENGTH];
        SecureRandom sr = new SecureRandom();
        sr.setSeed(Math.round(Math.random()));
        sr.nextBytes(salt);
        return salt;
    }


    public boolean checkPassword(String password) {
        byte[] salt = Hex.decode(this.salt);
        LOGGER.debug("Salts: \nold: \t" + this.salt + "\ndeco: \t" + String.valueOf(Hex.encode(salt)));
        byte[] input = new byte[username.getBytes().length + password.getBytes().length + salt.length];
        System.arraycopy(salt, 0, input, 0, salt.length);
        System.arraycopy(username.getBytes(), 0, input, salt.length, username.getBytes().length);
        System.arraycopy(password.getBytes(), 0, input, salt.length + username.getBytes().length, password.getBytes().length);
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-512");
            byte[] enPass = digest.digest(input);
            String passwordEn = String.valueOf(Hex.encode(enPass));
            LOGGER.debug("Compare passwords: \nWrote: " + passwordEn + "n\nSawed: " + this.password + "\n"
                    + passwordEn.trim().equals(this.password.trim()));
            if( passwordEn.equals(this.password) ) {
                LOGGER.debug("Matched");
                return true;
            }
        } catch ( NoSuchAlgorithmException e ) {
            LOGGER.error("Cannot encrypt password", e);
        }
        return false;
    }


    private void trySetPassword(String password) throws NoSuchAlgorithmException {
        LOGGER.debug("Setting password, username: " + username);
        MessageDigest digest = MessageDigest.getInstance("SHA-512");
        byte[] salt = nextSalt();
        this.salt = String.valueOf(Hex.encode(salt));
        byte[] input = new byte[username.getBytes().length + password.getBytes().length + salt.length];
        System.arraycopy(salt, 0, input, 0, salt.length);
        System.arraycopy(username.getBytes(), 0, input, salt.length, username.getBytes().length);
        System.arraycopy(password.getBytes(), 0, input, salt.length + username.getBytes().length, password.getBytes().length);
        byte[] enPass = digest.digest(input);
        this.password = String.valueOf(Hex.encode(enPass));
    }


    public boolean hasRole(String roleName) {
        LOGGER.debug("Lokking for role: " + roleName);
        for( Role role : roles ) {
            LOGGER.debug("\ttest: " + role.getName());
            if( role.getName().equals(roleName) ) {
                return true;
            }
        }
        return false;
    }


    // *******************************************************************************************************************************
    // ****** GETTERS AND SETTERS
    // *******************************************************************************************************************************

    public String getPassword() {
        return this.password;
    }


    public void setPassword(String password) {
        try {
            trySetPassword(password);
        } catch ( NoSuchAlgorithmException e ) {
            LOGGER.error("Cannot encrypt password", e);
        }
    }


    public List<Role> getRoles() {
        return this.roles;
    }


    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


    public String getEmail() {
        return this.email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getSalt() {
        return this.salt;
    }


    public String getUsername() {
        return this.username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public Customer getCustomer() {
        return this.customer;
    }


    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public Employee getEmplyee() {
        return this.emplyee;
    }


    public void setEmplyee(Employee emplyee) {
        this.emplyee = emplyee;
    }

}
