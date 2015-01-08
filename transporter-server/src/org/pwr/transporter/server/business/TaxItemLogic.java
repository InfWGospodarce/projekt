package org.pwr.transporter.server.business;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.base.TaxItem;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.dao.base.TaxItemDAO;



public class TaxItemLogic {

    TaxItemDAO taxItemDAO;


    public void setTaxItemDAO(TaxItemDAO taxItemDAO) {
        this.taxItemDAO = taxItemDAO;
    }


    public TaxItem getByID(Long id) {
        return this.taxItemDAO.getByID(id);
    }


    @SuppressWarnings("deprecation")
    public List<TaxItem> getList() {
        return this.taxItemDAO.getList();
    }


    public List<TaxItem> search(Map<String, Object> parameterMap) {
        return this.taxItemDAO.search(parameterMap);
    }


    public Long insert(TaxItem entity) {
        return this.taxItemDAO.insert(entity);
    }


    public void update(TaxItem entity) {
        this.taxItemDAO.update(entity);
    }


    public void delete(TaxItem entity) {
        this.taxItemDAO.delete(entity);
    }


    public void deleteById(Long id) {
        this.taxItemDAO.deleteById(id);
    }


    public List<TaxItem> getListRest(int amount, int fromRow) {
        return this.taxItemDAO.getListRest(amount, fromRow);
    }


    public long count() {
        return this.taxItemDAO.count();
    }


    public long count(Criteria criteria) {
        return this.taxItemDAO.count(criteria);
    }


    public List<TaxItem> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.taxItemDAO.getListRestCrit(amount, fromRow, criteria);
    }

}
