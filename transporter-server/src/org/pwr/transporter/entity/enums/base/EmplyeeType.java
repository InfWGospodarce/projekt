
package org.pwr.transporter.entity.enums.base;


import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.pwr.transporter.entity.enums.GenericEnum;



/**
 * <pre>
 *     Define employees types.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
@Entity
@Table(name = "enum_emplyee_type")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class EmplyeeType extends GenericEnum {

    /**  */
    private static final long serialVersionUID = -3757995009029736405L;

    // *******************************************************************************************************************************
    // ****** FIELDS
    // *******************************************************************************************************************************

    // *******************************************************************************************************************************
    // ****** GETTERS AND SETTERS
    // *******************************************************************************************************************************
}
