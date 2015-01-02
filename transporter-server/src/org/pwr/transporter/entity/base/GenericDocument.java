package org.pwr.transporter.entity.base;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.pwr.transporter.entity.Generic;
import org.pwr.transporter.entity.NamesForHibernate;



/**
 * <pre>
 *    Base abstract document for all other documents.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.5
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = NamesForHibernate.GENERIC_DOCUMENT)
public abstract class GenericDocument extends Generic implements Serializable {

    /**  */
    private static final long serialVersionUID = -2711151678883226411L;

    // *******************************************************************************************************************************
    // ****** FIELDS
    // *******************************************************************************************************************************

    @ManyToOne
    private Customer customer;

    @OneToOne
    private Address deliveryAddress;

    @OneToMany(mappedBy = "genericDocument")
    private Set<GenericDocumentRow> rowList;


    // *******************************************************************************************************************************
    // ****** GETTERS AND SETTERS
    // *******************************************************************************************************************************

    public Customer getCustomer() {
        return this.customer;
    }


    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public Address getDeliveryAddress() {
        return this.deliveryAddress;
    }


    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }


    public Set<GenericDocumentRow> getRowList() {
        return this.rowList;
    }


    public void setRowList(Set<GenericDocumentRow> rowList) {
        this.rowList = rowList;
    }

}
