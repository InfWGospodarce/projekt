package org.pwr.transporter.entity;


import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



/**
 * <pre>
 *    Define user roles.
 * </pre>
 * <hr/>
 * 
 * @author x0r
 * @version 0.0.4
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = NamesForHibernate.USER_ROLES)
public class UserRoles extends GenericEntity {

    /**  */
    private static final long serialVersionUID = -1624679923069024257L;

    // *******************************************************************************************************************************
    // ****** FIELDS
    // *******************************************************************************************************************************

    @ManyToOne
    @JoinColumn(name = NamesForHibernate.USERS_ID, nullable = false)
    private Users users;

    @ManyToOne
    @JoinColumn(name = NamesForHibernate.ROLE_ID, nullable = false)
    private Role role;


    // *******************************************************************************************************************************
    // ****** GETTERS AND SETTERS
    // *******************************************************************************************************************************

    public Users getUsers() {
        return this.users;
    }


    public Role getRole() {
        return this.role;
    }


    public void setUsers(Users user) {
        this.users = user;
    }


    public void setRole(Role role) {
        this.role = role;
    }
}
