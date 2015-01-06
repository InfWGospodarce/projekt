package org.pwr.transporter.server.web.services.purchase;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.purchase.PurchaseInvoice;
import org.pwr.transporter.server.business.purchase.PurchaseInvoiceLogic;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.web.services.IService;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * <pre>
 *  Service delegates for  {@link PurchaseInvoice}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class PurchaseInvoiceService implements IService {

    @Autowired
    PurchaseInvoiceLogic purchaseInvoiceLogic;


    public List<PurchaseInvoice> getByCustomerId(Long id) {
        return this.purchaseInvoiceLogic.getByCustomerId(id);
    }


    public PurchaseInvoice getByID(Long id) {
        return this.purchaseInvoiceLogic.getByID(id);
    }


    public List<PurchaseInvoice> search(Map<String, Object> parameterMap) {
        return this.purchaseInvoiceLogic.search(parameterMap);
    }


    public Long insert(PurchaseInvoice entity) {
        return this.purchaseInvoiceLogic.insert(entity);
    }


    public void update(PurchaseInvoice entity) {
        this.purchaseInvoiceLogic.update(entity);
    }


    public void delete(PurchaseInvoice entity) {
        this.purchaseInvoiceLogic.delete(entity);
    }


    public void deleteById(Long id) {
        this.purchaseInvoiceLogic.deleteById(id);
    }


    @SuppressWarnings("unchecked")
    public List<PurchaseInvoice> getListRest(int amount, int fromRow) {
        return this.purchaseInvoiceLogic.getListRest(amount, fromRow);
    }


    public long count() {
        return this.purchaseInvoiceLogic.count();
    }


    public long count(Criteria criteria) {
        return this.purchaseInvoiceLogic.count(criteria);
    }


    @SuppressWarnings("unchecked")
    public List<PurchaseInvoice> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.purchaseInvoiceLogic.getListRestCrit(amount, fromRow, criteria);
    }

}
