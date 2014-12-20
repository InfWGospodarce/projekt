package org.pwr.transporter.server.web.controllers.driver;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.UserAcc;
import org.pwr.transporter.entity.logistic.Task;
import org.pwr.transporter.entity.logistic.Vehicle;
import org.pwr.transporter.server.web.services.logistic.TaskService;
import org.pwr.transporter.server.web.services.logistic.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class DriverVehicleController {

	private static Logger LOGGER = Logger.getLogger(DriverVehicleController.class);

	@Autowired
	VehicleService vehicleService;

	@RequestMapping(value = "/driver/driverVehicle", method = RequestMethod.GET)
	public String getList( HttpServletRequest request, HttpServletResponse response, Model model ) {

		UserAcc user = (UserAcc) request.getSession().getAttribute("userctx");
		// if ( user != null ) {
		// List<Task> taskList =
		// taskService.getByUserId(user.getEmplyee().getId());
		// model.addAttribute("taskList", taskList);
		// }

		List<Vehicle> vehicleList = vehicleService.getList();
		model.addAttribute("vehicleList", vehicleList);

		return "/Views/driver/driverVehicle";
	}
}
