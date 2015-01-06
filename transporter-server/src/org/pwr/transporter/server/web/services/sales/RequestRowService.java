package org.pwr.transporter.server.web.services.sales;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.sales.RequestRow;
import org.pwr.transporter.entity.sales.SalesOrder;
import org.pwr.transporter.server.business.sales.RequestRowLogic;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.web.services.IService;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * <pre>
 *  Service delegates for  {@link RequestRow}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class RequestRowService implements IService {

    @Autowired
    RequestRowLogic requestRowLogic;


    public RequestRow getByID(Long id) {
        return this.requestRowLogic.getByID(id);
    }


    public List<SalesOrder> getByDocumentId(Long id) {
        return this.requestRowLogic.getByDocumentId(id);
    }


    public List<RequestRow> search(Map<String, Object> parameterMap) {
        return this.requestRowLogic.search(parameterMap);
    }


    public Long insert(RequestRow entity) {
        return this.requestRowLogic.insert(entity);
    }


    public void update(RequestRow entity) {
        this.requestRowLogic.update(entity);
    }


    public void delete(RequestRow entity) {
        this.requestRowLogic.delete(entity);
    }


    public void deleteById(Long id) {
        this.requestRowLogic.deleteById(id);
    }


    @SuppressWarnings("unchecked")
    public List<RequestRow> getListRest(int amount, int fromRow) {
        return this.requestRowLogic.getListRest(amount, fromRow);
    }


    public long count() {
        return this.requestRowLogic.count();
    }


    public long count(Criteria criteria) {
        return this.requestRowLogic.count(criteria);
    }


    @SuppressWarnings("unchecked")
    public List<RequestRow> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.requestRowLogic.getListRestCrit(amount, fromRow, criteria);
    }

}
