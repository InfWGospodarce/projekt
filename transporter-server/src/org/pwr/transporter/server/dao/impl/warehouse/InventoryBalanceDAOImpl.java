package org.pwr.transporter.server.dao.impl.warehouse;


import org.pwr.transporter.entity.warehouse.InventoryBalance;
import org.pwr.transporter.server.dao.impl.GenericDAOImpl;
import org.pwr.transporter.server.dao.warehouse.InventoryBalanceDAO;



/**
 * <pre>
 *    DAO implementation for {@link InventoryBalance}.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class InventoryBalanceDAOImpl extends GenericDAOImpl<InventoryBalance> implements InventoryBalanceDAO {

    public InventoryBalanceDAOImpl() {
        setEntityClass(InventoryBalance.class);
    }
}
