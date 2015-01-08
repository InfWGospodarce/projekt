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
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;



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
    @NumberFormat(style = Style.NUMBER)
    Timestamp date;
    
    
    @Column(name = "duration")
    @NumberFormat(style = Style.NUMBER)
    Integer duration;
    
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @NumberFormat(style = Style.NUMBER)
    private Employee employee;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @NumberFormat(style = Style.NUMBER)
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
    
    public Integer getDuration() {
        return this.duration;
    }


    public void setDuration(Integer duration) {
        this.duration = duration;
    
}}
