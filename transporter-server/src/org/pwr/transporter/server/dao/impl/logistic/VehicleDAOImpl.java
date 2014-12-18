package org.pwr.transporter.server.dao.impl.logistic;


import java.util.List;

import org.pwr.transporter.entity.logistic.Task;
import org.pwr.transporter.entity.logistic.Vehicle;
import org.pwr.transporter.server.dao.impl.GenericDAOImpl;
import org.pwr.transporter.server.dao.logistic.TaskDAO;
import org.pwr.transporter.server.dao.logistic.VehicleDAO;


public class VehicleDAOImpl extends GenericDAOImpl<Vehicle> implements VehicleDAO {

	public VehicleDAOImpl() {
		setEntityClass(Vehicle.class);
	}
}
