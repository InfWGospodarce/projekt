package org.pwr.transporter.server.business;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.base.Employee;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.dao.base.EmployeeDAO;



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


    public List<Employee> search(Map<String, Object> parameterMap) {
        return this.employeeDAO.search(parameterMap);
    }


    public Long insert(Employee entity) {
        entity.setSearchKey(entity.getSurname() + " " + entity.getName());
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


    public long count(Criteria criteria) {
        return this.employeeDAO.count(criteria);
    }


    public List<Employee> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.employeeDAO.getListRestCrit(amount, fromRow, criteria);
    }


    public List<Employee> getListRest(int amount, int fromRow) {
        return this.employeeDAO.getListRest(amount, fromRow);
    }


    public long count() {
        return this.employeeDAO.count();
    }

}
