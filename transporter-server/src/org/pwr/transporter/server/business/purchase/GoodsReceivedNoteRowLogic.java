package org.pwr.transporter.server.business.purchase;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.purchase.GoodsReceivedNoteRow;
import org.pwr.transporter.entity.sales.SalesOrder;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.dao.purchase.GoodsReceivedNoteRowDAO;



/**
 * <pre>
 *  Delegates logic for {@link GoodsReceivedNoteRow}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class GoodsReceivedNoteRowLogic {

    GoodsReceivedNoteRowDAO goodsReceivedNoteRowDAO;


    public void setGoodsReceivedNoteRowDAO(GoodsReceivedNoteRowDAO goodsReceivedNoteRowDAO) {
        this.goodsReceivedNoteRowDAO = goodsReceivedNoteRowDAO;
    }


    public GoodsReceivedNoteRow getByID(Long id) {
        return this.goodsReceivedNoteRowDAO.getByID(id);
    }


    public List<SalesOrder> getByDocumentId(Long id) {
        return this.goodsReceivedNoteRowDAO.getByDocumentId(id);
    }


    public List<GoodsReceivedNoteRow> search(Map<String, Object> parameterMap) {
        return this.goodsReceivedNoteRowDAO.search(parameterMap);
    }


    public Long insert(GoodsReceivedNoteRow entity) {
        return this.goodsReceivedNoteRowDAO.insert(entity);
    }


    public void update(GoodsReceivedNoteRow entity) {
        this.goodsReceivedNoteRowDAO.update(entity);
    }


    public void delete(GoodsReceivedNoteRow entity) {
        this.goodsReceivedNoteRowDAO.delete(entity);
    }


    public void deleteById(Long id) {
        this.goodsReceivedNoteRowDAO.deleteById(id);
    }


    public List<GoodsReceivedNoteRow> getListRest(int amount, int fromRow) {
        return this.goodsReceivedNoteRowDAO.getListRest(amount, fromRow);
    }


    public long count() {
        return this.goodsReceivedNoteRowDAO.count();
    }


    public long count(Criteria criteria) {
        return this.goodsReceivedNoteRowDAO.count(criteria);
    }


    public List<GoodsReceivedNoteRow> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.goodsReceivedNoteRowDAO.getListRestCrit(amount, fromRow, criteria);
    }

}
