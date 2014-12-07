package org.pwr.transporter.server.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.Role;
import org.pwr.transporter.server.dao.RoleDAO;



/**
 * <pre>
 *    DB functions Implementation for {@link Role}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.2
 */
public class RoleDAOImpl extends GenericDAOImpl<Role> implements RoleDAO {

    private static Logger LOGGER = Logger.getLogger(RoleDAOImpl.class);


    public RoleDAOImpl() {
        setEntityClass(Role.class);
    }


    @Override
    public Role getByName(String name) {
        Map<String, Object> parameterMap = new HashMap<String, Object>();
        parameterMap.put("name", name);
        List<Role> roles = search(parameterMap);
        if( roles.size() > 1 ) {
            LOGGER.warn("Found more than one role: " + roles.size());
        }
        if( roles.size() > 0 ) {
            return roles.get(0);
        }
        return null;
    }
}
