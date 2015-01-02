package org.pwr.transporter.server.web.controllers.account;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;



/**
 * <pre>
 * 
 * </pre>
 * <hr/>
 * 
 * @author W.S
 * @version 0.0.1
 */
public class CustomLogoutHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse arg1, Authentication arg2) throws IOException, ServletException {
        request.getSession().removeAttribute("userctx");
    }

}
