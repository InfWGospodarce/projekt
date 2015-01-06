package org.pwr.transporter.server.business.purchase;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.purchase.PurchaseOrder;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.dao.purchase.PurchaseOrderDAO;



/**
 * <pre>
 *  Delegates logic for {@link PurchaseOrder}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class PurchaseOrderLogic {

    PurchaseOrderDAO purchaseOrderDAO;


    public PurchaseOrderDAO getPurchaseOrderDAO() {
        return this.purchaseOrderDAO;
    }


    public void setPurchaseOrderDAO(PurchaseOrderDAO purchaseOrderDAO) {
        this.purchaseOrderDAO = purchaseOrderDAO;
    }


    public List<PurchaseOrder> getByCustomerId(Long id) {
        return this.purchaseOrderDAO.getByCustomerId(id);
    }


    public PurchaseOrder getByID(Long id) {
        return this.purchaseOrderDAO.getByID(id);
    }


    public List<PurchaseOrder> search(Map<String, Object> parameterMap) {
        return this.purchaseOrderDAO.search(parameterMap);
    }


    public Long insert(PurchaseOrder entity) {
        return this.purchaseOrderDAO.insert(entity);
    }


    public void update(PurchaseOrder entity) {
        this.purchaseOrderDAO.update(entity);
    }


    public void delete(PurchaseOrder entity) {
        this.purchaseOrderDAO.delete(entity);
    }


    public void deleteById(Long id) {
        this.purchaseOrderDAO.deleteById(id);
    }


    public List<PurchaseOrder> getListRest(int amount, int fromRow) {
        return this.purchaseOrderDAO.getListRest(amount, fromRow);
    }


    public long count() {
        return this.purchaseOrderDAO.count();
    }


    public long count(Criteria criteria) {
        return this.purchaseOrderDAO.count(criteria);
    }


    public List<PurchaseOrder> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.purchaseOrderDAO.getListRestCrit(amount, fromRow, criteria);
    }

}
