package org.pwr.transporter.server.web.services.sales;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.sales.SalesOrder;
import org.pwr.transporter.server.business.sales.SalesOrderLogic;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.web.services.IService;
import org.springframework.beans.factory.annotation.Autowired;



public class SalesOrderService implements IService {

    @Autowired
    SalesOrderLogic salesOrderLogic;


    public List<SalesOrder> getByUserId(Long id) {
        return this.salesOrderLogic.getByUserId(id);
    }


    public SalesOrder getByID(Long id) {
        return this.salesOrderLogic.getByID(id);
    }


    public List<SalesOrder> search(Map<String, Object> parameterMap) {
        return this.salesOrderLogic.search(parameterMap);
    }


    public Long insert(SalesOrder entity) {
        return this.salesOrderLogic.insert(entity);
    }


    public void update(SalesOrder entity) {
        this.salesOrderLogic.update(entity);
    }


    public void delete(SalesOrder entity) {
        this.salesOrderLogic.delete(entity);
    }


    public void deleteById(Long id) {
        this.salesOrderLogic.deleteById(id);
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<SalesOrder> getListRest(int amount, int fromRow) {
        return this.salesOrderLogic.getListRest(amount, fromRow);
    }


    public long count() {
        return this.salesOrderLogic.count();
    }


    @Override
    public long count(Criteria criteria) {
        return this.salesOrderLogic.count(criteria);
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<SalesOrder> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.salesOrderLogic.getListRestCrit(amount, fromRow, criteria);
    }

}
