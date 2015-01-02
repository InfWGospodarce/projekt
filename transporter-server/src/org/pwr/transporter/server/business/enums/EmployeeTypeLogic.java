package org.pwr.transporter.server.business.enums;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.enums.base.EmployeeType;
import org.pwr.transporter.server.dao.enums.EmployeeTypeDAO;



/**
 * <pre>
 *    Logic for {@link EmployeeType}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.2
 */
public class EmployeeTypeLogic {

    EmployeeTypeDAO employeeTypeDAO;


    public void setEmployeeTypeDAO(EmployeeTypeDAO employeeTypeDAO) {
        this.employeeTypeDAO = employeeTypeDAO;
    }


    public EmployeeType getByID(Long id) {
        return this.employeeTypeDAO.getByID(id);
    }


    public List<EmployeeType> getList() {
        return this.employeeTypeDAO.getList();
    }


    public List<EmployeeType> search(Map<String, Object> parameterMap) {
        return this.employeeTypeDAO.search(parameterMap);
    }


    public Long insert(EmployeeType entity) {
        return this.employeeTypeDAO.insert(entity);
    }


    public void update(EmployeeType entity) {
        this.employeeTypeDAO.update(entity);
    }


    public void delete(EmployeeType entity) {
        this.employeeTypeDAO.delete(entity);
    }


    public void deleteById(Long id) {
        this.employeeTypeDAO.deleteById(id);
    }


    public List<EmployeeType> getListRest(int amount, int fromRow) {
        return this.employeeTypeDAO.getListRest(amount, fromRow);
    }


    public long count() {
        return this.employeeTypeDAO.count();
    }


    public long count(Map<String, Object> criteria) {
        return this.employeeTypeDAO.count(criteria);
    }


    public List<EmployeeType> getListRestCrit(int amount, int fromRow, Map<String, Object> criteria) {
        return this.employeeTypeDAO.getListRestCrit(amount, fromRow, criteria);
    }

}
