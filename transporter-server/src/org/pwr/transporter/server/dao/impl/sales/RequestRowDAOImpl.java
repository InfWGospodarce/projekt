package org.pwr.transporter.server.dao.impl.sales;


import org.pwr.transporter.entity.sales.RequestRow;
import org.pwr.transporter.server.dao.impl.GenericDocumentRowDAOImpl;
import org.pwr.transporter.server.dao.sales.RequestRowDAO;



/**
 * <pre>
 *     Custom implementations for {@link RequestRow}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class RequestRowDAOImpl extends GenericDocumentRowDAOImpl<RequestRow> implements RequestRowDAO {

    public RequestRowDAOImpl() {
        setEntityClass(RequestRow.class);
    }

}
