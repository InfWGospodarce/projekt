package org.pwr.transporter.server.web.services;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.base.TaxItem;
import org.pwr.transporter.server.business.TaxItemLogic;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.springframework.beans.factory.annotation.Autowired;



public class TaxItemService {

    @Autowired
    TaxItemLogic taxItemLogic;


    public TaxItem getByID(Long id) {
        return this.taxItemLogic.getByID(id);
    }


    public List<TaxItem> getList() {
        return this.taxItemLogic.getList();
    }


    public List<TaxItem> search(Map<String, Object> parameterMap) {
        return this.taxItemLogic.search(parameterMap);
    }


    public Long insert(TaxItem entity) {
        return this.taxItemLogic.insert(entity);
    }


    public void update(TaxItem entity) {
        this.taxItemLogic.update(entity);
    }


    public void delete(TaxItem entity) {
        this.taxItemLogic.delete(entity);
    }


    public void deleteById(Long id) {
        this.taxItemLogic.deleteById(id);
    }


    public List<TaxItem> getListRest(int amount, int fromRow) {
        return this.taxItemLogic.getListRest(amount, fromRow);
    }


    public long count() {
        return this.taxItemLogic.count();
    }


    public long count(Criteria criteria) {
        return this.taxItemLogic.count(criteria);
    }


    public List<TaxItem> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.taxItemLogic.getListRestCrit(amount, fromRow, criteria);
    }

}
