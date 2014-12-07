
package org.pwr.transporter.server.web.controllers;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 * <pre>
 *    Show login page.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.2
 */
@Controller
public class HTTPErrorsController {

    private static Logger LOGGER = Logger.getLogger(HTTPErrorsController.class);


    @RequestMapping(value = "/errors/403", method = RequestMethod.GET)
    public String doGet403(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.debug("Get 403 error page");
        return "/errors/403";
    }


    @RequestMapping(value = "/errors/404", method = RequestMethod.GET)
    public String doGet404(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.debug("Get 404 error page");
        return "/errors/404";
    }
}
