package org.pwr.transporter.server.web.services.enums;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.enums.base.EmployeeType;
import org.pwr.transporter.server.business.enums.EmployeeTypeLogic;
import org.pwr.transporter.server.web.services.IService;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * <pre>
 *    Service for {@link EmployeeType}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.2
 */
public class EmployeeTypeService implements IService {

    @Autowired
    EmployeeTypeLogic emplyeeTypeLogic;


    public EmployeeType getByID(Long id) {
        return this.emplyeeTypeLogic.getByID(id);
    }


    public List<EmployeeType> getList() {
        return this.emplyeeTypeLogic.getList();
    }


    public List<EmployeeType> search(Map<String, Object> parameterMap) {
        return this.emplyeeTypeLogic.search(parameterMap);
    }


    public Long insert(EmployeeType entity) {
        return this.emplyeeTypeLogic.insert(entity);
    }


    public void update(EmployeeType entity) {
        this.emplyeeTypeLogic.update(entity);
    }


    public void delete(EmployeeType entity) {
        this.emplyeeTypeLogic.delete(entity);
    }


    public void deleteById(Long id) {
        this.emplyeeTypeLogic.deleteById(id);
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<EmployeeType> getListRest(int amount, int fromRow) {
        return this.emplyeeTypeLogic.getListRest(amount, fromRow);
    }


    @Override
    public long count() {
        return this.emplyeeTypeLogic.count();
    }

}
