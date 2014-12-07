
package org.pwr.transporter.server.dao.impl;


import org.pwr.transporter.entity.base.Address;
import org.pwr.transporter.server.dao.AddressDAO;



/**
 * <pre>
 *    DAO implementation for Address.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class AddressDAOImpl extends GenericDAOImpl<Address> implements AddressDAO {

    public AddressDAOImpl() {
        setEntityClass(Address.class);
    }
}
