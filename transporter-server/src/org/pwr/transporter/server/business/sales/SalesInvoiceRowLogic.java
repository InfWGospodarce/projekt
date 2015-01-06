package org.pwr.transporter.server.business.sales;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.sales.SalesInvoiceRow;
import org.pwr.transporter.entity.sales.SalesOrder;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.dao.sales.SalesInvoiceRowDAO;



/**
 * <pre>
 *  Delegates logic for {@link SalesInvoiceRow}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class SalesInvoiceRowLogic {

    SalesInvoiceRowDAO salesInvoiceRowDAO;


    public SalesInvoiceRowDAO getSalesInvoiceRowDAO() {
        return this.salesInvoiceRowDAO;
    }


    public void setSalesInvoiceRowDAO(SalesInvoiceRowDAO salesInvoiceRowDAO) {
        this.salesInvoiceRowDAO = salesInvoiceRowDAO;
    }


    public SalesInvoiceRow getByID(Long id) {
        return this.salesInvoiceRowDAO.getByID(id);
    }


    public List<SalesOrder> getByDocumentId(Long id) {
        return this.salesInvoiceRowDAO.getByDocumentId(id);
    }


    public List<SalesInvoiceRow> search(Map<String, Object> parameterMap) {
        return this.salesInvoiceRowDAO.search(parameterMap);
    }


    public Long insert(SalesInvoiceRow entity) {
        return this.salesInvoiceRowDAO.insert(entity);
    }


    public void update(SalesInvoiceRow entity) {
        this.salesInvoiceRowDAO.update(entity);
    }


    public void delete(SalesInvoiceRow entity) {
        this.salesInvoiceRowDAO.delete(entity);
    }


    public void deleteById(Long id) {
        this.salesInvoiceRowDAO.deleteById(id);
    }


    public List<SalesInvoiceRow> getListRest(int amount, int fromRow) {
        return this.salesInvoiceRowDAO.getListRest(amount, fromRow);
    }


    public long count() {
        return this.salesInvoiceRowDAO.count();
    }


    public long count(Criteria criteria) {
        return this.salesInvoiceRowDAO.count(criteria);
    }


    public List<SalesInvoiceRow> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.salesInvoiceRowDAO.getListRestCrit(amount, fromRow, criteria);
    }

}
