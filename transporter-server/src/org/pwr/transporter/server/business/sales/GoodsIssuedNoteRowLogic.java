package org.pwr.transporter.server.business.sales;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.sales.GoodsIssuedNoteRow;
import org.pwr.transporter.entity.sales.SalesOrder;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.dao.sales.GoodsIssuedNoteRowDAO;



/**
 * <pre>
 *  Delegates logic for {@link GoodsIssuedNoteRow}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class GoodsIssuedNoteRowLogic {

    GoodsIssuedNoteRowDAO goodsIssuedNoteRowDAO;


    public GoodsIssuedNoteRowDAO getGoodsIssuedNoteRowDAO() {
        return this.goodsIssuedNoteRowDAO;
    }


    public void setGoodsIssuedNoteRowDAO(GoodsIssuedNoteRowDAO goodsIssuedNoteRowDAO) {
        this.goodsIssuedNoteRowDAO = goodsIssuedNoteRowDAO;
    }


    public GoodsIssuedNoteRow getByID(Long id) {
        return this.goodsIssuedNoteRowDAO.getByID(id);
    }


    public List<SalesOrder> getByDocumentId(Long id) {
        return this.goodsIssuedNoteRowDAO.getByDocumentId(id);
    }


    public List<GoodsIssuedNoteRow> search(Map<String, Object> parameterMap) {
        return this.goodsIssuedNoteRowDAO.search(parameterMap);
    }


    public Long insert(GoodsIssuedNoteRow entity) {
        return this.goodsIssuedNoteRowDAO.insert(entity);
    }


    public void update(GoodsIssuedNoteRow entity) {
        this.goodsIssuedNoteRowDAO.update(entity);
    }


    public void delete(GoodsIssuedNoteRow entity) {
        this.goodsIssuedNoteRowDAO.delete(entity);
    }


    public void deleteById(Long id) {
        this.goodsIssuedNoteRowDAO.deleteById(id);
    }


    public List<GoodsIssuedNoteRow> getListRest(int amount, int fromRow) {
        return this.goodsIssuedNoteRowDAO.getListRest(amount, fromRow);
    }


    public long count() {
        return this.goodsIssuedNoteRowDAO.count();
    }


    public long count(Criteria criteria) {
        return this.goodsIssuedNoteRowDAO.count(criteria);
    }


    public List<GoodsIssuedNoteRow> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.goodsIssuedNoteRowDAO.getListRestCrit(amount, fromRow, criteria);
    }

}
