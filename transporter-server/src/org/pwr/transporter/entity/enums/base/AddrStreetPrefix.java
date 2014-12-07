package org.pwr.transporter.entity.enums.base;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.pwr.transporter.entity.enums.GenericEnum;



/**
 * <pre>
 *     Standard enumeration for define street prefixes.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.3
 */
@Entity
@Table(name = "addr_street_prefix")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AddrStreetPrefix extends GenericEnum {

    /**  */
    private static final long serialVersionUID = 4257968750152980117L;

    // *******************************************************************************************************************************
    // ****** FIELDS
    // *******************************************************************************************************************************
    @Column(name = "nprefix")
    private String prefix;


    // *******************************************************************************************************************************
    // ****** GETTERS AND SETTERS
    // *******************************************************************************************************************************

    public String getPrefix() {
        return prefix;
    }


    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

}
