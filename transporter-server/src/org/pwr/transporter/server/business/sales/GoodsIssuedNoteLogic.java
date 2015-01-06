package org.pwr.transporter.server.business.sales;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.sales.GoodsIssuedNote;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.dao.sales.GoodsIssuedNoteDAO;



/**
 * <pre>
 *  Delegates logic for {@link GoodsIssuedNote}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class GoodsIssuedNoteLogic {

    GoodsIssuedNoteDAO goodsIssuedNoteDAO;


    public GoodsIssuedNoteDAO getGoodsIssuedNoteDAO() {
        return this.goodsIssuedNoteDAO;
    }


    public void setGoodsIssuedNoteDAO(GoodsIssuedNoteDAO goodsIssuedNoteDAO) {
        this.goodsIssuedNoteDAO = goodsIssuedNoteDAO;
    }


    public List<GoodsIssuedNote> getByCustomerId(Long id) {
        return this.goodsIssuedNoteDAO.getByCustomerId(id);
    }


    public GoodsIssuedNote getByID(Long id) {
        return this.goodsIssuedNoteDAO.getByID(id);
    }


    public List<GoodsIssuedNote> search(Map<String, Object> parameterMap) {
        return this.goodsIssuedNoteDAO.search(parameterMap);
    }


    public Long insert(GoodsIssuedNote entity) {
        return this.goodsIssuedNoteDAO.insert(entity);
    }


    public void update(GoodsIssuedNote entity) {
        this.goodsIssuedNoteDAO.update(entity);
    }


    public void delete(GoodsIssuedNote entity) {
        this.goodsIssuedNoteDAO.delete(entity);
    }


    public void deleteById(Long id) {
        this.goodsIssuedNoteDAO.deleteById(id);
    }


    public List<GoodsIssuedNote> getListRest(int amount, int fromRow) {
        return this.goodsIssuedNoteDAO.getListRest(amount, fromRow);
    }


    public long count() {
        return this.goodsIssuedNoteDAO.count();
    }


    public long count(Criteria criteria) {
        return this.goodsIssuedNoteDAO.count(criteria);
    }


    public List<GoodsIssuedNote> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.goodsIssuedNoteDAO.getListRestCrit(amount, fromRow, criteria);
    }

}
