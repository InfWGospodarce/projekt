package org.pwr.transporter.server.business;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.base.Customer;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
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


    public List<Customer> search(Map<String, Object> parameterMap) {
        return this.customerDAO.search(parameterMap);
    }


    public Long insert(Customer entity) {
        entity.setSearchKey(entity.getSurname() + " " + entity.getName());
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


    public long count(Criteria criteria) {
        return this.customerDAO.count(criteria);
    }


    public List<Customer> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.customerDAO.getListRestCrit(amount, fromRow, criteria);
    }


    public List<Customer> getListRest(int amount, int fromRow) {
        return this.customerDAO.getListRest(amount, fromRow);
    }


    public long count() {
        return this.customerDAO.count();
    }

}
