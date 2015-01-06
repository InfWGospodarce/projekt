package org.pwr.transporter.server.business;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.base.Unit;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.dao.base.UnitDAO;



/**
 * <pre>
 *    Delegates logic for {@link Unit}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class UnitLogic {

    UnitDAO unitDAO;


    public UnitDAO getUnitDAO() {
        return this.unitDAO;
    }


    public void setUnitDAO(UnitDAO unitDAO) {
        this.unitDAO = unitDAO;
    }


    public Unit getByID(Long id) {
        return this.unitDAO.getByID(id);
    }


    public List<Unit> search(Map<String, Object> parameterMap) {
        return this.unitDAO.search(parameterMap);
    }


    public Long insert(Unit entity) {
        return this.unitDAO.insert(entity);
    }


    public void update(Unit entity) {
        this.unitDAO.update(entity);
    }


    public void delete(Unit entity) {
        this.unitDAO.delete(entity);
    }


    public void deleteById(Long id) {
        this.unitDAO.deleteById(id);
    }


    public List<Unit> getListRest(int amount, int fromRow) {
        return this.unitDAO.getListRest(amount, fromRow);
    }


    public long count() {
        return this.unitDAO.count();
    }


    public long count(Criteria criteria) {
        return this.unitDAO.count(criteria);
    }


    public List<Unit> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.unitDAO.getListRestCrit(amount, fromRow, criteria);
    }


    @SuppressWarnings("deprecation")
    public Object getList() {
        return this.unitDAO.getList();
    }

}
