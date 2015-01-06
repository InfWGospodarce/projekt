package org.pwr.transporter.server.business.purchase;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.purchase.GoodsReceivedNote;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.dao.purchase.GoodsReceivedNoteDAO;



/**
 * <pre>
 *  Delegates logic for {@link GoodsReceivedNote}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class GoodsReceivedNoteLogic {

    GoodsReceivedNoteDAO goodsReceivedNoteDAO;


    public void setGoodsReceivedNoteDAO(GoodsReceivedNoteDAO goodsReceivedNoteDAO) {
        this.goodsReceivedNoteDAO = goodsReceivedNoteDAO;
    }


    public GoodsReceivedNote getByID(Long id) {
        return this.goodsReceivedNoteDAO.getByID(id);
    }


    public List<GoodsReceivedNote> getByCustomerId(Long id) {
        return this.goodsReceivedNoteDAO.getByCustomerId(id);
    }


    public List<GoodsReceivedNote> search(Map<String, Object> parameterMap) {
        return this.goodsReceivedNoteDAO.search(parameterMap);
    }


    public Long insert(GoodsReceivedNote entity) {
        return this.goodsReceivedNoteDAO.insert(entity);
    }


    public void update(GoodsReceivedNote entity) {
        this.goodsReceivedNoteDAO.update(entity);
    }


    public void delete(GoodsReceivedNote entity) {
        this.goodsReceivedNoteDAO.delete(entity);
    }


    public void deleteById(Long id) {
        this.goodsReceivedNoteDAO.deleteById(id);
    }


    public List<GoodsReceivedNote> getListRest(int amount, int fromRow) {
        return this.goodsReceivedNoteDAO.getListRest(amount, fromRow);
    }


    public long count() {
        return this.goodsReceivedNoteDAO.count();
    }


    public long count(Criteria criteria) {
        return this.goodsReceivedNoteDAO.count(criteria);
    }


    public List<GoodsReceivedNote> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.goodsReceivedNoteDAO.getListRestCrit(amount, fromRow, criteria);
    }

}
