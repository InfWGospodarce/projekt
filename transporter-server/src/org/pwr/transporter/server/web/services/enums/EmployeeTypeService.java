package org.pwr.transporter.server.web.services.enums;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.enums.base.EmplyeeType;
import org.pwr.transporter.server.business.enums.EmployeeTypeLogic;
import org.pwr.transporter.server.web.services.IService;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * <pre>
 *    Service for {@link EmplyeeType}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.2
 */
public class EmployeeTypeService implements IService {

    @Autowired
    EmployeeTypeLogic emplyeeTypeLogic;


    public EmplyeeType getByID(Long id) {
        return this.emplyeeTypeLogic.getByID(id);
    }


    public List<EmplyeeType> getList() {
        return this.emplyeeTypeLogic.getList();
    }


    public List<EmplyeeType> search(Map<String, Object> parameterMap) {
        return this.emplyeeTypeLogic.search(parameterMap);
    }


    public Long insert(EmplyeeType entity) {
        return this.emplyeeTypeLogic.insert(entity);
    }


    public void update(EmplyeeType entity) {
        this.emplyeeTypeLogic.update(entity);
    }


    public void delete(EmplyeeType entity) {
        this.emplyeeTypeLogic.delete(entity);
    }


    public void deleteById(Long id) {
        this.emplyeeTypeLogic.deleteById(id);
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<EmplyeeType> getListRest(long amount, long fromRow) {
        return this.emplyeeTypeLogic.getListRest(amount, fromRow);
    }


    @Override
    public long count() {
        return this.emplyeeTypeLogic.count();
    }

}
