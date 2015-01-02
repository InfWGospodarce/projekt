
package org.pwr.transporter.server.dao.impl;


import org.pwr.transporter.entity.base.Customer;
import org.pwr.transporter.server.dao.CustomerDAO;
import org.springframework.stereotype.Repository;



/**
 * <pre>
 *    Implementation of {@link CustomerDAO} extended functions.
 * </pre>
 * <hr/>
 * 
 * @author x0r
 * @version 0.0.1 
 */
@Repository
public class CustomerDAOImpl extends GenericDAOImpl<Customer> implements CustomerDAO {

    public CustomerDAOImpl() {
        System.out.println("Creating Customer dao impl");
        setEntityClass(Customer.class);
    }

}
