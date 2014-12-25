package org.pwr.transporter.server.dao.impl.enums;


import org.pwr.transporter.entity.enums.base.EmployeeType;
import org.pwr.transporter.server.dao.enums.EmployeeTypeDAO;



/**
 * <pre>
 *    DAO methods impl for {@link EmployeeType}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class EmployeeTypeDAOImpl extends EnumDAOImpl<EmployeeType> implements EmployeeTypeDAO {

    public EmployeeTypeDAOImpl() {
        setEntityClass(EmployeeType.class);
    }
}
