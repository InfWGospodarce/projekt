package org.pwr.transporter.entity.base;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import org.pwr.transporter.entity.GenericEntity;



/**
 * <pre>
 *     Base for other classes using person e.g. Customer.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.6
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person extends GenericEntity {

    /**  */
    private static final long serialVersionUID = 5874687155183652078L;

    // *******************************************************************************************************************************
    // ****** FIELDS
    // *******************************************************************************************************************************

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @OneToOne(optional = false)
    private Address baseAddress;

    @OneToOne(optional = true)
    private Address contacAddress;

    @Column(name = "nip")
    private String nip;

    @Column(name = "email")
    private String email;


    public Person() {
        name = null;
        surname = null;
    }


    // *******************************************************************************************************************************
    // ****** GETTERS AND SETTERS
    // *******************************************************************************************************************************

    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String getSurname() {
        return this.surname;
    }


    public Address getBaseAddress() {
        return this.baseAddress;
    }


    public void setBaseAddress(Address baseAddress) {
        this.baseAddress = baseAddress;
    }


    public Address getContacAddress() {
        return this.contacAddress;
    }


    public void setContacAddress(Address contacAddress) {
        this.contacAddress = contacAddress;
    }


    public String getNip() {
        return this.nip;
    }


    public void setNip(String nip) {
        this.nip = nip;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getEmail() {
        return this.email;
    }

}
