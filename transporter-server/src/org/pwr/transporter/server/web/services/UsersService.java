package org.pwr.transporter.server.web.services;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.Role;
import org.pwr.transporter.entity.UserRoles;
import org.pwr.transporter.entity.UserAcc;
import org.pwr.transporter.entity.base.Customer;
import org.pwr.transporter.server.business.AddressLogic;
import org.pwr.transporter.server.business.CustomerLogic;
import org.pwr.transporter.server.business.RoleLogic;
import org.pwr.transporter.server.business.UserRolesLogic;
import org.pwr.transporter.server.business.UsersLogic;
import org.pwr.transporter.server.dao.UsersDAO;
import org.pwr.transporter.server.web.form.CustomerAccountForm;
import org.pwr.transporter.server.web.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * <pre>
 *    Service for {@link UserAcc} entity.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.5
 */
public class UsersService {

	@Autowired
	UsersLogic usersLogic;

	@Autowired
	CustomerLogic customerLogic;

	@Autowired
	AddressLogic addressLogic;

	@Autowired
	UserRolesLogic userRolesLogic;

	@Autowired
	RoleLogic roleLogic;

	public UserAcc getByID( Long id ) {
		return this.usersLogic.getByID(id);
	}

	public List<UserAcc> getList() {
		return this.usersLogic.getList();
	}

	public List<UserAcc> search( Map<String, Object> parameterMap ) {
		return this.usersLogic.search(parameterMap);
	}

	public Long insert( CustomerAccountForm accountForm ) {
		Long baseAddresId = addressLogic.insert(accountForm.getBaseAddress());
		Long correAddresId = addressLogic.insert(accountForm.getCorrespondeAddress());
		Customer customer = accountForm.getCustomer();
		customer.setBaseAddress(addressLogic.getByID(baseAddresId));
		customer.setContacAddress(addressLogic.getByID(correAddresId));
		Long customerId = customerLogic.insert(customer);

		UserAcc user = accountForm.getUser();
		user.setPassword(accountForm.getPassword());
		user.setCustomer(customerLogic.getByID(customerId));
		Long userId = this.usersLogic.insert(user);
		UserAcc userL = usersLogic.getByID(userId);
		Role userRole = roleLogic.getByName("USER");
		Role customerRole = roleLogic.getByName("CUSTOMER");
		UserRoles userRoles = new UserRoles();
		userRoles.setRole(userRole);
		userRoles.setUserAcc(userL);
		userRolesLogic.insert(userRoles);

		UserRoles userRoles2 = new UserRoles();
		userRoles2.setRole(customerRole);
		userRoles2.setUserAcc(userL);
		userRolesLogic.insert(userRoles2);
		return userId;
	}

	public void update( UserAcc entity ) {
		this.usersLogic.update(entity);
	}

	public void delete( UserAcc entity ) {
		this.usersLogic.delete(entity);
	}

	public void deleteById( Long id ) {
		this.usersLogic.deleteById(id);
	}

	public void setUsersDAO( UsersDAO usersDAO ) {
		this.usersLogic.setUsersDAO(usersDAO);
	}

	public UserAcc getByUserName( String username ) {
		return this.usersLogic.getByUserName(username);
	}

	public UserAcc getByUserEmail( String email ) {
		return this.usersLogic.getByUserEmail(email);
	}

	public boolean checkUserLogin( UserForm user ) {
		return this.usersLogic.checkUserLogin(user.getUsername(), user.getPassword());
	}
}
