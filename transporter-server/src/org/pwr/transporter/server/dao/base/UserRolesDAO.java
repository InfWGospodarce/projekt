package org.pwr.transporter.server.dao.base;


import java.util.List;

import org.pwr.transporter.entity.base.UserRoles;
import org.pwr.transporter.server.dao.GenericDAO;



/**
 * <pre>
 *  DAO interface for {@link UserRoles}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.2
 */
public interface UserRolesDAO extends GenericDAO<UserRoles> {

    public List<UserRoles> getByUserId(Long id);

}
