package org.pwr.transporter.entity.base;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
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
 * @version 0.0.7
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

    @OneToOne
    private GenericDocument previousDocument;

    @OneToOne
    private GenericDocument nextDocument;

    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @Column(name = "modify_date", nullable = false)
    private Date modifyDate;

    @Column(name = "no_taxable_amount", nullable = false)
    private BigDecimal noTaxableAmount;

    @Column(name = "tax_amount", nullable = false)
    private BigDecimal taxAmount;

    @ManyToOne
    private Currency currency;


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


    public Date getCreateDate() {
        return this.createDate;
    }


    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    public Currency getCurrency() {
        return this.currency;
    }


    public void setCurrency(Currency currency) {
        this.currency = currency;
    }


    public GenericDocument getPreviousDocument() {
        return this.previousDocument;
    }


    public void setPreviousDocument(GenericDocument previousDocument) {
        this.previousDocument = previousDocument;
    }


    public Date getModifyDate() {
        return this.modifyDate;
    }


    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}
