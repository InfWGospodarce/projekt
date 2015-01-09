package org.pwr.transporter.server.web.controllers.base.documents.sales;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.base.UserAcc;
import org.pwr.transporter.entity.sales.Request;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.web.controllers.base.documents.GenericDocumentController;
import org.pwr.transporter.server.web.services.sales.RequestService;
import org.pwr.transporter.server.web.validators.documents.sales.RequestValidator;
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
 *    Controller for {@link Bundle}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
@Controller
public class BundleController extends GenericDocumentController {

    private static Logger LOGGER = Logger.getLogger(BundleController.class);

 

    @Override
    public void loadData(Model model) {
     

    }

    


    @RequestMapping(value = "/customer/bundleMonitorList", method = RequestMethod.GET)
    public String getListMonitList(HttpServletRequest request, HttpServletResponse response, Model model) {

        return "Views/customer/bundleMonitorList";
    }


    @RequestMapping(value = "/customer/bundleMonit", method = RequestMethod.GET)
    public String getListMonitNr(HttpServletRequest request, HttpServletResponse response, Model model) {

        return "Views/customer/bundleMonit";
    }
}
