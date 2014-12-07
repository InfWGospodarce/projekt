package org.pwr.transporter.entity.base;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.pwr.transporter.entity.GenericEntity;
import org.pwr.transporter.entity.enums.base.AddrStreetPrefix;



/**
 * <pre>
 *     Standard table, define address.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.1.0
 */
@Entity
@Table(name = "address")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Address extends GenericEntity {

    private static final long serialVersionUID = 3223188310530625995L;

    // *******************************************************************************************************************************
    // ****** FIELDS
    // *******************************************************************************************************************************
    @ManyToOne(optional = false)
    private AddrStreetPrefix addrStreetPrefix;

    @ManyToOne(optional = false)
    private Country country;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "street")
    private String street;

    @Column(name = "local")
    private String local;

    @Column(name = "city")
    private String city;

    @Column(name = "post_city")
    private String postCity;

    @ManyToOne(optional = true)
    private Customer customer;

    @Transient
    private String countryId;

    @Transient
    private String addrStreetPrefixId;


    // *******************************************************************************************************************************
    // ****** GETTERS & SETTERS
    // *******************************************************************************************************************************

    public AddrStreetPrefix getAddrStreetPrefix() {
        return this.addrStreetPrefix;
    }


    public void setAddrStreetPrefix(AddrStreetPrefix addrStreetPrefix) {
        this.addrStreetPrefix = addrStreetPrefix;
    }


    public Country getCountry() {
        return country;
    }


    public void setCountry(Country country) {
        this.country = country;
    }


    public String getZipCode() {
        return zipCode;
    }


    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }


    public String getLocal() {
        return local;
    }


    public void setLocal(String local) {
        this.local = local;
    }


    public String getCity() {
        return city;
    }


    public void setCity(String city) {
        this.city = city;
    }


    public String getPostCity() {
        return postCity;
    }


    public void setPostCity(String postCity) {
        this.postCity = postCity;
    }


    public String getStreet() {
        return this.street;
    }


    public void setStreet(String street) {
        this.street = street;
    }


    public String getCountryId() {
        return this.countryId;
    }


    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }


    public String getAddrStreetPrefixId() {
        return this.addrStreetPrefixId;
    }


    public void setAddrStreetPrefixId(String addrStreetPrefixId) {
        this.addrStreetPrefixId = addrStreetPrefixId;
    }
}
