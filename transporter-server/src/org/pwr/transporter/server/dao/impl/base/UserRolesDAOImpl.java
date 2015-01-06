package org.pwr.transporter.server.dao.impl.base;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.base.UserRoles;
import org.pwr.transporter.server.dao.base.UserRolesDAO;
import org.pwr.transporter.server.dao.impl.GenericDAOImpl;



/**
 * <pre>
 *    DB functions Implementation for {@link UserRoles}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class UserRolesDAOImpl extends GenericDAOImpl<UserRoles> implements UserRolesDAO {

    public UserRolesDAOImpl() {
        setEntityClass(UserRoles.class);
    }


    @Override
    public List<UserRoles> getByUserId(Long id) {
        Map<String, Object> search = new HashMap<String, Object>();
        search.put("useracc.id", id);
        search.put("active", true);
        return search(search);
    }
}
