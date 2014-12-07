package org.pwr.transporter.server.web.services;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.base.Employee;
import org.pwr.transporter.server.business.EmployeeLogic;
import org.pwr.transporter.server.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * <pre>
 *    Service for {@link Employee} entity.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class EmployeeService {

    @Autowired
    EmployeeLogic employeeLogic;


    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeLogic.setEmployeeDAO(employeeDAO);
    }


    public Employee getByID(Long id) {
        return this.employeeLogic.getByID(id);
    }


    public List<Employee> getList() {
        return this.employeeLogic.getList();
    }


    public List<Employee> search(Map<String, Object> parameterMap) {
        return this.employeeLogic.search(parameterMap);
    }


    public Long insert(Employee entity) {
        return this.employeeLogic.insert(entity);
    }


    public void update(Employee entity) {
        this.employeeLogic.update(entity);
    }


    public void delete(Employee entity) {
        this.employeeLogic.delete(entity);
    }


    public void deleteById(Long id) {
        this.employeeLogic.deleteById(id);
    }

}
