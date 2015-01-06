package org.pwr.transporter.entity.base;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.pwr.transporter.entity.GenericEntity;



/**
 * <pre>
 *    Currency model
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
@Entity
@Table(name = "currency")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Currency extends GenericEntity {

    /**  */
    private static final long serialVersionUID = -6902716570709450887L;

    @Column(name = "code")
    private String code;


    public String getCode() {
        return this.code;
    }


    public void setCode(String code) {
        this.code = code;
    }

}
