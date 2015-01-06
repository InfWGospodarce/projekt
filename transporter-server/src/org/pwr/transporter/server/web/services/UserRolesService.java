package org.pwr.transporter.server.web.services;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.base.UserRoles;
import org.pwr.transporter.server.business.UserRolesLogic;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.dao.base.UserRolesDAO;
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
public class UserRolesService implements IService {

    @Autowired
    UserRolesLogic userRolesLogic;


    public void setUserRolesDAO(UserRolesDAO userRolesDAO) {
        this.userRolesLogic.setUserRolesDAO(userRolesDAO);
    }


    public UserRoles getByID(Long id) {
        return this.userRolesLogic.getByID(id);
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


    public List<UserRoles> getActiveByUserId(Long id) {
        return this.userRolesLogic.getActiveByUserId(id);
    }


    public List<UserRoles> getByUserId(Long id) {
        return this.userRolesLogic.getByUserId(id);
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<UserRoles> getListRest(int amount, int fromRow) {
        return this.userRolesLogic.getListRest(amount, fromRow);
    }


    @Override
    public long count() {
        return this.userRolesLogic.count();
    }


    @Override
    public long count(Criteria criteria) {
        return this.userRolesLogic.count(criteria);
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<UserRoles> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.userRolesLogic.getListRestCrit(amount, fromRow, criteria);
    }

}
