package org.pwr.transporter.server.business;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.base.Customer;
import org.pwr.transporter.server.dao.CustomerDAO;



public class CustomerLogic {

    CustomerDAO customerDAO;


    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }


    public CustomerLogic() {
        System.out.println("Creating Customer logic");
    }


    public Customer getByID(Long id) {
        return this.customerDAO.getByID(id);
    }


    public List<Customer> getList() {
        return this.customerDAO.getList();
    }


    public List<Customer> search(Map<String, Object> parameterMap) {
        return this.customerDAO.search(parameterMap);
    }


    public Long insert(Customer entity) {
        entity.setSearchKey(entity.getName() + " " + entity.getSurname());
        return this.customerDAO.insert(entity);
    }


    public void update(Customer entity) {
        this.customerDAO.update(entity);
    }


    public void delete(Customer entity) {
        this.customerDAO.delete(entity);
    }


    public void deleteById(Long id) {
        this.customerDAO.deleteById(id);
    }

}
