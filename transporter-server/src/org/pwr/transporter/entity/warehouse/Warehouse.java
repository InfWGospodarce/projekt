
package org.pwr.transporter.entity.warehouse;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.pwr.transporter.entity.GenericEntity;
import org.pwr.transporter.entity.base.Address;



/**
 * <pre>
 *    Define warehouse model.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.3
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "warehouse")
public class Warehouse extends GenericEntity {

    /**  */
    private static final long serialVersionUID = 3461170154496460630L;
    
    public Warehouse() {
		this.address = new Address();
	}

    // *******************************************************************************************************************************
    // ****** FIELDS
    // *******************************************************************************************************************************

    @OneToOne(cascade=CascadeType.ALL)
    @OnDelete(action=OnDeleteAction.CASCADE)
    Address address;


    // *******************************************************************************************************************************
    // ****** GETTERS AND SETTERS
    // *******************************************************************************************************************************

    public Address getAddress() {
        return this.address;
    }


    public void setAddress(Address address) {
        this.address = address;
    }
}
