package org.pwr.transporter.server.dao.impl;


import org.pwr.transporter.entity.UserRoles;
import org.pwr.transporter.server.dao.UserRolesDAO;



/**
 * <pre>
 *    DB functions Implementation for {@link UserRoles}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class UserRolesDAOImpl extends GenericDAOImpl<UserRoles> implements UserRolesDAO {

    public UserRolesDAOImpl() {
        setEntityClass(UserRoles.class);
    }
}
