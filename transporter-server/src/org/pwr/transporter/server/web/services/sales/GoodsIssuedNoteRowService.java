package org.pwr.transporter.server.web.services.sales;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.sales.GoodsIssuedNoteRow;
import org.pwr.transporter.entity.sales.SalesOrder;
import org.pwr.transporter.server.business.sales.GoodsIssuedNoteRowLogic;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.web.services.IService;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * <pre>
 *  Service delegates for  {@link GoodsIssuedNoteRow}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class GoodsIssuedNoteRowService implements IService {

    @Autowired
    GoodsIssuedNoteRowLogic goodsIssuedNoteRowLogic;


    public GoodsIssuedNoteRow getByID(Long id) {
        return this.goodsIssuedNoteRowLogic.getByID(id);
    }


    public List<SalesOrder> getByDocumentId(Long id) {
        return this.goodsIssuedNoteRowLogic.getByDocumentId(id);
    }


    public List<GoodsIssuedNoteRow> search(Map<String, Object> parameterMap) {
        return this.goodsIssuedNoteRowLogic.search(parameterMap);
    }


    public Long insert(GoodsIssuedNoteRow entity) {
        return this.goodsIssuedNoteRowLogic.insert(entity);
    }


    public void update(GoodsIssuedNoteRow entity) {
        this.goodsIssuedNoteRowLogic.update(entity);
    }


    public void delete(GoodsIssuedNoteRow entity) {
        this.goodsIssuedNoteRowLogic.delete(entity);
    }


    public void deleteById(Long id) {
        this.goodsIssuedNoteRowLogic.deleteById(id);
    }


    @SuppressWarnings("unchecked")
    public List<GoodsIssuedNoteRow> getListRest(int amount, int fromRow) {
        return this.goodsIssuedNoteRowLogic.getListRest(amount, fromRow);
    }


    public long count() {
        return this.goodsIssuedNoteRowLogic.count();
    }


    public long count(Criteria criteria) {
        return this.goodsIssuedNoteRowLogic.count(criteria);
    }


    @SuppressWarnings("unchecked")
    public List<GoodsIssuedNoteRow> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.goodsIssuedNoteRowLogic.getListRestCrit(amount, fromRow, criteria);
    }

}
