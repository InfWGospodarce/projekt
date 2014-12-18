package org.pwr.transporter.server.web.services.logistic;

import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.logistic.Vehicle;
import org.pwr.transporter.server.business.logistic.VehicleLogic;
import org.pwr.transporter.server.dao.logistic.VehicleDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class VehicleService {
	
	@Autowired
	VehicleLogic vehicleLogic;

	public void setVehicleDAO(VehicleDAO vehicleDAO) {
		vehicleLogic.setVehicleDAO(vehicleDAO);
	}

	public Vehicle getByID(Long id) {
		return vehicleLogic.getByID(id);
	}

	public List<Vehicle> getList() {
		return vehicleLogic.getList();
	}

	public List<Vehicle> search(Map<String, Object> parameterMap) {
		return vehicleLogic.search(parameterMap);
	}

	public Long insert(Vehicle entity) {
		return vehicleLogic.insert(entity);
	}

	public void update(Vehicle entity) {
		vehicleLogic.update(entity);
	}

	public void delete(Vehicle entity) {
		vehicleLogic.delete(entity);
	}

	public void deleteById(Long id) {
		vehicleLogic.deleteById(id);
	}
	
	

}
