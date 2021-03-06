package org.pwr.transporter.entity.sales;


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.pwr.transporter.entity.NamesForHibernate;
import org.pwr.transporter.entity.base.GenericDocumentRow;
import org.pwr.transporter.entity.base.TaxItem;
//import org.pwr.transporter.entity.article.Bundle;



/**
 * <pre>
 *    Sales request document row model.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.3
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = NamesForHibernate.REQUEST_ROW)
@PrimaryKeyJoinColumn(name = NamesForHibernate.GENERIC_DOCUMENT_ROW_ID)
public class RequestRow extends GenericDocumentRow {

    /**  */
    private static final long serialVersionUID = 8707983872775670126L;

    // *******************************************************************************************************************************
    // ****** Fields
    // *******************************************************************************************************************************

    @ManyToOne
    private Request request;
    
//    @OneToMany 
//    private Bundle bundle;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "tax_percent")
    private BigDecimal taxPercent;

    @ManyToOne
    private TaxItem taxItem;

    @Transient
    private String taxItemId;

  

    // *******************************************************************************************************************************
    // ****** GETTERS AND SETTERS
    // *******************************************************************************************************************************
    public Request getRequest() {
        return this.request;
    }


    public void setRequest(Request request) {
        this.request = request;
    }


    public BigDecimal getPrice() {
        return this.price;
    }


    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public BigDecimal getTaxPercent() {
        return this.taxPercent;
    }


    public void setTaxPercent(BigDecimal taxPercent) {
        this.taxPercent = taxPercent;
    }


    public TaxItem getTaxItem() {
        return this.taxItem;
    }


    public void setTaxItem(TaxItem taxItem) {
        this.taxItem = taxItem;
    }


    public String getTaxItemId() {
        return this.taxItemId;
    }


    public void setTaxItemId(String taxItemId) {
        this.taxItemId = taxItemId;
    }


    @Override
    public String getWareId() {
        return super.getWareId();
    }


    @Override
    public void setWareId(String wareId) {
        // TODO Auto-generated method stub
        super.setWareId(wareId);
    }
}
