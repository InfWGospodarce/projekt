package org.pwr.transporter.server.business.purchase;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.purchase.PurchaseOrderRow;
import org.pwr.transporter.entity.sales.SalesOrder;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.dao.purchase.PurchaseOrderRowDAO;



/**
 * <pre>
 *  Delegates logic for {@link PurchaseOrderRow}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class PurchaseOrderRowLogic {

    PurchaseOrderRowDAO purchaseOrderRowDAO;


    public PurchaseOrderRowDAO getPurchaseOrderRowDAO() {
        return this.purchaseOrderRowDAO;
    }


    public void setPurchaseOrderRowDAO(PurchaseOrderRowDAO purchaseOrderRowDAO) {
        this.purchaseOrderRowDAO = purchaseOrderRowDAO;
    }


    public PurchaseOrderRow getByID(Long id) {
        return this.purchaseOrderRowDAO.getByID(id);
    }


    public List<SalesOrder> getByDocumentId(Long id) {
        return this.purchaseOrderRowDAO.getByDocumentId(id);
    }


    public List<PurchaseOrderRow> search(Map<String, Object> parameterMap) {
        return this.purchaseOrderRowDAO.search(parameterMap);
    }


    public Long insert(PurchaseOrderRow entity) {
        return this.purchaseOrderRowDAO.insert(entity);
    }


    public void update(PurchaseOrderRow entity) {
        this.purchaseOrderRowDAO.update(entity);
    }


    public void delete(PurchaseOrderRow entity) {
        this.purchaseOrderRowDAO.delete(entity);
    }


    public void deleteById(Long id) {
        this.purchaseOrderRowDAO.deleteById(id);
    }


    public List<PurchaseOrderRow> getListRest(int amount, int fromRow) {
        return this.purchaseOrderRowDAO.getListRest(amount, fromRow);
    }


    public long count() {
        return this.purchaseOrderRowDAO.count();
    }


    public long count(Criteria criteria) {
        return this.purchaseOrderRowDAO.count(criteria);
    }


    public List<PurchaseOrderRow> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.purchaseOrderRowDAO.getListRestCrit(amount, fromRow, criteria);
    }

}
