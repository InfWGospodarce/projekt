package org.pwr.transporter.server.web.controllers.account;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.server.web.form.UserForm;
import org.pwr.transporter.server.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



/**
 * <pre>
 *    Show login or logout page.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.6
 */
@Controller
public class LoginController {

    private static Logger LOGGER = Logger.getLogger(LoginController.class);

    @Autowired
    UserService usersService;


    @RequestMapping(value = "/log/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout, HttpServletRequest request, HttpServletResponse response, Model model) {
        model.addAttribute("user", new UserForm());
        LOGGER.debug("Get login");
        return "/Views/log/login";
    }


    // @RequestMapping(value = "/j_spring_security_check", method = RequestMethod.POST)
    // @RequestMapping(value = "/log/login", method = RequestMethod.POST)
    // public String doPostLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user") UserForm user,
    // BindingResult bindings, Model model) {
    // LOGGER.debug("Post login");
    // if( !usersService.checkUserLogin(user) ) {
    // bindings.rejectValue("username", "login.failed");
    // model.addAttribute("user", user);
    // LOGGER.debug("Login failed");
    // return "/Views/log/login";
    // }
    //
    // UserAcc newUser = usersService.getByUserName(user.getUsername());
    // request.getSession().setAttribute("userctx", newUser);
    //
    // // model.addAttribute("user",
    // // usersService.getByUserName(user.getUsername()));
    //
    // LOGGER.debug("POST login");
    // return "redirect:../index";
    // }

    @RequestMapping(value = "/log/logout", method = RequestMethod.GET)
    public String doGetLogout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("userctx");
        return "/Views/log/logout";
    }
}
