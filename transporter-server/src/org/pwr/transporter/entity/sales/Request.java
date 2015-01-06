package org.pwr.transporter.entity.sales;


import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.pwr.transporter.entity.NamesForHibernate;
import org.pwr.transporter.entity.base.GenericDocument;



/**
 * <pre>
 *    Sales request document from client.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.2
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = NamesForHibernate.REQUEST_DOCUMENT)
@PrimaryKeyJoinColumn(name = NamesForHibernate.GENERIC_DOCUMENT_ID)
public class Request extends GenericDocument {

    /**  */
    private static final long serialVersionUID = -5323409176872050200L;

    // *******************************************************************************************************************************
    // ****** FIELDS
    // *******************************************************************************************************************************

    @Column(name = "no_taxable_amount", nullable = false)
    private BigDecimal noTaxableAmount;

    @Column(name = "tax_amount", nullable = false)
    private BigDecimal taxAmount;

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
}
