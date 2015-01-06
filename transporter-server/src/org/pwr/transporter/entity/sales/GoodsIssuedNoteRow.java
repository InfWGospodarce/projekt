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



/**
 * <pre>
 *     Model for warehouse outgoing documents rows (WZ)
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.2
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = NamesForHibernate.ISSUE_ROW)
@PrimaryKeyJoinColumn(name = NamesForHibernate.GENERIC_DOCUMENT_ROW_ID)
public class GoodsIssuedNoteRow extends GenericDocumentRow {

    /**  */
    private static final long serialVersionUID = -5693577206793727272L;

    // *******************************************************************************************************************************
    // ****** Fields
    // *******************************************************************************************************************************

    @ManyToOne
    private GoodsIssuedNote goodsIssuedNote;

    @Column(name = "price", nullable = false)
    private BigDecimal price;


    // *******************************************************************************************************************************
    // ****** GETTERS AND SETTERS
    // *******************************************************************************************************************************
    public GoodsIssuedNote getGoodsIssuedNote() {
        return this.goodsIssuedNote;
    }


    public void setGoodsIssuedNote(GoodsIssuedNote goodsIssuedNote) {
        this.goodsIssuedNote = goodsIssuedNote;
    }


    public BigDecimal getPrice() {
        return this.price;
    }


    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
