package org.pwr.transporter.server.dao.impl.enums;


import org.pwr.transporter.entity.enums.base.AddrStreetPrefix;
import org.pwr.transporter.server.dao.enums.AddrStreetPrefixDAO;
import org.pwr.transporter.server.dao.impl.GenericDAOImpl;



/**
 * <pre>
 *    Streat prefix dao implementation
 * </pre>
 * <hr/>
 * 
 * @author x0r
 * @version 0.0.1
 */
public class AddrStreetPrefixDAOImpl extends GenericDAOImpl<AddrStreetPrefix> implements AddrStreetPrefixDAO {

    public AddrStreetPrefixDAOImpl() {
        setEntityClass(AddrStreetPrefix.class);
    }
}
