package org.pwr.transporter.server.dao.impl.base;


import org.pwr.transporter.entity.base.Currency;
import org.pwr.transporter.server.dao.base.CurrencyDAO;
import org.pwr.transporter.server.dao.impl.GenericDAOImpl;



/**
 * <pre>
 *    Implementation for {@link Currency} db functions.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class CurrencyDAOImpl extends GenericDAOImpl<Currency> implements CurrencyDAO {

    public CurrencyDAOImpl() {
        setEntityClass(Currency.class);
    }
}
