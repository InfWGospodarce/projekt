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
import org.pwr.transporter.entity.base.Address;
import org.pwr.transporter.entity.base.Customer;
import org.pwr.transporter.entity.base.Employee;
import org.pwr.transporter.entity.enums.base.EmployeeType;
import org.pwr.transporter.server.business.AddressLogic;
import org.pwr.transporter.server.business.CustomerLogic;
import org.pwr.transporter.server.business.EmployeeLogic;
import org.pwr.transporter.server.business.RoleLogic;
import org.pwr.transporter.server.business.UserLogic;
import org.pwr.transporter.server.business.UserRolesLogic;
import org.pwr.transporter.server.business.enums.EmployeeTypeLogic;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
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

    @Autowired
    EmployeeTypeLogic employeeTypeLogic;


    @Override
    public CustomUserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        UserAcc user = userLogic.findByUserName(username);
        Set<Role> roles = new HashSet<Role>();
        if( user != null && user.getRole() != null ) {
            roles = user.getRole();
        }
        List<GrantedAuthority> authorities = buildUserAuthority(roles);

        return buildUserForAuthentication(user, authorities);

    }


    // Converts com.mkyong.users.model.User user to
    // org.springframework.security.core.userdetails.User
    private CustomUserDetails buildUserForAuthentication(UserAcc user, List<GrantedAuthority> authorities) {

        CustomUserDetails userDetails = null;

        if( user != null ) {
            userDetails = new CustomUserDetails(user.getUsername(), user.getPassword(), user.isActive(), true, true, true, authorities,
                    user.getSalt());
        }
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


    public List<UserAcc> search(Map<String, Object> parameterMap) {
        return this.userLogic.search(parameterMap);
    }


    public Long insert(CustomerAccountForm accountForm) {
        Long baseAddresId = addressLogic.insert(accountForm.getBaseAddress());

        Long correAddresId = null;
        if( accountForm.isCorespondeAddress() ) {
            correAddresId = addressLogic.insert(accountForm.getCorrespondeAddress());
        }
        Customer customer = accountForm.getCustomer();
        Employee employee = accountForm.getEmployee();

        UserAcc user = accountForm.getUser();
        user.setPassword(accountForm.getPassword());

        if( customer != null ) {
            customer.setBaseAddress(addressLogic.getByID(baseAddresId));
            if( correAddresId != null ) {
                customer.setContacAddress(addressLogic.getByID(correAddresId));
            }
            Long customerId = customerLogic.insert(customer);
            user.setCustomer(customerLogic.getByID(customerId));
        }

        if( employee != null ) {
            employee.setBaseAddress(addressLogic.getByID(baseAddresId));
            if( correAddresId != null ) {
                employee.setContacAddress(addressLogic.getByID(correAddresId));
            }
            EmployeeType employeeType = employeeTypeLogic.getByID(Long.valueOf(accountForm.getEmployeeTypeId()));
            employee.setEmployeeType(employeeType);
            Long employeeId = employeeLogic.insert(employee);
            user.setEmployee(employeeLogic.getByID(employeeId));
        }

        Set<Role> roleSet = user.getRole();
        user.setRole(null);

        Long userId = this.userLogic.insert(user);
        UserAcc userL = userLogic.getByID(userId);

        for( Role role : roleSet ) {
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
        UserAcc dbUser = userLogic.getByID(user.getId());
        user.copyPasswordAndSalt(dbUser.getPassword(), dbUser.getSalt());

        if( accountForm.getEmployee() != null ) {
            if( !accountForm.isCorespondeAddress() ) {
                accountForm.getCorrespondeAddress().setActive(false);
                if( accountForm.getCorrespondeAddress().getId() != null ) {
                    addressLogic.update(accountForm.getCorrespondeAddress());
                }
                accountForm.getEmployee().setContacAddress(null);
            } else {
                Long id = null;
                if( accountForm.getCorrespondeAddress().getId() != null ) {
                    addressLogic.update(accountForm.getCorrespondeAddress());
                    id = accountForm.getCorrespondeAddress().getId();
                } else {
                    id = addressLogic.insert(accountForm.getCorrespondeAddress());
                }
                Address adr = addressLogic.getByID(id);
                accountForm.getEmployee().setContacAddress(adr);
            }
            accountForm.getEmployee().setBaseAddress(accountForm.getBaseAddress());
            EmployeeType employeeType = employeeTypeLogic.getByID(Long.valueOf(accountForm.getEmployeeTypeId()));
            accountForm.getEmployee().setEmployeeType(employeeType);

            employeeLogic.update(accountForm.getEmployee());

        } else {
            if( !accountForm.isCorespondeAddress() ) {
                accountForm.getCorrespondeAddress().setActive(false);
                if( accountForm.getCorrespondeAddress().getId() != null ) {
                    addressLogic.update(accountForm.getCorrespondeAddress());
                }
                accountForm.getCustomer().setContacAddress(null);
            } else {
                Long id = null;
                if( accountForm.getCorrespondeAddress().getId() != null ) {
                    addressLogic.update(accountForm.getCorrespondeAddress());
                    id = accountForm.getCorrespondeAddress().getId();
                } else {
                    id = addressLogic.insert(accountForm.getCorrespondeAddress());
                }
                Address adr = addressLogic.getByID(id);
                accountForm.getCustomer().setContacAddress(adr);
            }
            accountForm.getCustomer().setBaseAddress(accountForm.getBaseAddress());

            customerLogic.update(accountForm.getCustomer());

        }

        user.setCustomer(accountForm.getCustomer());
        user.setEmployee(accountForm.getEmployee());
        Set<Role> roleSet = user.getRole();
        user.setRole(null);

        this.userLogic.update(user);
        UserAcc userL = userLogic.getByID(user.getId());

        List<UserRoles> userroles = userRolesLogic.getActiveByUserId(user.getId());
        LOGGER.debug("Get user roles: " + userroles.size());

        List<UserRoles> userroles2 = new ArrayList<UserRoles>();

        for( Role role : roleSet ) {
            UserRoles userRoles = new UserRoles();
            userRoles.setRole(role);
            userRoles.setUserAcc(userL);
            if( userroles.contains(userRoles) ) {
                UserRoles r = userroles.get(userroles.indexOf(userRoles));
                userRoles.setId(r.getId());
                userRoles.setActive(true);
                userRolesLogic.update(userRoles);
            } else {
                userRolesLogic.insert(userRoles);
            }
            userroles2.add(userRoles);
        }

        for( UserRoles role : userroles ) {
            if( !userroles2.contains(role) ) {
                role.setActive(false);
                userRolesLogic.update(role);
            }
        }
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<UserAcc> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return userLogic.getListRestCrit(amount, fromRow, criteria);
    }


    @Override
    public long count(Criteria criteria) {
        return userLogic.count(criteria);
    }


    public Long insert(UserAcc entity) {
        return this.userLogic.insert(entity);
    }


    public UserAcc findByUserName(String username) {
        return this.userLogic.findByUserName(username);
    }

}
