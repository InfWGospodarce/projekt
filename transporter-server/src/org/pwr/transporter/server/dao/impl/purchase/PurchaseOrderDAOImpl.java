package org.pwr.transporter.server.dao.impl.purchase;


import org.pwr.transporter.entity.purchase.PurchaseOrder;
import org.pwr.transporter.server.dao.impl.GenericDocumentDAOImpl;
import org.pwr.transporter.server.dao.purchase.PurchaseOrderDAO;



/**
 * <pre>
 *     Custom implementations for {@link PurchaseOrder}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class PurchaseOrderDAOImpl extends GenericDocumentDAOImpl<PurchaseOrder> implements PurchaseOrderDAO {

    public PurchaseOrderDAOImpl() {
        setEntityClass(PurchaseOrder.class);
    }

}
