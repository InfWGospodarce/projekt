package org.pwr.transporter.server.business.sales;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.sales.SalesOrder;
import org.pwr.transporter.entity.sales.SalesOrderRow;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.dao.sales.SalesOrderRowDAO;



/**
 * <pre>
 *  Delegates logic for {@link SalesOrderRow}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class SalesOrderRowLogic {

    SalesOrderRowDAO salesOrderRowDAO;


    public SalesOrderRowDAO getSalesOrderRowDAO() {
        return this.salesOrderRowDAO;
    }


    public void setSalesOrderRowDAO(SalesOrderRowDAO salesOrderRowDAO) {
        this.salesOrderRowDAO = salesOrderRowDAO;
    }


    public SalesOrderRow getByID(Long id) {
        return this.salesOrderRowDAO.getByID(id);
    }


    public List<SalesOrder> getByDocumentId(Long id) {
        return this.salesOrderRowDAO.getByDocumentId(id);
    }


    public List<SalesOrderRow> search(Map<String, Object> parameterMap) {
        return this.salesOrderRowDAO.search(parameterMap);
    }


    public Long insert(SalesOrderRow entity) {
        return this.salesOrderRowDAO.insert(entity);
    }


    public void update(SalesOrderRow entity) {
        this.salesOrderRowDAO.update(entity);
    }


    public void delete(SalesOrderRow entity) {
        this.salesOrderRowDAO.delete(entity);
    }


    public void deleteById(Long id) {
        this.salesOrderRowDAO.deleteById(id);
    }


    public List<SalesOrderRow> getListRest(int amount, int fromRow) {
        return this.salesOrderRowDAO.getListRest(amount, fromRow);
    }


    public long count() {
        return this.salesOrderRowDAO.count();
    }


    public long count(Criteria criteria) {
        return this.salesOrderRowDAO.count(criteria);
    }


    public List<SalesOrderRow> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.salesOrderRowDAO.getListRestCrit(amount, fromRow, criteria);
    }

}
