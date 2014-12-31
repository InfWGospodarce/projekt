package org.pwr.transporter.server.business.logistic;

import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.logistic.Order;
import org.pwr.transporter.server.dao.sales.OrderDAO;

public class OrderLogic {
	
	OrderDAO orderDAO;
	
	public void setOrderDAO(OrderDAO orderDAO){
		this.orderDAO = orderDAO;
	}

	public List<Order> getByUserId(Long id) {
		return orderDAO.getByUserId(id);
	}

	public Order getByID(Long id) {
		return orderDAO.getByID(id);
	}

	public List<Order> getList() {
		return orderDAO.getList();
	}

	public List<Order> search(Map<String, Object> parameterMap) {
		return orderDAO.search(parameterMap);
	}

	public Long insert(Order entity) {
		return orderDAO.insert(entity);
	}

	public void update(Order entity) {
		orderDAO.update(entity);
	}

	public void delete(Order entity) {
		orderDAO.delete(entity);
	}

	public void deleteById(Long id) {
		orderDAO.deleteById(id);
	}

	public List<Order> getListRest(int amount, int fromRow) {
		return orderDAO.getListRest(amount, fromRow);
	}

	public long count() {
		return orderDAO.count();
	}

	public long count(Map<String, Object> criteria) {
		return orderDAO.count(criteria);
	}

	public List<Order> getListRestCrit(int amount, int fromRow,
			Map<String, Object> criteria) {
		return orderDAO.getListRestCrit(amount, fromRow, criteria);
	}

	
	

}
