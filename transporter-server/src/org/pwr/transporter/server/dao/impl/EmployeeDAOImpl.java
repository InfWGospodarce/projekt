package org.pwr.transporter.server.dao.impl;


import org.pwr.transporter.entity.base.Employee;
import org.pwr.transporter.server.dao.EmployeeDAO;



/**
 * <pre>
 *    Implementation for {@link Employee} db functions.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class EmployeeDAOImpl extends GenericDAOImpl<Employee> implements EmployeeDAO {

    public EmployeeDAOImpl() {
        setEntityClass(Employee.class);
    }
}
