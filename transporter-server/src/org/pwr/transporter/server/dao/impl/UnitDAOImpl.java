package org.pwr.transporter.server.dao.impl;


import org.pwr.transporter.entity.base.Unit;
import org.pwr.transporter.server.dao.UnitDAO;



/**
 * <pre>
 *    Implementation for {@link Unit} db functions.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class UnitDAOImpl extends GenericDAOImpl<Unit> implements UnitDAO {

    public UnitDAOImpl() {
        setEntityClass(Unit.class);
    }
}
