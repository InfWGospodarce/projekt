package org.pwr.transporter.server.web.controllers.base.documents.sales;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.sales.SalesOrder;
import org.pwr.transporter.server.web.controllers.base.documents.GenericDocumentController;
import org.pwr.transporter.server.web.services.sales.SalesOrderService;
import org.pwr.transporter.server.web.validators.documents.sales.SalesOrderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class SalesOrderController extends GenericDocumentController {

    private static Logger LOGGER = Logger.getLogger(SalesOrderController.class);

    @Autowired
    SalesOrderService salesOrderService;

    @Autowired
    SalesOrderValidator validator;


    @RequestMapping(value = "/logistic/orderList", method = RequestMethod.GET)
    public String getList(HttpServletRequest request, HttpServletResponse response, Model model) {

        List<SalesOrder> orderList = getList(salesOrderService, request);
        model.addAttribute("orderList", orderList);

        return "/Views/logistic/orderList";
    }


    @RequestMapping(value = "/logistic/orderListEdit", method = RequestMethod.GET)
    public String get(HttpServletRequest request, HttpServletResponse response, Model model) {

        Long id = getId(request.getParameter("id"));
        SalesOrder object = null;
        if( id == null ) {
            object = new SalesOrder();
        } else {
            object = salesOrderService.getByID(id);
            if( object == null || object.getId() == null ) {
                object = new SalesOrder();
            }
        }

        model.addAttribute("object", object);

        return "Views/logistic/orderListEdit";
    }


    @RequestMapping(value = "/logistic/orderListEdit", method = RequestMethod.POST)
    public String post(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("object")/* @Validated */SalesOrder object,
            BindingResult formBindeings, Model model) {

        validate(object, model, formBindeings, validator);

        if( object.getId() != null ) {
            LOGGER.debug("Id not null");
            salesOrderService.update(object);
        } else {
            salesOrderService.insert(object);
        }

        return "redirect:../logistic/orderList?page=" + getPage(request);
    }
}
