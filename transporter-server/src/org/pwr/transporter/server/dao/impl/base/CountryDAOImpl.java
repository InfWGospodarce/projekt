package org.pwr.transporter.server.dao.impl.base;


import org.pwr.transporter.entity.base.Country;
import org.pwr.transporter.server.dao.base.CountryDAO;
import org.pwr.transporter.server.dao.impl.GenericDAOImpl;



/**
 * <pre>
 *    Country DAO implementation.
 * </pre>
 * <hr/>
 * 
 * @author x0r
 * @version 0.0.1
 */
public class CountryDAOImpl extends GenericDAOImpl<Country> implements CountryDAO {

    public CountryDAOImpl() {
        setEntityClass(Country.class);
    }
}
