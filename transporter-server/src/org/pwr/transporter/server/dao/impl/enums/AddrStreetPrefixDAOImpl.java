package org.pwr.transporter.server.dao.impl.enums;


import org.pwr.transporter.entity.enums.base.AddrStreetPrefix;
import org.pwr.transporter.server.dao.enums.AddrStreetPrefixDAO;



/**
 * <pre>
 *    Streat prefix dao implementation
 * </pre>
 * <hr/>
 * 
 * @author x0r
 * @version 0.0.2
 */
public class AddrStreetPrefixDAOImpl extends EnumDAOImpl<AddrStreetPrefix> implements AddrStreetPrefixDAO {

    public AddrStreetPrefixDAOImpl() {
        setEntityClass(AddrStreetPrefix.class);
    }
}
