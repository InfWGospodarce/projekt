package org.pwr.transporter.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;



/**
 * <pre>
 *     Base for all other class (each entity class must inherit this class).
 * contains shared fields that will be added to each table.
 * </pre>
 * <hr/>
 * 
 * @author W.S
 * @version 0.0.5
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class GenericEntity implements Serializable {

    private static final long serialVersionUID = 4669201971220084206L;


    public GenericEntity() {
        active = true;
    }


    // *******************************************************************************************************************************
    // ****** FIELDS
    // *******************************************************************************************************************************
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "search_key", nullable = false)
    private String searchKey;

    @Column(name = "active", nullable = false)
    private boolean active;


    public Long getId() {
        return id;
    }


    // *******************************************************************************************************************************
    // ****** GETTERS AND SETTERS
    // *******************************************************************************************************************************
    public void setId(Long id) {
        this.id = id;
    }


    public String getSearchKey() {
        return searchKey;
    }


    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }


    public void setActive(boolean active) {
        this.active = active;
    }


    public boolean isActive() {
        return this.active;
    }
}
