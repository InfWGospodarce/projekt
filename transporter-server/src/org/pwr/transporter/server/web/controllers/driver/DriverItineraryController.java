package org.pwr.transporter.server.web.controllers.driver;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.UserAcc;
import org.pwr.transporter.entity.logistic.Itinerary;
import org.pwr.transporter.entity.logistic.Task;
import org.pwr.transporter.server.web.controllers.GenericController;
import org.pwr.transporter.server.web.services.logistic.ItineraryService;
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
public class DriverItineraryController extends GenericController{

	private static Logger LOGGER = Logger.getLogger(DriverItineraryController.class);

	@Autowired
	ItineraryService itineraryService;

	@RequestMapping(value = "/driver/driverItinerary", method = RequestMethod.GET)
	public String getList( HttpServletRequest request, HttpServletResponse response, Model model ) {

		List<Itinerary> itineraryList = getList(itineraryService, request);
		model.addAttribute("list", itineraryList);

		return "/Views/driver/driverItinerary";
	}
}
