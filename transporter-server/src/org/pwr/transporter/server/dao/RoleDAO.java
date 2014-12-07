package org.pwr.transporter.server.dao;


import org.pwr.transporter.entity.Role;



/**
 * <pre>
 *    Role DAO interface.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.2
 */
public interface RoleDAO extends GenericDAO<Role> {

    Role getByName(String string);

}
