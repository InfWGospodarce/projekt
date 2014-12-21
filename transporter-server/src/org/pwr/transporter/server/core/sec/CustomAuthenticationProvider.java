package org.pwr.transporter.server.core.sec;


import java.util.Collection;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.UserAcc;
import org.pwr.transporter.server.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;



@Component
/**
 * <pre>
 Provides custom authentication.
 * </pre><hr/>
 * @author W.S
 * @version 0.0.3
 */
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private static Logger LOGGER = Logger.getLogger(CustomAuthenticationProvider.class);

    @Autowired
    private UserService userService;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        CustomUserDetails user = userService.loadUserByUsername(username);

        if( user == null ) {
            throw new BadCredentialsException("Username not found.");
        }

        UserAcc testUser = new UserAcc();
        testUser.setUsername(username);
        testUser.setPassAndSalt(password, (String) user.getSalt());
        if( !testUser.getPassword().equals(user.getPassword()) ) {
            LOGGER.debug("Passwords not match:\n" + testUser.getPassword() + "\n" + user.getPassword());
            throw new BadCredentialsException("Wrong password.");
        }

        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();

        return new UsernamePasswordAuthenticationToken(user, password, authorities);
    }


    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }
}