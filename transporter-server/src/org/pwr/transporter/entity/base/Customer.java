package org.pwr.transporter.entity.base;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;



/**
 * <pre>
 *    Customer data model.
 * </pre>
 * <hr/>
 * 
 * @author x0r
 * @version 0.0.6
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "customer")
public class Customer extends Person {

    /**  */
    private static final long serialVersionUID = -4846713817748229295L;

    public static final String TABLE_NAME = "customer";

    // *******************************************************************************************************************************
    // ****** FIELDS
    // *******************************************************************************************************************************

    @OneToMany(mappedBy = TABLE_NAME)
    Set<Address> deliveryAddress;

    @Column(name = "regon")
    private String regon;

    @Column(name = "company", nullable = false)
    private boolean company;

    @Column(name = "companyName")
    private String companyName;


    // *******************************************************************************************************************************
    // ****** GETTERS AND SETTERS
    // *******************************************************************************************************************************

    public Set<Address> getDeliveryAddress() {
        return this.deliveryAddress;
    }


    public void setDeliveryAddress(Set<Address> deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }


    public void setRegon(String regon) {
        this.regon = regon;
    }


    public String getRegon() {
        return this.regon;
    }


    public boolean isCompany() {
        return this.company;
    }


    public void setCompany(boolean company) {
        this.company = company;
    }


    public String getCompanyName() {
        return this.companyName;
    }


    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
