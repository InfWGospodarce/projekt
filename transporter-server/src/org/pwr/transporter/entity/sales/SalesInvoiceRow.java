package org.pwr.transporter.entity.sales;


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.pwr.transporter.entity.NamesForHibernate;
import org.pwr.transporter.entity.base.GenericDocumentRow;
import org.pwr.transporter.entity.base.TaxItem;



/**
 * <pre>
 *    Financial outgoing document row model.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.2
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = NamesForHibernate.SALES_INVOICE_ROW)
@PrimaryKeyJoinColumn(name = NamesForHibernate.GENERIC_DOCUMENT_ROW_ID)
public class SalesInvoiceRow extends GenericDocumentRow {

    /**  */
    private static final long serialVersionUID = -2856054968172153605L;

    // *******************************************************************************************************************************
    // ****** Fields
    // *******************************************************************************************************************************

    @ManyToOne
    private SalesInvoice salesInvoice;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "tax_percent")
    private BigDecimal taxPercent;

    @ManyToOne
    private TaxItem taxItem;


    // *******************************************************************************************************************************
    // ****** GETTERS AND SETTERS
    // *******************************************************************************************************************************
    public SalesInvoice getSalesInvoice() {
        return this.salesInvoice;
    }


    public void setSalesInvoice(SalesInvoice salesInvoice) {
        this.salesInvoice = salesInvoice;
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

}
