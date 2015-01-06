package org.pwr.transporter.server.business.sales;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.sales.SalesOrder;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.dao.sales.SalesOrderDAO;



/**
 * <pre>
 *    Logic delegate for {@link SalesOrder}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class SalesOrderLogic {

    SalesOrderDAO salesOrderDAO;


    public void setSalesOrderDAO(SalesOrderDAO salesOrderDAO) {
        this.salesOrderDAO = salesOrderDAO;
    }


    public SalesOrder getByID(Long id) {
        return this.salesOrderDAO.getByID(id);
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


    public long count(Criteria criteria) {
        return this.salesOrderDAO.count(criteria);
    }


    public List<SalesOrder> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.salesOrderDAO.getListRestCrit(amount, fromRow, criteria);
    }


    public List<SalesOrder> getByCustomerId(Long id) {
        return this.salesOrderDAO.getByCustomerId(id);
    }

}
