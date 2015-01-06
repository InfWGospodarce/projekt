package org.pwr.transporter.server.dao.base;


import org.pwr.transporter.entity.base.UserAcc;
import org.pwr.transporter.server.dao.GenericDAO;



/**
 * <pre>
 *    Define functions for {@link UserAcc} entity
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.3
 */
public interface UserDAO extends GenericDAO<UserAcc> {

    UserAcc getByUserName(String username);


    UserAcc findByUserName(String username);


    UserAcc getByUserEmail(String email);

}
