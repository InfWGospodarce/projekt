package org.pwr.transporter.entity.base;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.pwr.transporter.entity.GenericEntity;



/**
 * <pre>
 *    Base unit model class
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
@Entity
@Table(name = "unit")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Unit extends GenericEntity {

    private static final long serialVersionUID = 2649860719507812031L;

    // *******************************************************************************************************************************
    // ****** Fields
    // *******************************************************************************************************************************

    @Column(name = "code")
    private String code;

    @Column(name = "iso_code")
    private String ISOCode;

    @Column(name = "sign")
    private String sign;


    // *******************************************************************************************************************************
    // ****** GETTERS & SETTERS
    // *******************************************************************************************************************************

    public String getCode() {
        return this.code;
    }


    public void setCode(String code) {
        this.code = code;
    }


    public String getISOCode() {
        return this.ISOCode;
    }


    public void setISOCode(String iSOCode) {
        this.ISOCode = iSOCode;
    }


    public String getSign() {
        return this.sign;
    }


    public void setSign(String sign) {
        this.sign = sign;
    }
}
