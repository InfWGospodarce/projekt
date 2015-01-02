package org.pwr.transporter.entity.base;


import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.pwr.transporter.entity.enums.base.EmployeeType;



/**
 * <pre>
 * Company emplyees model.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.4
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "employee")
public class Employee extends Person {

    /**  */
    private static final long serialVersionUID = 8855580555292412125L;

    @ManyToOne(optional = false)
    private EmployeeType employeeType;


    // *******************************************************************************************************************************
    // ****** FIELDS
    // *******************************************************************************************************************************

    // *******************************************************************************************************************************
    // ****** GETTERS AND SETTERS
    // *******************************************************************************************************************************

    public EmployeeType getEmployeeType() {
        return this.employeeType;
    }


    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }
}
