package org.pwr.transporter.server.business.logistic;

import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.logistic.Vehicle;
import org.pwr.transporter.server.dao.logistic.VehicleDAO;

public class VehicleLogic {
	
	VehicleDAO vehicleDAO;
	
	public void setVehicleDAO(VehicleDAO vehicleDAO) {
		this.vehicleDAO = vehicleDAO;
	}

	public Vehicle getByID(Long id) {
		return vehicleDAO.getByID(id);
	}

	public List<Vehicle> getList() {
		return vehicleDAO.getList();
	}

	public List<Vehicle> search(Map<String, Object> parameterMap) {
		return vehicleDAO.search(parameterMap);
	}

	public Long insert(Vehicle entity) {
		return vehicleDAO.insert(entity);
	}

	public void update(Vehicle entity) {
		vehicleDAO.update(entity);
	}

	public void delete(Vehicle entity) {
		vehicleDAO.delete(entity);
	}

	public void deleteById(Long id) {
		vehicleDAO.deleteById(id);
	}
	
	

}
