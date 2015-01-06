package org.pwr.transporter.server.business.purchase;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.purchase.PurchaseInvoice;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.dao.purchase.PurchaseInvoiceDAO;



/**
 * <pre>
 *  Delegates logic for {@link PurchaseInvoice}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class PurchaseInvoiceLogic {

    PurchaseInvoiceDAO purchaseInvoiceDAO;


    public PurchaseInvoiceDAO getPurchaseInvoiceDAO() {
        return this.purchaseInvoiceDAO;
    }


    public void setPurchaseInvoiceDAO(PurchaseInvoiceDAO purchaseInvoiceDAO) {
        this.purchaseInvoiceDAO = purchaseInvoiceDAO;
    }


    public List<PurchaseInvoice> getByCustomerId(Long id) {
        return this.purchaseInvoiceDAO.getByCustomerId(id);
    }


    public PurchaseInvoice getByID(Long id) {
        return this.purchaseInvoiceDAO.getByID(id);
    }


    public List<PurchaseInvoice> search(Map<String, Object> parameterMap) {
        return this.purchaseInvoiceDAO.search(parameterMap);
    }


    public Long insert(PurchaseInvoice entity) {
        return this.purchaseInvoiceDAO.insert(entity);
    }


    public void update(PurchaseInvoice entity) {
        this.purchaseInvoiceDAO.update(entity);
    }


    public void delete(PurchaseInvoice entity) {
        this.purchaseInvoiceDAO.delete(entity);
    }


    public void deleteById(Long id) {
        this.purchaseInvoiceDAO.deleteById(id);
    }


    public List<PurchaseInvoice> getListRest(int amount, int fromRow) {
        return this.purchaseInvoiceDAO.getListRest(amount, fromRow);
    }


    public long count() {
        return this.purchaseInvoiceDAO.count();
    }


    public long count(Criteria criteria) {
        return this.purchaseInvoiceDAO.count(criteria);
    }


    public List<PurchaseInvoice> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.purchaseInvoiceDAO.getListRestCrit(amount, fromRow, criteria);
    }

}
