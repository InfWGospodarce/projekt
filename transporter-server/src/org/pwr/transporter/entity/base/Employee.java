package org.pwr.transporter.entity.base;


import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.pwr.transporter.entity.enums.base.EmplyeeType;



/**
 * <pre>
 * Company emplyees model.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.3
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "employee")
public class Employee extends Person {

    /**  */
    private static final long serialVersionUID = 8855580555292412125L;

    @ManyToOne(optional = false)
    private EmplyeeType emplyeeType;

    // *******************************************************************************************************************************
    // ****** FIELDS
    // *******************************************************************************************************************************

    // *******************************************************************************************************************************
    // ****** GETTERS AND SETTERS
    // *******************************************************************************************************************************

}
