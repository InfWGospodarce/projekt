package org.pwr.transporter.server.dao.sales;


import java.util.List;

import org.pwr.transporter.entity.logistic.Order;
import org.pwr.transporter.server.dao.GenericDAO;


public interface OrderDAO extends GenericDAO<Order> {
	List<Order> getByUserId( Long id );


}
