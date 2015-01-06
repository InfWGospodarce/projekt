package org.pwr.transporter.server.dao.impl.sales;


import org.pwr.transporter.entity.sales.GoodsIssuedNote;
import org.pwr.transporter.server.dao.impl.GenericDocumentDAOImpl;
import org.pwr.transporter.server.dao.sales.GoodsIssuedNoteDAO;



/**
 * <pre>
 *     Custom implementations for {@link GoodsIssuedNote}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class GoodsIssuedNoteDAOImpl extends GenericDocumentDAOImpl<GoodsIssuedNote> implements GoodsIssuedNoteDAO {

    public GoodsIssuedNoteDAOImpl() {
        setEntityClass(GoodsIssuedNote.class);
    }

}
