package org.pwr.transporter.server.dao.impl.purchase;


import org.pwr.transporter.entity.purchase.PurchaseOrderRow;
import org.pwr.transporter.server.dao.impl.GenericDocumentRowDAOImpl;
import org.pwr.transporter.server.dao.purchase.PurchaseOrderRowDAO;



/**
 * <pre>
 *     Custom implementations for {@link PurchaseOrderRow}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class PurchaseOrderRowDAOImpl extends GenericDocumentRowDAOImpl<PurchaseOrderRow> implements PurchaseOrderRowDAO {

    public PurchaseOrderRowDAOImpl() {
        setEntityClass(PurchaseOrderRow.class);
    }

}
