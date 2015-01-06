package org.pwr.transporter.server.dao.impl.sales;


import org.pwr.transporter.entity.sales.Request;
import org.pwr.transporter.server.dao.impl.GenericDocumentDAOImpl;
import org.pwr.transporter.server.dao.sales.RequestDAO;



/**
 * <pre>
 *     Custom implementations for {@link Request}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class RequestDAOImpl extends GenericDocumentDAOImpl<Request> implements RequestDAO {

    public RequestDAOImpl() {
        setEntityClass(Request.class);
    }

}
