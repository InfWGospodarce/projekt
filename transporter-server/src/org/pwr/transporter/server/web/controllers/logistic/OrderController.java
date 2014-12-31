package org.pwr.transporter.server.web.controllers.logistic;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.UserAcc;
import org.pwr.transporter.entity.enums.base.AddrStreetPrefix;
import org.pwr.transporter.entity.logistic.Order;
import org.pwr.transporter.entity.logistic.Task;
import org.pwr.transporter.entity.logistic.Vehicle;
import org.pwr.transporter.server.web.controllers.GenericController;
import org.pwr.transporter.server.web.services.logistic.OrderService;
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
public class OrderController extends GenericController{

	private static Logger LOGGER = Logger.getLogger(OrderController.class);

	@Autowired
	OrderService orderService;

	@RequestMapping(value = "/logistic/OrderList", method = RequestMethod.GET)
	public String getList( HttpServletRequest request, HttpServletResponse response, Model model ) {

		UserAcc user = (UserAcc) request.getSession().getAttribute("userctx");
		// if ( user != null ) {
		// List<Task> taskList =
		// taskService.getByUserId(user.getEmplyee().getId());
		// model.addAttribute("taskList", taskList);
		// }

		List<Order> orderList = orderService.getList();
		model.addAttribute("orderList", orderList);

		return "/Views/logistic/OrderList";
	}
	
	@RequestMapping(value = "/logistic/OrderListEdit", method = RequestMethod.GET)
	public String getPrefix( HttpServletRequest request, HttpServletResponse response, Model model ) {

		Long id = getId(request.getParameter("id"));
		Order order = null;
		if ( id == null ) {
			order = new Order();
		} else {
			order = orderService.getByID(id);
			if ( order == null || order.getId() == null ) {
				order = new Order();
			}
		}

		model.addAttribute("order", order);

		return "Views/logistic/OrderListEdit";
	}

	@RequestMapping(value = "/logistic/OrderListEdit", method = RequestMethod.POST)
	public String postPrefix( HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("streetPrefix")/* @Validated */Order order, BindingResult formBindeings ) {

		LOGGER.debug("Post prefix");
		// FIXME VALIDATION
		if ( order.getId() != null ) {
			LOGGER.debug("Id not null");
			orderService.update(order);
		} else {
			orderService.insert(order);
		}

		return "redirect:../logistic/OrderList?page=" + getPage(request);
	}
}
