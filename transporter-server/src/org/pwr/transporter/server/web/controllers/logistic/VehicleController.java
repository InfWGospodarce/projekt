package org.pwr.transporter.server.web.controllers.logistic;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.UserAcc;
import org.pwr.transporter.entity.enums.base.AddrStreetPrefix;
import org.pwr.transporter.entity.logistic.Task;
import org.pwr.transporter.entity.logistic.Vehicle;
import org.pwr.transporter.server.web.controllers.GenericController;
import org.pwr.transporter.server.web.services.logistic.TaskService;
import org.pwr.transporter.server.web.services.logistic.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class VehicleController extends GenericController{

	private static Logger LOGGER = Logger.getLogger(VehicleController.class);

	@Autowired
	VehicleService vehicleService;

	@RequestMapping(value = "/logistic/vehicleList", method = RequestMethod.GET)
	public String getList( HttpServletRequest request, HttpServletResponse response, Model model ) {

		UserAcc user = (UserAcc) request.getSession().getAttribute("userctx");
		// if ( user != null ) {
		// List<Task> taskList =
		// taskService.getByUserId(user.getEmplyee().getId());
		// model.addAttribute("taskList", taskList);
		// }

		List<Vehicle> vehicleList = vehicleService.getList();
		model.addAttribute("vehicleList", vehicleList);

		return "/Views/logistic/vehicleList";
	}
	
	@RequestMapping(value = "/logistic/vehicleEdit", method = RequestMethod.GET)
	public String getPrefix( HttpServletRequest request, HttpServletResponse response, Model model ) {

		Long id = getId(request.getParameter("id"));
		Vehicle vehicle = null;
		if ( id == null ) {
			vehicle = new Vehicle();
		} else {
			vehicle = vehicleService.getByID(id);
			if ( vehicle == null || vehicle.getId() == null ) {
				vehicle = new Vehicle();
			}
		}

		model.addAttribute("vehicle", vehicle);

		return "Views/logistic/vehicleEdit";
	}

	@RequestMapping(value = "/logistic/vehicleEdit", method = RequestMethod.POST)
	public String postPrefix( HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("streetPrefix")/* @Validated */Vehicle vehicle, BindingResult formBindeings ) {

		LOGGER.debug("Post prefix");
		// FIXME VALIDATION
		if ( vehicle.getId() != null ) {
			LOGGER.debug("Id not null");
			vehicleService.update(vehicle);
		} else {
			vehicleService.insert(vehicle);
		}

		return "redirect:../logistic/vehicleList?page=" + getPage(request);
	}
}
