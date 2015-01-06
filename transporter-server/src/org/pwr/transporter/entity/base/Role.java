package org.pwr.transporter.entity.base;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.pwr.transporter.entity.GenericEntity;
import org.pwr.transporter.entity.NamesForHibernate;



/**
 * <pre>
 *    Define users roles.
 * </pre>
 * <hr/>
 * 
 * @author x0r
 * @version 0.0.4
 */
@Entity
@Table(name = NamesForHibernate.ROLE)
public class Role extends GenericEntity {

    /**  */
    private static final long serialVersionUID = 522326271270007902L;

    // *******************************************************************************************************************************
    // ****** FIELDS
    // *******************************************************************************************************************************

    @Column(name = "description")
    private String description;


    // *******************************************************************************************************************************
    // ****** LOGIC
    // *******************************************************************************************************************************

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( this.getName() == null ) ? 0 : this.getName().hashCode() );
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
        Role other = (Role) obj;
        if( this.getName() == null ) {
            if( other.getName() != null )
                return false;
        } else if( !this.getName().equals(other.getName()) )
            return false;
        return true;
    }


    // *******************************************************************************************************************************
    // ****** GETTERS AND SETTERS
    // *******************************************************************************************************************************

    public String getDescription() {
        return this.description;
    }


    public void setDescription(String description) {
        this.description = description;
    }
}
