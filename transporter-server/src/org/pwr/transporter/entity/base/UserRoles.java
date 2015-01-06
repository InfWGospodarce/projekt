package org.pwr.transporter.entity.base;


import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.pwr.transporter.entity.GenericEntity;
import org.pwr.transporter.entity.NamesForHibernate;



/**
 * <pre>
 *    Define user roles.
 * </pre>
 * <hr/>
 * 
 * @author x0r
 * @version 0.0.5
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

    @ManyToOne(optional = false)
    // @JoinColumn(name = NamesForHibernate.USER_ID, nullable = false)
    private UserAcc useracc;

    @ManyToOne(optional = false)
    // @JoinColumn(name = NamesForHibernate.ROLE_ID, nullable = false)
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


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( this.role == null ) ? 0 : this.role.hashCode() );
        result = prime * result + ( ( this.useracc == null ) ? 0 : this.useracc.hashCode() );
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if( this == obj )
            return true;
        if( obj == null )
            return false;
        if( getClass() != obj.getClass() )
            return false;
        UserRoles other = (UserRoles) obj;
        if( this.role == null ) {
            if( other.role != null )
                return false;
        } else if( !this.role.equals(other.role) )
            return false;
        if( this.useracc == null ) {
            if( other.useracc != null )
                return false;
        } else if( !this.useracc.equals(other.useracc) )
            return false;
        return true;
    }

}
