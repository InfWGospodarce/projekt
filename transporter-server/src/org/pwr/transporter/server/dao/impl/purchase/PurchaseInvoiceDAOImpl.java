package org.pwr.transporter.server.dao.impl.purchase;


import org.pwr.transporter.entity.purchase.PurchaseInvoice;
import org.pwr.transporter.server.dao.impl.GenericDocumentDAOImpl;
import org.pwr.transporter.server.dao.purchase.PurchaseInvoiceDAO;



/**
 * <pre>
 *     Custom implementations for {@link PurchaseInvoice}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class PurchaseInvoiceDAOImpl extends GenericDocumentDAOImpl<PurchaseInvoice> implements PurchaseInvoiceDAO {

    public PurchaseInvoiceDAOImpl() {
        setEntityClass(PurchaseInvoice.class);
    }

}
