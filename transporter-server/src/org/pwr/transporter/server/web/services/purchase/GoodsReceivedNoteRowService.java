package org.pwr.transporter.server.web.services.purchase;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.purchase.GoodsReceivedNoteRow;
import org.pwr.transporter.entity.sales.SalesOrder;
import org.pwr.transporter.server.business.purchase.GoodsReceivedNoteRowLogic;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.web.services.IService;



/**
 * <pre>
 *  Service delegates for  {@link GoodsReceivedNoteRow}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class GoodsReceivedNoteRowService implements IService {

    GoodsReceivedNoteRowLogic goodsReceivedNoteRowLogic;


    public GoodsReceivedNoteRow getByID(Long id) {
        return this.goodsReceivedNoteRowLogic.getByID(id);
    }


    public List<SalesOrder> getByDocumentId(Long id) {
        return this.goodsReceivedNoteRowLogic.getByDocumentId(id);
    }


    public List<GoodsReceivedNoteRow> search(Map<String, Object> parameterMap) {
        return this.goodsReceivedNoteRowLogic.search(parameterMap);
    }


    public Long insert(GoodsReceivedNoteRow entity) {
        return this.goodsReceivedNoteRowLogic.insert(entity);
    }


    public void update(GoodsReceivedNoteRow entity) {
        this.goodsReceivedNoteRowLogic.update(entity);
    }


    public void delete(GoodsReceivedNoteRow entity) {
        this.goodsReceivedNoteRowLogic.delete(entity);
    }


    public void deleteById(Long id) {
        this.goodsReceivedNoteRowLogic.deleteById(id);
    }


    @SuppressWarnings("unchecked")
    public List<GoodsReceivedNoteRow> getListRest(int amount, int fromRow) {
        return this.goodsReceivedNoteRowLogic.getListRest(amount, fromRow);
    }


    public long count() {
        return this.goodsReceivedNoteRowLogic.count();
    }


    public long count(Criteria criteria) {
        return this.goodsReceivedNoteRowLogic.count(criteria);
    }


    @SuppressWarnings("unchecked")
    public List<GoodsReceivedNoteRow> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.goodsReceivedNoteRowLogic.getListRestCrit(amount, fromRow, criteria);
    }

}
