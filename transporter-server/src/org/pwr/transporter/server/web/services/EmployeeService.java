package org.pwr.transporter.server.web.services;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.base.Employee;
import org.pwr.transporter.server.business.EmployeeLogic;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.dao.base.EmployeeDAO;
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
public class EmployeeService implements IService {

    @Autowired
    EmployeeLogic employeeLogic;


    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeLogic.setEmployeeDAO(employeeDAO);
    }


    public Employee getByID(Long id) {
        return this.employeeLogic.getByID(id);
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


    public long count(Criteria criteria) {
        return this.employeeLogic.count(criteria);
    }


    @SuppressWarnings("unchecked")
    public List<Employee> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.employeeLogic.getListRestCrit(amount, fromRow, criteria);
    }


    @SuppressWarnings("unchecked")
    public List<Employee> getListRest(int amount, int fromRow) {
        return this.employeeLogic.getListRest(amount, fromRow);
    }


    public long count() {
        return this.employeeLogic.count();
    }

}
