package org.pwr.transporter.server.web.services;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.base.Currency;
import org.pwr.transporter.entity.base.Unit;
import org.pwr.transporter.server.business.UnitLogic;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * <pre>
 *       Service delagates for {@link Currency}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class UnitService implements IService {

    @Autowired
    UnitLogic unitLogic;


    public Unit getByID(Long id) {
        return this.unitLogic.getByID(id);
    }


    public List<Unit> search(Map<String, Object> parameterMap) {
        return this.unitLogic.search(parameterMap);
    }


    public Long insert(Unit entity) {
        return this.unitLogic.insert(entity);
    }


    public void update(Unit entity) {
        this.unitLogic.update(entity);
    }


    public void delete(Unit entity) {
        this.unitLogic.delete(entity);
    }


    public void deleteById(Long id) {
        this.unitLogic.deleteById(id);
    }


    @SuppressWarnings("unchecked")
    public List<Unit> getListRest(int amount, int fromRow) {
        return this.unitLogic.getListRest(amount, fromRow);
    }


    public long count() {
        return this.unitLogic.count();
    }


    public long count(Criteria criteria) {
        return this.unitLogic.count(criteria);
    }


    @SuppressWarnings("unchecked")
    public List<Unit> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.unitLogic.getListRestCrit(amount, fromRow, criteria);
    }


    public Object getList() {
        return this.unitLogic.getList();
    }

}
