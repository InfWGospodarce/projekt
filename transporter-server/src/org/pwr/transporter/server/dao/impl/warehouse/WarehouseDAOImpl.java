package org.pwr.transporter.server.dao.impl.warehouse;


import org.pwr.transporter.entity.warehouse.Warehouse;
import org.pwr.transporter.server.dao.impl.GenericDAOImpl;
import org.pwr.transporter.server.dao.warehouse.WarehouseDAO;



/**
 * <pre>
 *    DAO implementation for {@link Warehouse}.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class WarehouseDAOImpl extends GenericDAOImpl<Warehouse> implements WarehouseDAO {

    public WarehouseDAOImpl() {
        setEntityClass(Warehouse.class);
    }
}
