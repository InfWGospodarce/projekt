package org.pwr.transporter.server.web.services.logistic;

import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.GenericEntity;
import org.pwr.transporter.entity.logistic.Task;
import org.pwr.transporter.server.business.logistic.TaskLogic;
import org.pwr.transporter.server.dao.logistic.TaskDAO;
import org.pwr.transporter.server.dao.logistic.VehicleDAO;
import org.pwr.transporter.entity.logistic.Order;
import org.pwr.transporter.server.business.logistic.OrderLogic;
import org.pwr.transporter.server.dao.sales.OrderDAO;
import org.pwr.transporter.server.web.services.IService;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderService {
	@Autowired
	OrderLogic orderLogic;
	
	public void setOrderDAO(OrderDAO orderDAO) {
		orderLogic.setOrderDAO(orderDAO);
	}

	
	

	public List<Order> getByUserId(Long id) {
		return orderLogic.getByUserId(id);
	}

	public Order getByID(Long id) {
		return orderLogic.getByID(id);
	}

	public List<Order> getList() {
		return orderLogic.getList();
	}

	public List<Order> search(Map<String, Object> parameterMap) {
		return orderLogic.search(parameterMap);
	}

	public Long insert(Order entity) {
		return orderLogic.insert(entity);
	}

	public void update(Order entity) {
		orderLogic.update(entity);
	}

	public void delete(Order entity) {
		orderLogic.delete(entity);
	}

	public void deleteById(Long id) {
		orderLogic.deleteById(id);
	}

	public List<Order> getListRest(int amount, int fromRow) {
		return orderLogic.getListRest(amount, fromRow);
	}

	public long count() {
		return orderLogic.count();
	}

	public long count(Map<String, Object> criteria) {
		return orderLogic.count(criteria);
	}



	
	
	
	
}
