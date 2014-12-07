package org.pwr.transporter.entity.base;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.pwr.transporter.entity.GenericEntity;
import org.pwr.transporter.entity.NamesForHibernate;



/**
 * <pre>
 *    Our company data
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.2
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = NamesForHibernate.COMPANY_DATA)
public class CompanyData extends GenericEntity {

    /**  */
    private static final long serialVersionUID = 5335415521768196147L;

    // *******************************************************************************************************************************
    // ****** Fields
    // *******************************************************************************************************************************
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private Address address;

    @Column(name = "nip", nullable = false)
    private String nip;

    @Column(name = "regon", nullable = false)
    private String regon;


    // *******************************************************************************************************************************
    // ****** GETTERS & SETTERS
    // *******************************************************************************************************************************

    public String getName() {
        return this.name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Address getAddress() {
        return this.address;
    }


    public void setAddress(Address address) {
        this.address = address;
    }


    public String getNip() {
        return this.nip;
    }


    public void setNip(String nip) {
        this.nip = nip;
    }


    public String getRegon() {
        return this.regon;
    }


    public void setRegon(String regon) {
        this.regon = regon;
    }

}
