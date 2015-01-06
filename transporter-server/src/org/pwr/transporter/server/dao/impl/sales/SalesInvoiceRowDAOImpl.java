package org.pwr.transporter.server.dao.impl.sales;


import org.pwr.transporter.entity.sales.SalesInvoiceRow;
import org.pwr.transporter.server.dao.impl.GenericDocumentRowDAOImpl;
import org.pwr.transporter.server.dao.sales.SalesInvoiceRowDAO;



/**
 * <pre>
 *     Custom implementations for {@link SalesInvoiceRow}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class SalesInvoiceRowDAOImpl extends GenericDocumentRowDAOImpl<SalesInvoiceRow> implements SalesInvoiceRowDAO {

    public SalesInvoiceRowDAOImpl() {
        setEntityClass(SalesInvoiceRow.class);
    }

}
