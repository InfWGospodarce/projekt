package org.pwr.transporter.entity.purchase;


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
 *    Model for warehouse incoming documents (PZ)
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.2
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = NamesForHibernate.RECEIVE_DOCUMENT)
@PrimaryKeyJoinColumn(name = NamesForHibernate.GENERIC_DOCUMENT_ID)
public class GoodsReceivedNote extends GenericDocument {

    /**  */
    private static final long serialVersionUID = -5882767320149167172L;

    // *******************************************************************************************************************************
    // ****** FIELDS
    // *******************************************************************************************************************************

    @Column(name = "no_taxable_amount", nullable = false)
    private BigDecimal noTaxableAmount;

    @Column(name = "tax_amount", nullable = false)
    private BigDecimal taxAmount;

    @OneToMany(mappedBy = "goodsReceivedNote", cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<GoodsReceivedNoteRow> rows;


    // *******************************************************************************************************************************
    // ****** GETTERS AND SETTERS
    // *******************************************************************************************************************************

    public List<GoodsReceivedNoteRow> getRows() {
        return this.rows;
    }


    public void setRows(List<GoodsReceivedNoteRow> rows) {
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
