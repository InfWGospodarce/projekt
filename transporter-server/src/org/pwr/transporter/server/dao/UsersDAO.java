
package org.pwr.transporter.server.dao;


import org.pwr.transporter.entity.Users;



/**
 * <pre>
 *    Define functions for {@link Users} entity
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.2
 */
public interface UsersDAO extends GenericDAO<Users> {

    Users getByUserName(String username);


    Users getByUserEmail(String email);

}
