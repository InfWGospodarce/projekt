package org.pwr.transporter.server.dao.impl.purchase;


import org.pwr.transporter.entity.purchase.GoodsReceivedNoteRow;
import org.pwr.transporter.server.dao.impl.GenericDocumentRowDAOImpl;
import org.pwr.transporter.server.dao.purchase.GoodsReceivedNoteRowDAO;



/**
 * <pre>
 *     Custom implementations for {@link GoodsReceivedNoteRow}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class GoodsReceivedNoteRowDAOImpl extends GenericDocumentRowDAOImpl<GoodsReceivedNoteRow> implements GoodsReceivedNoteRowDAO {

    public GoodsReceivedNoteRowDAOImpl() {
        setEntityClass(GoodsReceivedNoteRow.class);
    }

}
