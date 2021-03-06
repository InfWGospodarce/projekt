package org.pwr.transporter.entity.sales;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.pwr.transporter.entity.NamesForHibernate;
import org.pwr.transporter.entity.base.GenericDocument;


/**
 * <pre>
 *    Model for warehouse outgoing documents (WZ)
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.2
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = NamesForHibernate.ISSUE_DOCUMENT)
@PrimaryKeyJoinColumn(name = NamesForHibernate.GENERIC_DOCUMENT_ID)
public class GoodsIssuedNote extends GenericDocument {

	/**  */
	private static final long serialVersionUID = -7066029738333051290L;

	public GoodsIssuedNote() {
		rows = new ArrayList<GoodsIssuedNoteRow>();
	}

	// *******************************************************************************************************************************
	// ****** FIELDS
	// *******************************************************************************************************************************

	@OneToMany(mappedBy = "goodsIssuedNote", cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<GoodsIssuedNoteRow> rows;

	// *******************************************************************************************************************************
	// ****** GETTERS AND SETTERS
	// *******************************************************************************************************************************

	public List<GoodsIssuedNoteRow> getRows() {
		return this.rows;
	}

	public void setRows( List<GoodsIssuedNoteRow> rows ) {
		this.rows = rows;
	}

}
