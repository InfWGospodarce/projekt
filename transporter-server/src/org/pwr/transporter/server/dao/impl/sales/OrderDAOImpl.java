package org.pwr.transporter.server.dao.impl.sales;


import java.util.List;

import org.pwr.transporter.entity.logistic.Task;
import org.pwr.transporter.entity.logistic.Order;
import org.pwr.transporter.entity.logistic.Vehicle;
import org.pwr.transporter.server.dao.impl.GenericDAOImpl;
import org.pwr.transporter.server.dao.logistic.TaskDAO;
import org.pwr.transporter.server.dao.logistic.VehicleDAO;
import org.pwr.transporter.server.dao.sales.OrderDAO;


public class OrderDAOImpl extends GenericDAOImpl<Order> implements OrderDAO {

	public OrderDAOImpl() {
		setEntityClass(Order.class);
	}

	@Override
	public List<Order> getByUserId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
