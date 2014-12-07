package org.pwr.transporter.entity.logistic;


import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.pwr.transporter.entity.GenericEntity;
import org.pwr.transporter.entity.base.Employee;



/**
 * <pre>
 *    Tasks for employees.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.3
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "task")
public class Task extends GenericEntity {

    /**  */
    private static final long serialVersionUID = -5953617882250989872L;

    // *******************************************************************************************************************************
    // ****** FIELDS
    // *******************************************************************************************************************************

    @ManyToOne(optional = false)
    private Employee employee;

    @ManyToOne(optional = false)
    private Vehicle vehicle;


    // *******************************************************************************************************************************
    // ****** GETTERS AND SETTERS
    // *******************************************************************************************************************************

    public Employee getEmployee() {
        return this.employee;
    }


    public void setEmployee(Employee emplyee) {
        this.employee = emplyee;
    }


    public Vehicle getVehicle() {
        return this.vehicle;
    }


    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
