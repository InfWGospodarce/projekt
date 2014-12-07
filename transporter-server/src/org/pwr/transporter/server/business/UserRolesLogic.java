package org.pwr.transporter.server.business;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.UserRoles;
import org.pwr.transporter.server.dao.UserRolesDAO;



/**
 * <pre>
 *    Business logic for {@link UserRoles}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.2
 */
public class UserRolesLogic {

    UserRolesDAO userRolesDAO;


    public void setUserRolesDAO(UserRolesDAO userRolesDAO) {
        this.userRolesDAO = userRolesDAO;
    }


    public UserRoles getByID(Long id) {
        return this.userRolesDAO.getByID(id);
    }


    public List<UserRoles> getList() {
        return this.userRolesDAO.getList();
    }


    public List<UserRoles> search(Map<String, Object> parameterMap) {
        return this.userRolesDAO.search(parameterMap);
    }


    public Long insert(UserRoles entity) {
        entity.setSearchKey(entity.getRole().getName() + " " + entity.getUsers().getUsername());
        return this.userRolesDAO.insert(entity);
    }


    public void update(UserRoles entity) {
        this.userRolesDAO.update(entity);
    }


    public void delete(UserRoles entity) {
        this.userRolesDAO.delete(entity);
    }


    public void deleteById(Long id) {
        this.userRolesDAO.deleteById(id);
    }

}
