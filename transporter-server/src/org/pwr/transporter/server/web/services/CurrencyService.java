package org.pwr.transporter.server.web.services;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.base.Currency;
import org.pwr.transporter.server.business.CurrencyLogic;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * <pre>
 *    Service delagates for {@link Currency}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class CurrencyService implements IService {

    @Autowired
    CurrencyLogic currencyLogic;


    public Currency getByID(Long id) {
        return this.currencyLogic.getByID(id);
    }


    public List<Currency> search(Map<String, Object> parameterMap) {
        return this.currencyLogic.search(parameterMap);
    }


    public Long insert(Currency entity) {
        return this.currencyLogic.insert(entity);
    }


    public void update(Currency entity) {
        this.currencyLogic.update(entity);
    }


    public void delete(Currency entity) {
        this.currencyLogic.delete(entity);
    }


    public void deleteById(Long id) {
        this.currencyLogic.deleteById(id);
    }


    @SuppressWarnings("unchecked")
    public List<Currency> getListRest(int amount, int fromRow) {
        return this.currencyLogic.getListRest(amount, fromRow);
    }


    public long count() {
        return this.currencyLogic.count();
    }


    public long count(Criteria criteria) {
        return this.currencyLogic.count(criteria);
    }


    @SuppressWarnings("unchecked")
    public List<Currency> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.currencyLogic.getListRestCrit(amount, fromRow, criteria);
    }


    public Object getList() {
        return this.currencyLogic.getList();
    }

}
