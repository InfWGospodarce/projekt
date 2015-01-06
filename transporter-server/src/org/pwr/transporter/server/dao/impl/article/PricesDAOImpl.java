package org.pwr.transporter.server.dao.impl.article;


import org.pwr.transporter.entity.article.Prices;
import org.pwr.transporter.server.dao.article.PricesDAO;
import org.pwr.transporter.server.dao.impl.GenericDAOImpl;



/**
 * <pre>
 *    Implementation for {@link Prices} db functions.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class PricesDAOImpl extends GenericDAOImpl<Prices> implements PricesDAO {

    public PricesDAOImpl() {
        setEntityClass(Prices.class);
    }
}
