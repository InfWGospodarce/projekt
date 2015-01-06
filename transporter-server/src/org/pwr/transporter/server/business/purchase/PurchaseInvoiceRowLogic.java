package org.pwr.transporter.server.business.purchase;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.purchase.PurchaseInvoiceRow;
import org.pwr.transporter.entity.sales.SalesOrder;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.dao.purchase.PurchaseInvoiceRowDAO;



/**
 * <pre>
 *  Delegates logic for {@link PurchaseInvoiceRow}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class PurchaseInvoiceRowLogic {

    PurchaseInvoiceRowDAO purchaseInvoiceRowDAO;


    public PurchaseInvoiceRowDAO getPurchaseInvoiceRowDAO() {
        return this.purchaseInvoiceRowDAO;
    }


    public void setPurchaseInvoiceRowDAO(PurchaseInvoiceRowDAO purchaseInvoiceRowDAO) {
        this.purchaseInvoiceRowDAO = purchaseInvoiceRowDAO;
    }


    public PurchaseInvoiceRow getByID(Long id) {
        return this.purchaseInvoiceRowDAO.getByID(id);
    }


    public List<SalesOrder> getByDocumentId(Long id) {
        return this.purchaseInvoiceRowDAO.getByDocumentId(id);
    }


    public List<PurchaseInvoiceRow> search(Map<String, Object> parameterMap) {
        return this.purchaseInvoiceRowDAO.search(parameterMap);
    }


    public Long insert(PurchaseInvoiceRow entity) {
        return this.purchaseInvoiceRowDAO.insert(entity);
    }


    public void update(PurchaseInvoiceRow entity) {
        this.purchaseInvoiceRowDAO.update(entity);
    }


    public void delete(PurchaseInvoiceRow entity) {
        this.purchaseInvoiceRowDAO.delete(entity);
    }


    public void deleteById(Long id) {
        this.purchaseInvoiceRowDAO.deleteById(id);
    }


    public List<PurchaseInvoiceRow> getListRest(int amount, int fromRow) {
        return this.purchaseInvoiceRowDAO.getListRest(amount, fromRow);
    }


    public long count() {
        return this.purchaseInvoiceRowDAO.count();
    }


    public long count(Criteria criteria) {
        return this.purchaseInvoiceRowDAO.count(criteria);
    }


    public List<PurchaseInvoiceRow> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.purchaseInvoiceRowDAO.getListRestCrit(amount, fromRow, criteria);
    }

}
