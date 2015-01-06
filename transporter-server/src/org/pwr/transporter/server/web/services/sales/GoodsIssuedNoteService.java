package org.pwr.transporter.server.web.services.sales;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.sales.GoodsIssuedNote;
import org.pwr.transporter.server.business.sales.GoodsIssuedNoteLogic;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.web.services.IService;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * <pre>
 *  Service delegates for  {@link GoodsIssuedNote}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class GoodsIssuedNoteService implements IService {

    @Autowired
    GoodsIssuedNoteLogic goodsIssuedNoteLogic;


    public List<GoodsIssuedNote> getByCustomerId(Long id) {
        return this.goodsIssuedNoteLogic.getByCustomerId(id);
    }


    public GoodsIssuedNote getByID(Long id) {
        return this.goodsIssuedNoteLogic.getByID(id);
    }


    public List<GoodsIssuedNote> search(Map<String, Object> parameterMap) {
        return this.goodsIssuedNoteLogic.search(parameterMap);
    }


    public Long insert(GoodsIssuedNote entity) {
        return this.goodsIssuedNoteLogic.insert(entity);
    }


    public void update(GoodsIssuedNote entity) {
        this.goodsIssuedNoteLogic.update(entity);
    }


    public void delete(GoodsIssuedNote entity) {
        this.goodsIssuedNoteLogic.delete(entity);
    }


    public void deleteById(Long id) {
        this.goodsIssuedNoteLogic.deleteById(id);
    }


    @SuppressWarnings("unchecked")
    public List<GoodsIssuedNote> getListRest(int amount, int fromRow) {
        return this.goodsIssuedNoteLogic.getListRest(amount, fromRow);
    }


    public long count() {
        return this.goodsIssuedNoteLogic.count();
    }


    public long count(Criteria criteria) {
        return this.goodsIssuedNoteLogic.count(criteria);
    }


    @SuppressWarnings("unchecked")
    public List<GoodsIssuedNote> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.goodsIssuedNoteLogic.getListRestCrit(amount, fromRow, criteria);
    }

}
