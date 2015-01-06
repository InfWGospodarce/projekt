package org.pwr.transporter.server.web.controllers.logistic;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.logistic.Vehicle;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.web.controllers.GenericController;
import org.pwr.transporter.server.web.services.logistic.VehicleService;
import org.pwr.transporter.server.web.validators.logistic.VehicleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class VehicleController extends GenericController {

    private static Logger LOGGER = Logger.getLogger(VehicleController.class);

    @Autowired
    VehicleService vehicleService;

    @Autowired
    VehicleValidator validator;


    @RequestMapping(value = "/logistic/vehicleList", method = RequestMethod.GET)
    public String getList(HttpServletRequest request, HttpServletResponse response, Model model) {

        Criteria criteria = restoreCriteria(request);
        List<Vehicle> vehicleList = getListWitchCriteria(vehicleService, request, criteria);
        model.addAttribute("vehicleList", vehicleList);

        return "/Views/logistic/vehicleList";
    }


    @RequestMapping(value = "/logistic/vehicleEdit", method = RequestMethod.GET)
    public String get(HttpServletRequest request, HttpServletResponse response, Model model) {

        Long id = getId(request.getParameter("id"));
        Vehicle vehicle = null;
        if( id == null ) {
            vehicle = new Vehicle();
        } else {
            vehicle = vehicleService.getByID(id);
            if( vehicle == null || vehicle.getId() == null ) {
                vehicle = new Vehicle();
            }
        }

        model.addAttribute("vehicle", vehicle);

        return "Views/logistic/vehicleEdit";
    }


    @RequestMapping(value = "/logistic/vehicleEdit", method = RequestMethod.POST)
    public String post(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("streetPrefix") @Validated Vehicle vehicle,
            BindingResult formBindeings, Model model) {

        if( !validate(vehicle, model, formBindeings, validator) ) {
            return "/Views/driver/driverScheduleEdit";
        }

        if( vehicle.getId() != null ) {
            LOGGER.debug("Id not null");
            vehicleService.update(vehicle);
        } else {
            vehicleService.insert(vehicle);
        }

        return "redirect:../logistic/vehicleList?page=" + getPage(request);
    }


    @Override
    public void loadData(Model model) {
        // TODO Auto-generated method stub

    }
}
