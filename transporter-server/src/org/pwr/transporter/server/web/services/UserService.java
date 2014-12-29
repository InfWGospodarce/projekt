package org.pwr.transporter.server.web.services;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.Role;
import org.pwr.transporter.entity.UserAcc;
import org.pwr.transporter.entity.UserRoles;
import org.pwr.transporter.entity.base.Customer;
import org.pwr.transporter.server.business.AddressLogic;
import org.pwr.transporter.server.business.CustomerLogic;
import org.pwr.transporter.server.business.EmployeeLogic;
import org.pwr.transporter.server.business.RoleLogic;
import org.pwr.transporter.server.business.UserLogic;
import org.pwr.transporter.server.business.UserRolesLogic;
import org.pwr.transporter.server.core.sec.CustomUserDetails;
import org.pwr.transporter.server.dao.UserDAO;
import org.pwr.transporter.server.web.form.CustomerAccountForm;
import org.pwr.transporter.server.web.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;



/**
 * <pre>
 *    Service for {@link UserAcc} entity.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.1.3
 */
public class UserService implements UserDetailsService, IService {

    private static Logger LOGGER = Logger.getLogger(UserService.class);

    @Autowired
    UserLogic userLogic;

    @Autowired
    CustomerLogic customerLogic;

    @Autowired
    AddressLogic addressLogic;

    @Autowired
    UserRolesLogic userRolesLogic;

    @Autowired
    RoleLogic roleLogic;

    @Autowired
    EmployeeLogic employeeLogic;


    @Override
    public CustomUserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        UserAcc user = userLogic.findByUserName(username);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getRole());

        return buildUserForAuthentication(user, authorities);

    }


    // Converts com.mkyong.users.model.User user to
    // org.springframework.security.core.userdetails.User
    private CustomUserDetails buildUserForAuthentication(UserAcc user, List<GrantedAuthority> authorities) {

        CustomUserDetails userDetails = new CustomUserDetails(user.getUsername(), user.getPassword(), user.isActive(), true, true, true, authorities,
                user.getSalt());
        LOGGER.debug("User salt: " + user.getSalt());
        LOGGER.debug("Deta salt: " + userDetails.getSalt());
        return userDetails;
    }


    private List<GrantedAuthority> buildUserAuthority(Set<Role> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities
        for( Role userRole : userRoles ) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getName()));
        }

        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        return Result;
    }


    public UserAcc getByID(Long id) {
        return this.userLogic.getByID(id);
    }


    public List<UserAcc> getList() {
        return this.userLogic.getList();
    }


    public List<UserAcc> search(Map<String, Object> parameterMap) {
        return this.userLogic.search(parameterMap);
    }


    public Long insert(CustomerAccountForm accountForm) {
        Long baseAddresId = addressLogic.insert(accountForm.getBaseAddress());
        Long correAddresId = addressLogic.insert(accountForm.getCorrespondeAddress());
        Customer customer = accountForm.getCustomer();
        customer.setBaseAddress(addressLogic.getByID(baseAddresId));
        customer.setContacAddress(addressLogic.getByID(correAddresId));
        Long customerId = customerLogic.insert(customer);

        UserAcc user = accountForm.getUser();
        user.setPassword(accountForm.getPassword());
        user.setCustomer(customerLogic.getByID(customerId));
        Long userId = this.userLogic.insert(user);
        UserAcc userL = userLogic.getByID(userId);

        for( Role role : user.getRole() ) {
            UserRoles userRoles = new UserRoles();
            userRoles.setRole(role);
            userRoles.setUserAcc(userL);
            userRolesLogic.insert(userRoles);
        }

        return userId;
    }


    public void update(UserAcc entity) {
        this.userLogic.update(entity);
    }


    public void delete(UserAcc entity) {
        this.userLogic.delete(entity);
    }


    public void deleteById(Long id) {
        this.userLogic.deleteById(id);
    }


    public void setUsersDAO(UserDAO usersDAO) {
        this.userLogic.setUserDAO(usersDAO);
    }


    public UserAcc getByUserName(String username) {
        return this.userLogic.getByUserName(username);
    }


    public UserAcc getByUserEmail(String email) {
        return this.userLogic.getByUserEmail(email);
    }


    public boolean checkUserLogin(UserForm user) {
        return this.userLogic.checkUserLogin(user.getUsername(), user.getPassword());
    }


    @SuppressWarnings("unchecked")
    public List<UserAcc> getListRest(int amount, int fromRow) {
        return userLogic.getListRest(amount, fromRow);
    }


    public long count() {
        return userLogic.count();
    }


    public void update(CustomerAccountForm accountForm) {
        addressLogic.update(accountForm.getBaseAddress());

        UserAcc user = accountForm.getUser();
        if( user.getEmployee() != null ) {
            if( !accountForm.isCorespondeAddress() ) {
                user.getEmployee().setContacAddress(null);
                accountForm.getCorrespondeAddress().setActive(false);
            }
            employeeLogic.update(user.getEmployee());
        } else {
            if( !accountForm.isCorespondeAddress() ) {
                user.getCustomer().setContacAddress(null);
                accountForm.getCorrespondeAddress().setActive(false);
            }
            customerLogic.update(user.getCustomer());
        }

        addressLogic.update(accountForm.getCorrespondeAddress());

        userLogic.update(user);

    }
}
