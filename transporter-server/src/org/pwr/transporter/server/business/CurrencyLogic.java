package org.pwr.transporter.server.business;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.base.Currency;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.dao.CurrencyDAO;



/**
 * <pre>
 *    Delegates logic for {@link Currency}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class CurrencyLogic {

    CurrencyDAO currencyDAO;


    public CurrencyDAO getCurrencyDAO() {
        return this.currencyDAO;
    }


    public void setCurrencyDAO(CurrencyDAO currencyDAO) {
        this.currencyDAO = currencyDAO;
    }


    public Currency getByID(Long id) {
        return this.currencyDAO.getByID(id);
    }


    public List<Currency> search(Map<String, Object> parameterMap) {
        return this.currencyDAO.search(parameterMap);
    }


    public Long insert(Currency entity) {
        return this.currencyDAO.insert(entity);
    }


    public void update(Currency entity) {
        this.currencyDAO.update(entity);
    }


    public void delete(Currency entity) {
        this.currencyDAO.delete(entity);
    }


    public void deleteById(Long id) {
        this.currencyDAO.deleteById(id);
    }


    public List<Currency> getListRest(int amount, int fromRow) {
        return this.currencyDAO.getListRest(amount, fromRow);
    }


    public long count() {
        return this.currencyDAO.count();
    }


    public long count(Criteria criteria) {
        return this.currencyDAO.count(criteria);
    }


    public List<Currency> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.currencyDAO.getListRestCrit(amount, fromRow, criteria);
    }


    @SuppressWarnings("deprecation")
    public Object getList() {
        return this.currencyDAO.getList();
    }

}
