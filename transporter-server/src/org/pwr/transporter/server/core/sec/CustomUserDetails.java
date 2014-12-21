package org.pwr.transporter.server.core.sec;


import java.util.Collection;

import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;



/**
 * <pre>
 *    Provides custom {@link UserDetails}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.3
 */
public class CustomUserDetails extends User implements SaltSource {

    /**  */
    private static final long serialVersionUID = -5412549533832543966L;

    private String salt;


    public CustomUserDetails(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired,
            boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, String newSalt) {

        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        // byte[] salt = Hex.decode(newSalt);
        // byte[] input = new byte[username.getBytes().length + salt.length];
        // System.arraycopy(salt, 0, input, 0, salt.length);
        // System.arraycopy(username.getBytes(), 0, input, salt.length, username.getBytes().length);
        this.salt = newSalt;
        ;
    }


    @Override
    public Object getSalt(UserDetails arg0) {
        return salt;
    }


    public Object getSalt() {
        return salt;
    }
}
