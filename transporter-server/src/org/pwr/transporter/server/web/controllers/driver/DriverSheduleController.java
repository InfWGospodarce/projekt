package org.pwr.transporter.server.web.controllers.driver;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.UserAcc;
import org.pwr.transporter.entity.logistic.Task;
import org.pwr.transporter.entity.logistic.Vehicle;
import org.pwr.transporter.server.web.controllers.GenericController;
import org.pwr.transporter.server.web.services.logistic.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * <pre>
 *    Driver task controller.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
@Controller
public class DriverSheduleController extends GenericController {

	private static Logger LOGGER = Logger.getLogger(DriverSheduleController.class);

	@Autowired
	TaskService taskService;

	@RequestMapping(value = "/driver/driverShedule", method = RequestMethod.GET)
	public String getList( HttpServletRequest request, HttpServletResponse response, Model model ) {

		UserAcc user = (UserAcc) request.getSession().getAttribute("userctx");
		// if ( user != null ) {
		// List<Task> taskList =
		// taskService.getByUserId(user.getEmplyee().getId());
		// model.addAttribute("taskList", taskList);
		// }

		List<Task> taskList = new ArrayList<Task>();
		Task a = new Task();
		a.setId(new Long(2));
		taskList.add(a);
		model.addAttribute("taskList", taskList);

		return "/Views/driver/driverShedule";
	}
	@RequestMapping(value = "driver/driverScheduleEdit", method = RequestMethod.GET)
	public String getPrefix( HttpServletRequest request, HttpServletResponse response, Model model ) {

		Long id = getId(request.getParameter("id"));
		Task task = null;
		if ( id == null ) {
			task = new Task();
		} else {
			task = taskService.getByID(id);
			if ( task == null || task.getId() == null ) {
				task = new Task();
			}
		}

		model.addAttribute("task", task);

		return "Views/driver/driverScheduleEdit";
	}

	@RequestMapping(value = "driver/driverScheduleEdit", method = RequestMethod.POST)
	public String postPrefix( HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("streetPrefix")/* @Validated */Task task, BindingResult formBindeings ) {

		LOGGER.debug("Post prefix");
		// FIXME VALIDATION
		if ( task.getId() != null ) {
			LOGGER.debug("Id not null");
			taskService.update(task);
		} else {
			taskService.insert(task);
		}

		return "redirect:../logistic/vehicleList?page=" + getPage(request);
	}

	
	
	
}
