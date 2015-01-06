package org.pwr.transporter.server.dao.impl.sales;


import org.pwr.transporter.entity.sales.SalesOrderRow;
import org.pwr.transporter.server.dao.impl.GenericDocumentRowDAOImpl;
import org.pwr.transporter.server.dao.sales.SalesOrderRowDAO;



/**
 * <pre>
 *     Custom implementations for {@link SalesOrderRow}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class SalesOrderRowDAOImpl extends GenericDocumentRowDAOImpl<SalesOrderRow> implements SalesOrderRowDAO {

    public SalesOrderRowDAOImpl() {
        setEntityClass(SalesOrderRow.class);
    }

}
