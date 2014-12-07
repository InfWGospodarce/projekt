package org.pwr.transporter.server.web.controllers;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 * <pre>
 * Show welcome page
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
@Controller
public class IndexController {

    private static final Logger LOGGER = Logger.getLogger(IndexController.class);


    public IndexController() {
        super();
        LOGGER.debug("Create index controller");
    }


    // @ResponseBody
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.debug("Get index");
        return "index";
    }
    
    

}
