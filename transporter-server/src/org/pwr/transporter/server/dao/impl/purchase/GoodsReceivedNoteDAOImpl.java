package org.pwr.transporter.server.dao.impl.purchase;


import org.pwr.transporter.entity.purchase.GoodsReceivedNote;
import org.pwr.transporter.server.dao.impl.GenericDocumentDAOImpl;
import org.pwr.transporter.server.dao.purchase.GoodsReceivedNoteDAO;



/**
 * <pre>
 *     Custom implementations for {@link GoodsReceivedNote}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class GoodsReceivedNoteDAOImpl extends GenericDocumentDAOImpl<GoodsReceivedNote> implements GoodsReceivedNoteDAO {

    public GoodsReceivedNoteDAOImpl() {
        setEntityClass(GoodsReceivedNote.class);
    }

}
