package org.pwr.transporter.server.web.form;


import org.pwr.transporter.entity.Users;
import org.pwr.transporter.entity.base.Address;
import org.pwr.transporter.entity.base.Customer;



/**
 * <pre>
 *    Form for registration customer
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.4
 */
public class CustomerAccountForm {

    Customer customer;
    Address baseAddress;
    Address correspondeAddress;
    Users user;
    String password;
    String password2;
    boolean corespondeAddress;


    public CustomerAccountForm() {
        customer = new Customer();
        baseAddress = new Address();
        correspondeAddress = new Address();
        user = new Users();
    }


    public Customer getCustomer() {
        return this.customer;
    }


    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public Address getBaseAddress() {
        return this.baseAddress;
    }


    public void setBaseAddress(Address baseAddress) {
        this.baseAddress = baseAddress;
    }


    public Address getCorrespondeAddress() {
        return this.correspondeAddress;
    }


    public void setCorrespondeAddress(Address correspondeAddress) {
        this.correspondeAddress = correspondeAddress;
    }


    public Users getUser() {
        return this.user;
    }


    public void setUser(Users user) {
        this.user = user;
    }


    public String getPassword() {
        return this.password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getPassword2() {
        return this.password2;
    }


    public void setPassword2(String password2) {
        this.password2 = password2;
    }


    public boolean isCorespondeAddress() {
        return this.corespondeAddress;
    }


    public void setCorespondeAddress(boolean corespondeAddress) {
        this.corespondeAddress = corespondeAddress;
    }

}
