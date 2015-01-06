package org.pwr.transporter.server.dao.impl.warehouse;


import org.pwr.transporter.entity.warehouse.Shelf;
import org.pwr.transporter.server.dao.impl.GenericDAOImpl;
import org.pwr.transporter.server.dao.warehouse.ShelfDAO;



/**
 * <pre>
 *    DAO implementation for {@link Shelf}.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class ShelfDAOImpl extends GenericDAOImpl<Shelf> implements ShelfDAO {

    public ShelfDAOImpl() {
        setEntityClass(Shelf.class);
    }
}
