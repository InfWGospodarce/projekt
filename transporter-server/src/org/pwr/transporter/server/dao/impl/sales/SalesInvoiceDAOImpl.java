package org.pwr.transporter.server.dao.impl.sales;


import org.pwr.transporter.entity.sales.SalesInvoice;
import org.pwr.transporter.server.dao.impl.GenericDocumentDAOImpl;
import org.pwr.transporter.server.dao.sales.SalesInvoiceDAO;



/**
 * <pre>
 *     Custom implementations for {@link SalesInvoice}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class SalesInvoiceDAOImpl extends GenericDocumentDAOImpl<SalesInvoice> implements SalesInvoiceDAO {

    public SalesInvoiceDAOImpl() {
        setEntityClass(SalesInvoice.class);
    }

}
