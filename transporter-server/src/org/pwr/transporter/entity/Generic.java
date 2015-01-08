package org.pwr.transporter.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;



/**
 * <pre>
 *    Generic generic
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.2
 */
@MappedSuperclass
public abstract class Generic implements Serializable {

    /**  */
    private static final long serialVersionUID = 8947615034324603164L;


    public Generic() {
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

    @Column(name = "name")
    private String name;


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


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

}
