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
@Table(name = NamesForHibernate.USER_ROLE)
public class UserRoles extends GenericEntity {

    /**  */
    private static final long serialVersionUID = -1624679923069024257L;

    // *******************************************************************************************************************************
    // ****** FIELDS
    // *******************************************************************************************************************************

    @ManyToOne
    @JoinColumn(name = NamesForHibernate.USER_ID, nullable = false)
    private UserAcc useracc;

    @ManyToOne
    @JoinColumn(name = NamesForHibernate.ROLE_ID, nullable = false)
    private Role role;


    // *******************************************************************************************************************************
    // ****** GETTERS AND SETTERS
    // *******************************************************************************************************************************

    public UserAcc getUserAcc() {
        return this.useracc;
    }


    public Role getRole() {
        return this.role;
    }


    public void setUserAcc(UserAcc user) {
        this.useracc = user;
    }


    public void setRole(Role role) {
        this.role = role;
    }
}
