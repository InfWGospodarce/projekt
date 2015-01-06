package org.pwr.transporter.server.dao.impl.base;


import org.pwr.transporter.entity.base.TaxItem;
import org.pwr.transporter.server.dao.base.TaxItemDAO;
import org.pwr.transporter.server.dao.impl.GenericDAOImpl;



/**
 * <pre>
 *    Implementation for {@link TaxItem} db functions.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class TaxItemDAOImpl extends GenericDAOImpl<TaxItem> implements TaxItemDAO {

    public TaxItemDAOImpl() {
        setEntityClass(TaxItem.class);
    }
}
