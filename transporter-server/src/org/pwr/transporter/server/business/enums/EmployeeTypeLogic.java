package org.pwr.transporter.server.business.enums;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.enums.base.EmplyeeType;
import org.pwr.transporter.server.dao.enums.EmployeeTypeDAO;



/**
 * <pre>
 *    Logic for {@link EmplyeeType}
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


    public EmplyeeType getByID(Long id) {
        return this.employeeTypeDAO.getByID(id);
    }


    public List<EmplyeeType> getList() {
        return this.employeeTypeDAO.getList();
    }


    public List<EmplyeeType> search(Map<String, Object> parameterMap) {
        return this.employeeTypeDAO.search(parameterMap);
    }


    public Long insert(EmplyeeType entity) {
        return this.employeeTypeDAO.insert(entity);
    }


    public void update(EmplyeeType entity) {
        this.employeeTypeDAO.update(entity);
    }


    public void delete(EmplyeeType entity) {
        this.employeeTypeDAO.delete(entity);
    }


    public void deleteById(Long id) {
        this.employeeTypeDAO.deleteById(id);
    }


    public List<EmplyeeType> getListRest(long amount, long fromRow) {
        return this.employeeTypeDAO.getListRest(amount, fromRow);
    }


    public long count() {
        return this.employeeTypeDAO.count();
    }

}
