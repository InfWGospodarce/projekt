package org.pwr.transporter.server.dao.impl.sales;


import org.pwr.transporter.entity.sales.GoodsIssuedNoteRow;
import org.pwr.transporter.server.dao.impl.GenericDocumentRowDAOImpl;
import org.pwr.transporter.server.dao.sales.GoodsIssuedNoteRowDAO;



/**
 * <pre>
 *     Custom implementations for {@link GoodsIssueNoteRow}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class GoodsIssuedNoteRowDAOImpl extends GenericDocumentRowDAOImpl<GoodsIssuedNoteRow> implements GoodsIssuedNoteRowDAO {

    public GoodsIssuedNoteRowDAOImpl() {
        setEntityClass(GoodsIssuedNoteRow.class);
    }

}
