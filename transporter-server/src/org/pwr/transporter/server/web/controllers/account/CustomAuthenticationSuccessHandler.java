package org.pwr.transporter.server.web.controllers.account;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.UserAcc;
import org.pwr.transporter.server.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;



/**
 * <pre>
 *    Handle login success.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.2
 */
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler, AuthenticationEventPublisher {

    private static Logger LOGGER = Logger.getLogger(CustomAuthenticationSuccessHandler.class);
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    private UserService usersService;


    @Override
    public void publishAuthenticationFailure(AuthenticationException arg0, Authentication arg1) {
        // TODO Auto-generated method stub

    }


    @Override
    public void publishAuthenticationSuccess(Authentication arg0) {
        // TODO Auto-generated method stub

    }


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException,
            ServletException {
        User user = (User) auth.getPrincipal();
        UserAcc newUser = usersService.getByUserName(user.getUsername());
        if( newUser != null ) {
            request.getSession().setAttribute("userctx", newUser);
        }

        if( response.isCommitted() ) {
            LOGGER.debug("Response has already been committed. Unable to redirect to /index");
            return;
        }

        redirectStrategy.sendRedirect(request, response, "/index");
    }

}
