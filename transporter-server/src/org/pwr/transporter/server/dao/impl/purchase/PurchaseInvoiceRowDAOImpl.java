package org.pwr.transporter.server.dao.impl.purchase;


import org.pwr.transporter.entity.purchase.PurchaseInvoiceRow;
import org.pwr.transporter.server.dao.impl.GenericDocumentRowDAOImpl;
import org.pwr.transporter.server.dao.purchase.PurchaseInvoiceRowDAO;



/**
 * <pre>
 *     Custom implementations for {@link PurchaseInvoiceRow}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class PurchaseInvoiceRowDAOImpl extends GenericDocumentRowDAOImpl<PurchaseInvoiceRow> implements PurchaseInvoiceRowDAO {

    public PurchaseInvoiceRowDAOImpl() {
        setEntityClass(PurchaseInvoiceRow.class);
    }

}
