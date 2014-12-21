package org.pwr.transporter.server.dao.impl.enums;


import org.pwr.transporter.entity.enums.base.EmplyeeType;
import org.pwr.transporter.server.dao.enums.EmployeeTypeDAO;



/**
 * <pre>
 *    DAO methods impl for {@link EmplyeeType}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class EmployeeTypeDAOImpl extends EnumDAOImpl<EmplyeeType> implements EmployeeTypeDAO {

    public EmployeeTypeDAOImpl() {
        setEntityClass(EmplyeeType.class);
    }
}
