package org.pwr.transporter.server.dao;


import java.util.List;

import org.pwr.transporter.entity.UserRoles;



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
