package org.pwr.transporter.server.business;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.base.Employee;
import org.pwr.transporter.server.dao.EmployeeDAO;



/**
 * <pre>
 *    Business logic for {@link Employee} entity.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class EmployeeLogic {

    EmployeeDAO employeeDAO;


    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }


    public Employee getByID(Long id) {
        return this.employeeDAO.getByID(id);
    }


    public List<Employee> getList() {
        return this.employeeDAO.getList();
    }


    public List<Employee> search(Map<String, Object> parameterMap) {
        return this.employeeDAO.search(parameterMap);
    }


    public Long insert(Employee entity) {
        return this.employeeDAO.insert(entity);
    }


    public void update(Employee entity) {
        this.employeeDAO.update(entity);
    }


    public void delete(Employee entity) {
        this.employeeDAO.delete(entity);
    }


    public void deleteById(Long id) {
        this.employeeDAO.deleteById(id);
    }
}
