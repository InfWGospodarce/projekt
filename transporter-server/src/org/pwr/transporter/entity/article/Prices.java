package org.pwr.transporter.entity.article;


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.pwr.transporter.entity.GenericEntity;



/**
 * <pre>
 *    TaxItem model
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
@Entity
@Table(name = "prices")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Prices extends GenericEntity {

    /**  */
    private static final long serialVersionUID = -6902716570709450887L;

    // *******************************************************************************************************************************
    // ****** FIELDS
    // *******************************************************************************************************************************

    @Column(name = "date")
    private Date date;

    @ManyToOne
    private Article article;

    @Column(name = "price")
    private BigDecimal price;


    // *******************************************************************************************************************************
    // ****** GETTERS AND SETTERS
    // *******************************************************************************************************************************

    public Date getDate() {
        return this.date;
    }


    public void setDate(Date date) {
        this.date = date;
    }


    public Article getArticle() {
        return this.article;
    }


    public void setArticle(Article article) {
        this.article = article;
    }


    public BigDecimal getPrice() {
        return this.price;
    }


    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
