package org.pwr.transporter.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * <pre>
 *    Define users roles.
 * </pre>
 * <hr/>
 * 
 * @author x0r
 * @version 0.0.3
 */
@Entity
@Table(name = NamesForHibernate.ROLE)
public class Role extends GenericEntity {

	/**  */
	private static final long serialVersionUID = 522326271270007902L;

	// *******************************************************************************************************************************
	// ****** FIELDS
	// *******************************************************************************************************************************

	@Column
	private String name;

	// *******************************************************************************************************************************
	// ****** LOGIC
	// *******************************************************************************************************************************

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals( Object obj ) {
		if ( this == obj ) return true;
		if ( obj == null ) return false;
		if ( getClass() != obj.getClass() ) return false;
		Role other = (Role) obj;
		if ( name == null ) {
			if ( other.name != null ) return false;
		} else if ( !name.equals(other.name) ) return false;
		return true;
	}

	// *******************************************************************************************************************************
	// ****** GETTERS AND SETTERS
	// *******************************************************************************************************************************

	public String getName() {
		return this.name;
	}

	public void setName( String name ) {
		this.name = name;
	}
}
