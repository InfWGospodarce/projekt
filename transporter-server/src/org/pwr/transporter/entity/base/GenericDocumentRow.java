package org.pwr.transporter.entity.base;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.pwr.transporter.entity.Generic;
import org.pwr.transporter.entity.NamesForHibernate;
import org.pwr.transporter.entity.article.GenericWare;



/**
 * <pre>
 *     Abstract definition for document row.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.3
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = NamesForHibernate.GENERIC_DOCUMENT_ROW)
public abstract class GenericDocumentRow extends Generic implements Serializable {

    /**  */
    private static final long serialVersionUID = 8415513351044892188L;

    // *******************************************************************************************************************************
    // ****** FIELDS
    // *******************************************************************************************************************************

    @ManyToOne
    private GenericWare ware;

    @ManyToOne
    @JoinColumn(name = NamesForHibernate.GENERIC_DOCUMENT_ID)
    GenericDocument genericDocument;


    // *******************************************************************************************************************************
    // ****** GETTERS AND SETTERS
    // *******************************************************************************************************************************

    public GenericWare getWare() {
        return this.ware;
    }


    public void setWare(GenericWare ware) {
        this.ware = ware;
    }

}
