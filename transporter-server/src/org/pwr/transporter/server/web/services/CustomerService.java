package org.pwr.transporter.server.web.services;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.base.Customer;
import org.pwr.transporter.server.business.CustomerLogic;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * <pre>
 *    Service for {@link Customer}
 * </pre>
 * <hr/>
 * 
 * @author x0r
 * @version 0.0.1
 */
public class CustomerService implements IService{

    CustomerLogic customerLogic;


    @Autowired
    public void setCustomerLogic(CustomerLogic customerLogic) {
        this.customerLogic = customerLogic;
    }



    public List<Customer> search(Map<String, Object> parameterMap) {
        return this.customerLogic.search(parameterMap);
    }


    public Long insert(Customer entity) {
        return this.customerLogic.insert(entity);
    }


    public void delete(Customer entity) {
        this.customerLogic.delete(entity);
    }


    public void deleteById(Long id) {
        this.customerLogic.deleteById(id);
    }


    public Customer getById(Long id) {
        return this.customerLogic.getByID(id);
    }



	public Customer getByID(Long id) {
		return customerLogic.getByID(id);
	}



	public void update(Customer entity) {
		customerLogic.update(entity);
	}



	public long count(Criteria criteria) {
		return customerLogic.count(criteria);
	}



	@SuppressWarnings("unchecked")
	public List<Customer> getListRestCrit(int amount, int fromRow,
			Criteria criteria) {
		return customerLogic.getListRestCrit(amount, fromRow, criteria);
	}



	@SuppressWarnings("unchecked")
	public List<Customer> getListRest(int amount, int fromRow) {
		return customerLogic.getListRest(amount, fromRow);
	}



	public long count() {
		return customerLogic.count();
	}

    
}
