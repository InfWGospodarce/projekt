package org.pwr.transporter.server.web.services;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.Generic;
import org.pwr.transporter.entity.Role;
import org.pwr.transporter.server.business.RoleLogic;
import org.pwr.transporter.server.dao.RoleDAO;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * <pre>
 *    Service for roles.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class RoleService implements IService {

    @Autowired
    RoleLogic roleLogic;


    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleLogic.setRoleDAO(roleDAO);
    }


    public Role getByID(Long id) {
        return this.roleLogic.getByID(id);
    }


    public List<Role> getList() {
        return this.roleLogic.getList();
    }


    public List<Role> search(Map<String, Object> parameterMap) {
        return this.roleLogic.search(parameterMap);
    }


    public Long insert(Role entity) {
        return this.roleLogic.insert(entity);
    }


    public void update(Role entity) {
        this.roleLogic.update(entity);
    }


    public void delete(Role entity) {
        this.roleLogic.delete(entity);
    }


    public void deleteById(Long id) {
        this.roleLogic.deleteById(id);
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<Role> getListRest(int amount, int fromRow) {
        return this.roleLogic.getListRest(amount, fromRow);
    }


    @Override
    public long count() {
        return this.roleLogic.count();
    }


    public Role getByName(String string) {
        return this.roleLogic.getByName(string);
    }


    @SuppressWarnings("unchecked")
    @Override
    public <T extends Generic> List<T> getListRestCrit(int amount, int fromRow, Map<String, Object> criteria) {
        return (List<T>) roleLogic.getListRestCrit(amount, fromRow, criteria);
    }


    @Override
    public long count(Map<String, Object> criteria) {
        return roleLogic.count(criteria);
    }

}
