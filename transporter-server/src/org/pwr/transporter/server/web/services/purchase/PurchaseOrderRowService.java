package org.pwr.transporter.server.web.services.purchase;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.purchase.PurchaseOrderRow;
import org.pwr.transporter.entity.sales.SalesOrder;
import org.pwr.transporter.server.business.purchase.PurchaseOrderRowLogic;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.web.services.IService;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * <pre>
 *  Service delegates for  {@link PurchaseOrderRow}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class PurchaseOrderRowService implements IService {

    @Autowired
    PurchaseOrderRowLogic purchaseOrderRowLogic;


    public PurchaseOrderRow getByID(Long id) {
        return this.purchaseOrderRowLogic.getByID(id);
    }


    public List<SalesOrder> getByDocumentId(Long id) {
        return this.purchaseOrderRowLogic.getByDocumentId(id);
    }


    public List<PurchaseOrderRow> search(Map<String, Object> parameterMap) {
        return this.purchaseOrderRowLogic.search(parameterMap);
    }


    public Long insert(PurchaseOrderRow entity) {
        return this.purchaseOrderRowLogic.insert(entity);
    }


    public void update(PurchaseOrderRow entity) {
        this.purchaseOrderRowLogic.update(entity);
    }


    public void delete(PurchaseOrderRow entity) {
        this.purchaseOrderRowLogic.delete(entity);
    }


    public void deleteById(Long id) {
        this.purchaseOrderRowLogic.deleteById(id);
    }


    @SuppressWarnings("unchecked")
    public List<PurchaseOrderRow> getListRest(int amount, int fromRow) {
        return this.purchaseOrderRowLogic.getListRest(amount, fromRow);
    }


    public long count() {
        return this.purchaseOrderRowLogic.count();
    }


    public long count(Criteria criteria) {
        return this.purchaseOrderRowLogic.count(criteria);
    }


    @SuppressWarnings("unchecked")
    public List<PurchaseOrderRow> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.purchaseOrderRowLogic.getListRestCrit(amount, fromRow, criteria);
    }

}
