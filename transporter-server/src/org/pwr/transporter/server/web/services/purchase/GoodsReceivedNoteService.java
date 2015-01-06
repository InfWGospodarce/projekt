package org.pwr.transporter.server.web.services.purchase;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.purchase.GoodsReceivedNote;
import org.pwr.transporter.server.business.purchase.GoodsReceivedNoteLogic;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.web.services.IService;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * <pre>
 *  Service delegates for {@link GoodsReceivedNote}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class GoodsReceivedNoteService implements IService {

    @Autowired
    GoodsReceivedNoteLogic goodsReceivedNoteLogic;


    public List<GoodsReceivedNote> getByCustomerId(Long id) {
        return this.goodsReceivedNoteLogic.getByCustomerId(id);
    }


    public List<GoodsReceivedNote> search(Map<String, Object> parameterMap) {
        return this.goodsReceivedNoteLogic.search(parameterMap);
    }


    public Long insert(GoodsReceivedNote entity) {
        return this.goodsReceivedNoteLogic.insert(entity);
    }


    public void update(GoodsReceivedNote entity) {
        this.goodsReceivedNoteLogic.update(entity);
    }


    public void delete(GoodsReceivedNote entity) {
        this.goodsReceivedNoteLogic.delete(entity);
    }


    public void deleteById(Long id) {
        this.goodsReceivedNoteLogic.deleteById(id);
    }


    @SuppressWarnings("unchecked")
    public List<GoodsReceivedNote> getListRest(int amount, int fromRow) {
        return this.goodsReceivedNoteLogic.getListRest(amount, fromRow);
    }


    public long count() {
        return this.goodsReceivedNoteLogic.count();
    }


    public long count(Criteria criteria) {
        return this.goodsReceivedNoteLogic.count(criteria);
    }


    @SuppressWarnings("unchecked")
    public List<GoodsReceivedNote> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.goodsReceivedNoteLogic.getListRestCrit(amount, fromRow, criteria);
    }

}
