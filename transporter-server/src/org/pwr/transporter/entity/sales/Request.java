package org.pwr.transporter.entity.sales;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.pwr.transporter.entity.NamesForHibernate;
import org.pwr.transporter.entity.base.Address;
import org.pwr.transporter.entity.base.GenericDocument;
import org.pwr.transporter.entity.enums.documents.OrderType;



/**
 * <pre>
 *    Sales request document from client.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.3
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = NamesForHibernate.REQUEST_DOCUMENT)
@PrimaryKeyJoinColumn(name = NamesForHibernate.GENERIC_DOCUMENT_ID)
public class Request extends GenericDocument {

    /**  */
    private static final long serialVersionUID = -5323409176872050200L;


    public Request() {
        rows = new ArrayList<RequestRow>();
    }


    // *******************************************************************************************************************************
    // ****** FIELDS
    // *******************************************************************************************************************************

    @Column(name = "no_taxable_amount", nullable = false)
    private BigDecimal noTaxableAmount;

    @Column(name = "tax_amount", nullable = false)
    private BigDecimal taxAmount;

    // mamy juz delivery addres wiec to raczej odpada
    // @Column(name = "AdrReceiver")
    // private String AdrReceiver;

    @OneToOne
    private Address targetAddress;

    @Transient
    private String targetAddressId;

    @Column(name = "order_type")
    private OrderType orderType;

    @Transient
    private String orderTypeValue;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "request", cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<RequestRow> rows;


    // *******************************************************************************************************************************
    // ****** GETTERS AND SETTERS
    // *******************************************************************************************************************************

    public List<RequestRow> getRows() {
        return this.rows;
    }


    public void setRows(List<RequestRow> rows) {
        this.rows = rows;
    }


    public BigDecimal getNoTaxableAmount() {
        return this.noTaxableAmount;
    }


    public void setNoTaxableAmount(BigDecimal noTaxableAmount) {
        this.noTaxableAmount = noTaxableAmount;
    }


    public BigDecimal getTaxAmount() {
        return this.taxAmount;
    }


    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }


    public Address getTargetAddress() {
        return targetAddress;
    }


    public void setTargetAddress(Address targetAddress) {
        this.targetAddress = targetAddress;
    }


    public String getDescription() {
        return this.description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getTargetAddressId() {
        return this.targetAddressId;
    }


    public void setTargetAddressId(String targetAddressId) {
        this.targetAddressId = targetAddressId;
    }


    public OrderType getOrderType() {
        return this.orderType;
    }


    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }


    public String getOrderTypeValue() {
        return this.orderTypeValue;
    }


    public void setOrderTypeValue(String orderTypeValue) {
        this.orderTypeValue = orderTypeValue;
    }

}
