package org.pwr.transporter.server.dao.impl.sales;


import org.pwr.transporter.entity.sales.SalesOrder;
import org.pwr.transporter.server.dao.impl.GenericDocumentDAOImpl;
import org.pwr.transporter.server.dao.sales.SalesOrderDAO;



/**
 * <pre>
 *     Custom implementations for {@link SalesOrder}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class SalesOrderDAOImpl extends GenericDocumentDAOImpl<SalesOrder> implements SalesOrderDAO {

    public SalesOrderDAOImpl() {
        setEntityClass(SalesOrder.class);
    }

}
