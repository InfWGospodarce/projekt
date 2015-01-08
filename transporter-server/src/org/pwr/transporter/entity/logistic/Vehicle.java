
package org.pwr.transporter.entity.logistic;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.pwr.transporter.entity.GenericEntity;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;



/**
 * <pre>
 *    Describe vehicle object for logistic.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "vehicle")
public class Vehicle extends GenericEntity {

    /**  */
    private static final long serialVersionUID = -7221918298946791309L;

    // *******************************************************************************************************************************
    // ****** FIELDS
    // *******************************************************************************************************************************
    @Column(name = "plate")
    @Size(min=5)
    String plate;

    // *******************************************************************************************************************************
    // ****** GETTERS AND SETTERS
    // *******************************************************************************************************************************

    
    public String getPlate() {
		return plate;
	}
    
    public void setPlate(String plate) {
		this.plate = plate;
	}
}
