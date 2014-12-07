package org.pwr.transporter.server.web.services;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.UserRoles;
import org.pwr.transporter.server.business.UserRolesLogic;
import org.pwr.transporter.server.dao.UserRolesDAO;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * <pre>
 *    Service for {@link UserRoles}.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class UserRolesService {

    @Autowired
    UserRolesLogic userRolesLogic;


    public void setUserRolesDAO(UserRolesDAO userRolesDAO) {
        this.userRolesLogic.setUserRolesDAO(userRolesDAO);
    }


    public UserRoles getByID(Long id) {
        return this.userRolesLogic.getByID(id);
    }


    public List<UserRoles> getList() {
        return this.userRolesLogic.getList();
    }


    public List<UserRoles> search(Map<String, Object> parameterMap) {
        return this.userRolesLogic.search(parameterMap);
    }


    public Long insert(UserRoles entity) {
        return this.userRolesLogic.insert(entity);
    }


    public void update(UserRoles entity) {
        this.userRolesLogic.update(entity);
    }


    public void delete(UserRoles entity) {
        this.userRolesLogic.delete(entity);
    }


    public void deleteById(Long id) {
        this.userRolesLogic.deleteById(id);
    }

}
