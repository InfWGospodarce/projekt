package org.pwr.transporter.server.web.form;


import java.util.List;

import org.pwr.transporter.entity.UserAcc;
import org.pwr.transporter.entity.base.Address;
import org.pwr.transporter.entity.base.Customer;
import org.pwr.transporter.entity.base.Employee;



/**
 * <pre>
 *    Form for registration customer
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.5
 */
public class CustomerAccountForm {

    Customer customer;
    Address baseAddress;
    Address correspondeAddress;
    UserAcc user;
    String password;
    String password2;
    String employeeTypeId;
    List<String> userRoleIds;
    Employee employee;
    boolean corespondeAddress;


    public CustomerAccountForm() {
        customer = null;
        employee = null;
        baseAddress = new Address();
        correspondeAddress = new Address();
        user = new UserAcc();
        corespondeAddress = false;
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


    public UserAcc getUser() {
        return this.user;
    }


    public void setUser(UserAcc user) {
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


    public Employee getEmployee() {
        return this.employee;
    }


    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    public String getEmployeeTypeId() {
        return this.employeeTypeId;
    }


    public void setEmployeeTypeId(String employeeTypeId) {
        this.employeeTypeId = employeeTypeId;
    }


    public List<String> getUserRoleIds() {
        return this.userRoleIds;
    }


    public void setUserRoleIds(List<String> userRoleIds) {
        this.userRoleIds = userRoleIds;
    }
}
