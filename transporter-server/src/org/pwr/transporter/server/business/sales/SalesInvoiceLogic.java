package org.pwr.transporter.server.business.sales;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.sales.SalesInvoice;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.dao.sales.SalesInvoiceDAO;



/**
 * <pre>
 *  Delegates logic for {@link SalesInvoice}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class SalesInvoiceLogic {

    SalesInvoiceDAO salesInvoiceDAO;


    public SalesInvoiceDAO getSalesInvoiceDAO() {
        return this.salesInvoiceDAO;
    }


    public void setSalesInvoiceDAO(SalesInvoiceDAO salesInvoiceDAO) {
        this.salesInvoiceDAO = salesInvoiceDAO;
    }


    public List<SalesInvoice> getByCustomerId(Long id) {
        return this.salesInvoiceDAO.getByCustomerId(id);
    }


    public SalesInvoice getByID(Long id) {
        return this.salesInvoiceDAO.getByID(id);
    }


    public List<SalesInvoice> search(Map<String, Object> parameterMap) {
        return this.salesInvoiceDAO.search(parameterMap);
    }


    public Long insert(SalesInvoice entity) {
        return this.salesInvoiceDAO.insert(entity);
    }


    public void update(SalesInvoice entity) {
        this.salesInvoiceDAO.update(entity);
    }


    public void delete(SalesInvoice entity) {
        this.salesInvoiceDAO.delete(entity);
    }


    public void deleteById(Long id) {
        this.salesInvoiceDAO.deleteById(id);
    }


    public List<SalesInvoice> getListRest(int amount, int fromRow) {
        return this.salesInvoiceDAO.getListRest(amount, fromRow);
    }


    public long count() {
        return this.salesInvoiceDAO.count();
    }


    public long count(Criteria criteria) {
        return this.salesInvoiceDAO.count(criteria);
    }


    public List<SalesInvoice> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.salesInvoiceDAO.getListRestCrit(amount, fromRow, criteria);
    }

}
