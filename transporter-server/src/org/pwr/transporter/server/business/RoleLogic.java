package org.pwr.transporter.server.business;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.base.Role;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.dao.base.RoleDAO;



/**
 * <pre>
 *    Logic for {@link Role}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.3
 */
public class RoleLogic {

    RoleDAO roleDAO;


    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }


    public Role getByID(Long id) {
        return this.roleDAO.getByID(id);
    }


    public List<Role> search(Map<String, Object> parameterMap) {
        return this.roleDAO.search(parameterMap);
    }


    public Long insert(Role entity) {
        return this.roleDAO.insert(entity);
    }


    public void update(Role entity) {
        this.roleDAO.update(entity);
    }


    public void delete(Role entity) {
        this.roleDAO.delete(entity);
    }


    public void deleteById(Long id) {
        this.roleDAO.deleteById(id);
    }


    public Role getByName(String string) {
        return this.roleDAO.getByName(string);
    }


    public long count() {
        return this.roleDAO.count();
    }


    public List<Role> getListRest(int amount, int fromRow) {
        return this.roleDAO.getListRest(amount, fromRow);
    }


    public long count(Criteria criteria) {
        return this.roleDAO.count(criteria);
    }


    public List<Role> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.roleDAO.getListRestCrit(amount, fromRow, criteria);
    }


    @SuppressWarnings("deprecation")
    public List<Role> getList() {
        return this.roleDAO.getList();
    }

}
