package org.pwr.transporter.server.business;


import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.pwr.transporter.entity.UserAcc;
import org.pwr.transporter.server.dao.UsersDAO;


/**
 * <pre>
 *    Business logic for {@link UserAcc} entity.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.3
 */
public class UsersLogic {

	private static Logger LOGGER = Logger.getLogger(UsersLogic.class);

	UsersDAO usersDAO;

	public UserAcc getByID( Long id ) {
		UserAcc user = this.usersDAO.getByID(id);
		return user;
	}

	public List<UserAcc> getList() {
		return this.usersDAO.getList();
	}

	public List<UserAcc> search( Map<String, Object> parameterMap ) {
		return this.usersDAO.search(parameterMap);
	}

	public Long insert( UserAcc entity ) {
		entity.setSearchKey(entity.getUsername());
		return this.usersDAO.insert(entity);
	}

	public void update( UserAcc entity ) {
		this.usersDAO.update(entity);
	}

	public void delete( UserAcc entity ) {
		this.usersDAO.delete(entity);
	}

	public void deleteById( Long id ) {
		this.usersDAO.deleteById(id);
	}

	public void setUsersDAO( UsersDAO usersDAO ) {
		this.usersDAO = usersDAO;
	}

	public UserAcc getByUserName( String username ) {
		return this.usersDAO.getByUserName(username);
	}

	public UserAcc getByUserEmail( String email ) {
		return this.usersDAO.getByUserEmail(email);
	}

	public boolean checkUserLogin( String username, String password ) {
		if ( username == null || username.isEmpty() ) {
			return false;
		}
		UserAcc checkUser = this.usersDAO.getByUserName(username);
		if ( checkUser == null ) {
			LOGGER.debug("User not found");
			return false;
		}
		if ( !checkUser.checkPassword(password) ) {
			LOGGER.debug("Paswords not equals");
			return false;
		}
		return true;
	}

	private Object password() {
		// TODO Auto-generated method stub
		return null;
	}

}
