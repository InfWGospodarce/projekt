package org.pwr.transporter.entity;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @version 0.1.6
 */
@Entity
@Table(name = NamesForHibernate.USER)
public class UserAcc extends GenericEntity {

    /**  */
    private static final long serialVersionUID = 911729503700444961L;

    private static final int SALT_LENGTH = 16;

    private static final Logger LOGGER = Logger.getLogger(UserAcc.class);

    // *******************************************************************************************************************************
    // ****** FIELDS
    // *******************************************************************************************************************************

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "username", updatable = false, unique = true, nullable = false)
    private String username;

    @Column(name = "salt", nullable = false)
    private String salt;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    // , targetEntity = UserRoles.class)
    // @JoinTable(name = "user_roles", joinColumns = { @JoinColumn(name =
    // NamesForHibernate.USER_ROLES_ID, nullable = false, updatable = false) },
    // inverseJoinColumns = { @JoinColumn(name = NamesForHibernate.ROLE_ID,
    // nullable = false, updatable = false) })
    private Set<Role> role;

    @Column(name = "email", nullable = false)
    private String email;

    @OneToOne
    private Customer customer;

    @OneToOne
    private Employee employee;

    @Column(name = "rows_per_page", nullable = false)
    private int rowsPerPage;


    public UserAcc() {
        rowsPerPage = 20;
    }


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
        System.arraycopy(password.getBytes(), 0, input, 0, password.getBytes().length);
        System.arraycopy(salt, 0, input, password.getBytes().length, salt.length);

        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
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
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] salt = nextSalt();
        byte[] salt2 = new byte[username.getBytes().length + salt.length];
        System.arraycopy(salt, 0, salt2, 0, salt.length);
        System.arraycopy(username.getBytes(), 0, salt2, salt.length, username.getBytes().length);
        this.salt = String.valueOf(Hex.encode(salt2));
        byte[] input = new byte[username.getBytes().length + password.getBytes().length + salt2.length];
        System.arraycopy(password.getBytes(), 0, input, 0, password.getBytes().length);
        System.arraycopy(salt2, 0, input, password.getBytes().length, salt2.length);
        byte[] enPass = digest.digest(input);
        this.password = String.valueOf(Hex.encode(enPass));
    }


    public boolean hasRole(String roleName) {
        LOGGER.trace("Lokking for role: " + roleName);
        for( Role rol : role ) {
            LOGGER.trace("\ttest: " + rol.getName());
            if( rol.getName().equals(roleName) ) {
                return true;
            }
        }
        return false;
    }


    public void setPassAndSalt(String password, String salt2) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] salt = Hex.decode(salt2);
            byte[] input = new byte[username.getBytes().length + password.getBytes().length + salt.length];
            System.arraycopy(password.getBytes(), 0, input, 0, password.getBytes().length);
            System.arraycopy(salt, 0, input, password.getBytes().length, salt.length);
            byte[] enPass = digest.digest(input);
            this.password = String.valueOf(Hex.encode(enPass));
        } catch ( NoSuchAlgorithmException e ) {
            LOGGER.error("Cannot declare encryptor", e);
        }

    }


    public void copyPasswordAndSalt(String password, String salt) {
        this.password = password;
        this.salt = salt;

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


    public Employee getEmployee() {
        return this.employee;
    }


    public void setEmployee(Employee emplyee) {
        this.employee = emplyee;
    }


    public int getRowsPerPage() {
        return this.rowsPerPage;
    }


    public void setRowsPerPage(int rowsPerPage) {
        this.rowsPerPage = rowsPerPage;
    }


    public Set<Role> getRole() {
        return this.role;
    }


    public void setRole(Set<Role> role) {
        this.role = role;
    }
}
