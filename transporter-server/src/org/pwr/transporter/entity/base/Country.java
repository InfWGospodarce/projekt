package org.pwr.transporter.entity.base;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.pwr.transporter.entity.GenericEntity;



/**
 * <pre>
 *    Base country class
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.5
 */
@Entity
@Table(name = "country")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Country extends GenericEntity {

    private static final long serialVersionUID = 2649860719507812031L;

    // *******************************************************************************************************************************
    // ****** Fields
    // *******************************************************************************************************************************

    @Column(name = "native_name")
    private String nativeName;

    @Column(name = "code")
    private String code;

    @Column(name = "code_eu")
    private String codeEU;

    @Column(name = "iso_code")
    private String ISOCode;

    @OneToOne
    private Currency currency;


    // *******************************************************************************************************************************
    // ****** GETTERS & SETTERS
    // *******************************************************************************************************************************

    public Currency getCurrency() {
        return this.currency;
    }


    public void setCurrency(Currency currency) {
        this.currency = currency;
    }


    public String getNativeName() {
        return this.nativeName;
    }


    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }


    public String getCode() {
        return this.code;
    }


    public void setCode(String code) {
        this.code = code;
    }


    public String getCodeEU() {
        return this.codeEU;
    }


    public void setCodeEU(String codeEU) {
        this.codeEU = codeEU;
    }


    public String getISOCode() {
        return this.ISOCode;
    }


    public void setISOCode(String iSOCode) {
        this.ISOCode = iSOCode;
    }
}
