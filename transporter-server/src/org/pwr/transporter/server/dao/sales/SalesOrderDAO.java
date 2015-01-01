package org.pwr.transporter.server.dao.sales;


import java.util.List;

import org.pwr.transporter.entity.sales.SalesOrder;
import org.pwr.transporter.server.dao.GenericDAO;



/**
 * <pre>
 * 
 * </pre>
 * <hr/>
 * 
 * @version 0.0.1
 */
public interface SalesOrderDAO extends GenericDAO<SalesOrder> {

    List<SalesOrder> getByUserId(Long id);

}
