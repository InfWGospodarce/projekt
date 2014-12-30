package org.pwr.transporter.server.business;


import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.UserAcc;
import org.pwr.transporter.server.dao.UserDAO;



/**
 * <pre>
 *    Business logic for {@link UserAcc} entity.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.5
 */
public class UserLogic {

    private static Logger LOGGER = Logger.getLogger(UserLogic.class);

    UserDAO userDAO;


    public UserAcc getByID(Long id) {
        UserAcc user = this.userDAO.getByID(id);
        return user;
    }


    public List<UserAcc> getList() {
        return this.userDAO.getList();
    }


    public List<UserAcc> search(Map<String, Object> parameterMap) {
        return this.userDAO.search(parameterMap);
    }


    public Long insert(UserAcc entity) {
        entity.setSearchKey(entity.getUsername());
        return this.userDAO.insert(entity);
    }


    public void update(UserAcc entity) {
        this.userDAO.update(entity);
    }


    public void delete(UserAcc entity) {
        this.userDAO.delete(entity);
    }


    public void deleteById(Long id) {
        this.userDAO.deleteById(id);
    }


    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    public UserAcc getByUserName(String username) {
        return this.userDAO.getByUserName(username);
    }


    public UserAcc getByUserEmail(String email) {
        return this.userDAO.getByUserEmail(email);
    }


    public boolean checkUserLogin(String username, String password) {
        if( username == null || username.isEmpty() ) {
            return false;
        }
        UserAcc checkUser = this.userDAO.getByUserName(username);
        if( checkUser == null ) {
            LOGGER.debug("User not found");
            return false;
        }
        if( !checkUser.checkPassword(password) ) {
            LOGGER.debug("Paswords not equals");
            return false;
        }
        return true;
    }


    public UserAcc findByUserName(String username) {
        return this.userDAO.findByUserName(username);
    }


    public List<UserAcc> getListRest(int amount, int fromRow) {
        return userDAO.getListRest(amount, fromRow);
    }


    public long count() {
        return userDAO.count();
    }

}
