package org.pwr.transporter.server.dao.base;


import org.pwr.transporter.entity.base.Role;
import org.pwr.transporter.server.dao.GenericDAO;



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
