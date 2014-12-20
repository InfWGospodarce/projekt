
package org.pwr.transporter.server.dao;


import org.pwr.transporter.entity.UserAcc;



/**
 * <pre>
 *    Define functions for {@link UserAcc} entity
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.2
 */
public interface UsersDAO extends GenericDAO<UserAcc> {

    UserAcc getByUserName(String username);


    UserAcc getByUserEmail(String email);

}
