package org.pwr.transporter.server.web.controllers.logistic;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.base.UserAcc;
import org.pwr.transporter.entity.logistic.Task;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.web.controllers.GenericController;
import org.pwr.transporter.server.web.services.logistic.TaskService;
import org.pwr.transporter.server.web.validators.logistic.TaskValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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

    @Autowired
    TaskValidator validator;


    @RequestMapping(value = "/driver/driverShedule", method = RequestMethod.GET)
    public String getList(HttpServletRequest request, HttpServletResponse response, Model model) {

        UserAcc user = (UserAcc) request.getSession().getAttribute("userctx");

        Criteria criteria = restoreCriteria(request);
        criteria.getEqualCriteria().put("active", true);
        if( user.getEmployee() != null ) {
            criteria.getIdsCriteria().put("employee.id", user.getEmployee().getId());
        }

        List<Task> taskList = getListWithCriteria(taskService, request, criteria);
        model.addAttribute("taskList", taskList);

        return "/Views/driver/driverShedule";

    }


    @RequestMapping(value = "/driver/driverScheduleEdit", method = RequestMethod.GET)
    public String getPrefix(HttpServletRequest request, HttpServletResponse response, Model model) {

        Long id = getId(request.getParameter("id"));
        Task task = null;
        if( id == null ) {
            task = new Task();
        } else {
            task = taskService.getByID(id);
            if( task == null || task.getId() == null ) {
                task = new Task();
            }
        }

        model.addAttribute("task", task);

        return "Views/driver/driverScheduleEdit";
    }


    @RequestMapping(value = "/driver/driverScheduleEdit", method = RequestMethod.POST)
    public String postPrefix(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("task") @Validated Task task,
            BindingResult formBindeings, Model model) {

        if( !validate(task, model, formBindeings, validator) ) {
            return "/Views/driver/driverScheduleEdit";
        }
        if( task.getId() != null ) {
            LOGGER.debug("Id not null");
            taskService.update(task);
        } else {
            taskService.insert(task);
        }

        return "redirect:../driver/driverSchedule?page=" + getPage(request);
    }


    /* dla taskList */

    @RequestMapping(value = "/logistic/taskList", method = RequestMethod.GET)
    public String getList2(HttpServletRequest request, HttpServletResponse response, Model model) {

        List<Task> taskList = getList(taskService, request);
        model.addAttribute("taskList", taskList);

        return "/Views/logistic/taskList";
    }


    @RequestMapping(value = "/logistic/taskListEdit", method = RequestMethod.GET)
    public String getPrefix2(HttpServletRequest request, HttpServletResponse response, Model model) {

        Long id = getId(request.getParameter("id"));
        Task task = null;
        if( id == null ) {
            task = new Task();
        } else {
            task = taskService.getByID(id);
            if( task == null || task.getId() == null ) {
                task = new Task();
            }
        }

        model.addAttribute("task", task);

        return "Views/logistic/taskListEdit";
    }


    @RequestMapping(value = "/logistic/taskListEdit", method = RequestMethod.POST)
    public String postPrefix2(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("streetPrefix")/* @Validated */Task task,
            BindingResult formBindeings) {

        LOGGER.debug("Post prefix");
        // FIXME VALIDATION
        if( task.getId() != null ) {
            LOGGER.debug("Id not null");
            taskService.update(task);
        } else {
            taskService.insert(task);
        }

        return "redirect:../logistic/taskList?page=" + getPage(request);
    }


    @Override
    public void loadData(Model model) {
        // TODO Auto-generated method stub

    }

}
