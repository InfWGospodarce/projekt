package org.pwr.transporter.server.web.controllers.logistic;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pwr.transporter.entity.base.Employee;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.web.controllers.GenericController;
import org.pwr.transporter.server.web.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class EmployeeController extends GenericController {

    @Autowired
    private EmployeeService employeeService;


    /* dla driver list */

    @RequestMapping(value = "/logistic/driverList", method = RequestMethod.GET)
    public String getList2(HttpServletRequest request, HttpServletResponse response, Model model) {

        Criteria criteria = restoreCriteria(request);
        criteria.getLikeCriteria().put("employeeType.id.code", "Driver");

        List<Employee> list = getListWithCriteria(employeeService, request, criteria);
        request.setAttribute("list", list);

        return "Views/logistic/driverList";
    }


    @Override
    public void loadData(Model model) {
        // TODO Auto-generated method stub

    }

    // @RequestMapping(value = "/logistic/driverListEdit", method = RequestMethod.GET)
    // public String getPrefix2(HttpServletRequest request, HttpServletResponse response, Model model) {
    //
    // LOGGER.debug("Get employee type edit");
    // Long id = getId(request.getParameter("id"));
    // EmployeeType employeeType = null;
    // if( id == null ) {
    // employeeType = new EmployeeType();
    // } else {
    // employeeType = employeeService.getByID(id);
    // if( employeeType == null || employeeType.getId() == null ) {
    // employeeType = new EmployeeType();
    // }
    // }
    //
    // model.addAttribute("employeeType", employeeType);
    //
    // return "Views/logistic/driverListEdit";
    // }
    //
    //
    // @RequestMapping(value = "/logistic/driverListEdit", method = RequestMethod.POST)
    // public String postPrefix2(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("employeeType") EmployeeType employeeType,
    // BindingResult formBindeings) {
    //
    // // FIXME VALIDATION
    // if( employeeType.getId() != null ) {
    // LOGGER.debug("Id not null");
    // employeeService.update(employeeType);
    // } else {
    // employeeService.insert(employeeType);
    // }
    //
    // return "redirect:../logistic/driverList?page=" + getPage(request);
    // }

}
