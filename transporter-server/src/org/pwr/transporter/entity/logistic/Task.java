package org.pwr.transporter.entity.logistic;


import java.sql.Date;
import java.sql.Timestamp;
import java.text.*;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.datatype.Duration;

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
    // String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    
    
    @Column(name = "date")
    Timestamp date;
    
    @Column(name = "duration")
    Integer integer;
    
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Employee employee;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Vehicle vehicle;


    // *******************************************************************************************************************************
    // ****** GETTERS AND SETTERS
    // *******************************************************************************************************************************

    public Employee getEmployee() {
        return this.employee;
    }


    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    public Vehicle getVehicle() {
        return this.vehicle;
    }


    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    
    public Timestamp getDate() {
        return this.date;
    }


    public void setDate(Timestamp date) {
        this.date = date;
    }
    
    public Integer getInteger() {
        return this.integer;
    }


    public void setInteger(Integer integer) {
        this.integer = integer;
    
}}
