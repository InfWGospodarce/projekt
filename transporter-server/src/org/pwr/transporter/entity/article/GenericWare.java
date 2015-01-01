package org.pwr.transporter.entity.article;


import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.pwr.transporter.entity.Generic;
import org.pwr.transporter.entity.NamesForHibernate;



/**
 * <pre>
 *     Interface for all storage objects.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.5
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = NamesForHibernate.GENERIC_WARE)
public abstract class GenericWare extends Generic implements Serializable {

    /**  */
    private static final long serialVersionUID = -3960765434403545102L;


    public GenericWare() {
    }


    // *******************************************************************************************************************************
    // ****** FIELDS
    // *******************************************************************************************************************************
    @Column(name = "width")
    private BigDecimal width;

    @Column(name = "height")
    private BigDecimal height;

    @Column(name = "depth")
    private BigDecimal depth;

    @Column(name = "weight")
    private BigDecimal weight;


    // *******************************************************************************************************************************
    // ****** GETTERS AND SETTERS
    // *******************************************************************************************************************************

    public BigDecimal getWidth() {
        return this.width;
    }


    public void setWidth(BigDecimal width) {
        this.width = width;
    }


    public BigDecimal getHeight() {
        return this.height;
    }


    public void setHeight(BigDecimal height) {
        this.height = height;
    }


    public BigDecimal getDepth() {
        return this.depth;
    }


    public void setDepth(BigDecimal depth) {
        this.depth = depth;
    }


    public BigDecimal getWeight() {
        return this.weight;
    }


    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

}
