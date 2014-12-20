package org.pwr.transporter.server.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.UserAcc;
import org.pwr.transporter.server.dao.UsersDAO;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



/**
 * <pre>
 *  Implementation for users netity
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.3
 */
@Transactional(propagation = Propagation.REQUIRED)
public class UsersDAOImpl extends GenericDAOImpl<UserAcc> implements UsersDAO {

    private static Logger LOGGER = Logger.getLogger(UsersDAOImpl.class);


    public UsersDAOImpl() {
        setEntityClass(UserAcc.class);
    }


    @Override
    public UserAcc getByUserName(String username) {
        Map<String, Object> parameterMap = new HashMap<String, Object>();
        parameterMap.put("username", username);
        List<UserAcc> users = search(parameterMap);
        if( users.size() > 1 ) {
            LOGGER.warn("Found more than one user: " + users.size());
            for( UserAcc user : users ) {
                LOGGER.debug(user.getId() + "\t" + user.getUsername() + " \t" + user.getRoles().toString());
            }
        }
        if( users.size() > 0 ) {
            return users.get(0);
        }
        return null;
    }


    @Override
    public UserAcc getByUserEmail(String email) {
        Map<String, Object> parameterMap = new HashMap<String, Object>();
        parameterMap.put("email", email);
        List<UserAcc> users = search(parameterMap);
        if( users.size() > 1 ) {
            LOGGER.warn("Found more than one user: " + users.size());
        }
        if( users.size() > 0 ) {
            return users.get(0);
        }
        return null;
    }

}
