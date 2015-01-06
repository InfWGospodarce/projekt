package org.pwr.transporter.server.web.services.purchase;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.purchase.PurchaseInvoiceRow;
import org.pwr.transporter.entity.sales.SalesOrder;
import org.pwr.transporter.server.business.purchase.PurchaseInvoiceRowLogic;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.web.services.IService;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * <pre>
 *  Service delegates for  {@link PurchaseInvoiceRow}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class PurchaseInvoiceRowService implements IService {

    @Autowired
    PurchaseInvoiceRowLogic purchaseInvoiceRowLogic;


    public PurchaseInvoiceRow getByID(Long id) {
        return this.purchaseInvoiceRowLogic.getByID(id);
    }


    public List<SalesOrder> getByDocumentId(Long id) {
        return this.purchaseInvoiceRowLogic.getByDocumentId(id);
    }


    public List<PurchaseInvoiceRow> search(Map<String, Object> parameterMap) {
        return this.purchaseInvoiceRowLogic.search(parameterMap);
    }


    public Long insert(PurchaseInvoiceRow entity) {
        return this.purchaseInvoiceRowLogic.insert(entity);
    }


    public void update(PurchaseInvoiceRow entity) {
        this.purchaseInvoiceRowLogic.update(entity);
    }


    public void delete(PurchaseInvoiceRow entity) {
        this.purchaseInvoiceRowLogic.delete(entity);
    }


    public void deleteById(Long id) {
        this.purchaseInvoiceRowLogic.deleteById(id);
    }


    @SuppressWarnings("unchecked")
    public List<PurchaseInvoiceRow> getListRest(int amount, int fromRow) {
        return this.purchaseInvoiceRowLogic.getListRest(amount, fromRow);
    }


    public long count() {
        return this.purchaseInvoiceRowLogic.count();
    }


    public long count(Criteria criteria) {
        return this.purchaseInvoiceRowLogic.count(criteria);
    }


    @SuppressWarnings("unchecked")
    public List<PurchaseInvoiceRow> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.purchaseInvoiceRowLogic.getListRestCrit(amount, fromRow, criteria);
    }

}
