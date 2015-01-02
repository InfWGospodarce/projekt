package org.pwr.transporter.server.business.sales;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.sales.SalesOrder;
import org.pwr.transporter.server.dao.sales.SalesOrderDAO;



public class SalesOrderLogic {

    SalesOrderDAO salesOrderDAO;


    public void setSalesOrderDAO(SalesOrderDAO salesOrderDAO) {
        this.salesOrderDAO = salesOrderDAO;
    }


    public List<SalesOrder> getByUserId(Long id) {
        return this.salesOrderDAO.getByUserId(id);
    }


    public SalesOrder getByID(Long id) {
        return this.salesOrderDAO.getByID(id);
    }


    public List<SalesOrder> getList() {
        return this.salesOrderDAO.getList();
    }


    public List<SalesOrder> search(Map<String, Object> parameterMap) {
        return this.salesOrderDAO.search(parameterMap);
    }


    public Long insert(SalesOrder entity) {
        return this.salesOrderDAO.insert(entity);
    }


    public void update(SalesOrder entity) {
        this.salesOrderDAO.update(entity);
    }


    public void delete(SalesOrder entity) {
        this.salesOrderDAO.delete(entity);
    }


    public void deleteById(Long id) {
        this.salesOrderDAO.deleteById(id);
    }


    public List<SalesOrder> getListRest(int amount, int fromRow) {
        return this.salesOrderDAO.getListRest(amount, fromRow);
    }


    public long count() {
        return this.salesOrderDAO.count();
    }


    public long count(Map<String, Object> criteria) {
        return this.salesOrderDAO.count(criteria);
    }


    public List<SalesOrder> getListRestCrit(int amount, int fromRow, Map<String, Object> criteria) {
        return this.salesOrderDAO.getListRestCrit(amount, fromRow, criteria);
    }

}
