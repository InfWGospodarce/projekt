package org.pwr.transporter.server.web.controllers.sales;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.UserAcc;
import org.pwr.transporter.entity.sales.SalesOrder;
import org.pwr.transporter.server.web.controllers.GenericController;
import org.pwr.transporter.server.web.services.sales.SalesOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class SalesOrderController extends GenericController {

    private static Logger LOGGER = Logger.getLogger(SalesOrderController.class);

    @Autowired
    SalesOrderService orderService;


    @RequestMapping(value = "/logistic/orderList", method = RequestMethod.GET)
    public String getList(HttpServletRequest request, HttpServletResponse response, Model model) {

        UserAcc user = (UserAcc) request.getSession().getAttribute("userctx");
        // if ( user != null ) {
        // List<Task> taskList =
        // taskService.getByUserId(user.getEmplyee().getId());
        // model.addAttribute("taskList", taskList);
        // }

        List<SalesOrder> orderList = orderService.getList();
        model.addAttribute("orderList", orderList);

        return "/Views/logistic/orderList";
    }


    @RequestMapping(value = "/logistic/orderListEdit", method = RequestMethod.GET)
    public String getPrefix(HttpServletRequest request, HttpServletResponse response, Model model) {

        Long id = getId(request.getParameter("id"));
        SalesOrder order = null;
        if( id == null ) {
            order = new SalesOrder();
        } else {
            order = orderService.getByID(id);
            if( order == null || order.getId() == null ) {
                order = new SalesOrder();
            }
        }

        model.addAttribute("order", order);

        return "Views/logistic/orderListEdit";
    }


    @RequestMapping(value = "/logistic/orderListEdit", method = RequestMethod.POST)
    public String postPrefix(HttpServletRequest request, HttpServletResponse response,
            @ModelAttribute("streetPrefix")/* @Validated */SalesOrder order, BindingResult formBindeings) {

        LOGGER.debug("Post prefix");
        // FIXME VALIDATION
        if( order.getId() != null ) {
            LOGGER.debug("Id not null");
            orderService.update(order);
        } else {
            orderService.insert(order);
        }

        return "redirect:../logistic/orderList?page=" + getPage(request);
    }
}
