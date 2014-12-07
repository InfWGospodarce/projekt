package org.pwr.transporter.server.web.controllers.driver;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.Users;
import org.pwr.transporter.entity.logistic.Task;
import org.pwr.transporter.server.web.services.logistic.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class DriverSheduleController {

	private static Logger LOGGER = Logger.getLogger(DriverSheduleController.class);

	@Autowired
	TaskService taskService;

	@RequestMapping(value = "/driver/driverShedule", method = RequestMethod.GET)
	public String getList( HttpServletRequest request, HttpServletResponse response, Model model ) {

		Users user = (Users) request.getSession().getAttribute("userctx");
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
}
