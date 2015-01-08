package org.pwr.transporter.entity.base;


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.pwr.transporter.entity.GenericEntity;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;


/**
 * <pre>
 *    TaxItem model
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
@Entity
@Table(name = "tax_item")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class TaxItem extends GenericEntity {

	/**  */
	private static final long serialVersionUID = -6902716570709450887L;

	// *******************************************************************************************************************************
	// ****** FIELDS
	// *******************************************************************************************************************************

	@Column(name = "tax_percent")
	@NumberFormat(style = Style.PERCENT)
	private BigDecimal taxPercent;

	@Column(name = "tax_free")
	private boolean taxFree;

	// *******************************************************************************************************************************
	// ****** GETTERS AND SETTERS
	// *******************************************************************************************************************************

	public BigDecimal getTaxPercent() {
		return this.taxPercent;
	}

	public void setTaxPercent( BigDecimal taxPercent ) {
		this.taxPercent = taxPercent;
	}

	public boolean isTaxFree() {
		return this.taxFree;
	}

	public void setTaxFree( boolean taxFree ) {
		this.taxFree = taxFree;
	}

}
