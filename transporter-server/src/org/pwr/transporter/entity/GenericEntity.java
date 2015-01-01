package org.pwr.transporter.entity;


import java.io.Serializable;

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
 * @version 0.0.7
 */
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class GenericEntity extends Generic implements Serializable {

    private static final long serialVersionUID = 4669201971220084206L;


    public GenericEntity() {
    }

    // *******************************************************************************************************************************
    // ****** FIELDS
    // *******************************************************************************************************************************

    // *******************************************************************************************************************************
    // ****** GETTERS AND SETTERS
    // *******************************************************************************************************************************
}
