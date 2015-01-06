package org.pwr.transporter.server.web.services.purchase;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.purchase.PurchaseOrder;
import org.pwr.transporter.server.business.purchase.PurchaseOrderLogic;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.web.services.IService;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * <pre>
 *  Service delegates for  {@link PurchaseOrder}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class PurchaseOrderService implements IService {

    @Autowired
    PurchaseOrderLogic purchaseOrderLogic;


    public List<PurchaseOrder> getByCustomerId(Long id) {
        return this.purchaseOrderLogic.getByCustomerId(id);
    }


    public PurchaseOrder getByID(Long id) {
        return this.purchaseOrderLogic.getByID(id);
    }


    public List<PurchaseOrder> search(Map<String, Object> parameterMap) {
        return this.purchaseOrderLogic.search(parameterMap);
    }


    public Long insert(PurchaseOrder entity) {
        return this.purchaseOrderLogic.insert(entity);
    }


    public void update(PurchaseOrder entity) {
        this.purchaseOrderLogic.update(entity);
    }


    public void delete(PurchaseOrder entity) {
        this.purchaseOrderLogic.delete(entity);
    }


    public void deleteById(Long id) {
        this.purchaseOrderLogic.deleteById(id);
    }


    @SuppressWarnings("unchecked")
    public List<PurchaseOrder> getListRest(int amount, int fromRow) {
        return this.purchaseOrderLogic.getListRest(amount, fromRow);
    }


    public long count() {
        return this.purchaseOrderLogic.count();
    }


    public long count(Criteria criteria) {
        return this.purchaseOrderLogic.count(criteria);
    }


    @SuppressWarnings("unchecked")
    public List<PurchaseOrder> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.purchaseOrderLogic.getListRestCrit(amount, fromRow, criteria);
    }

}
