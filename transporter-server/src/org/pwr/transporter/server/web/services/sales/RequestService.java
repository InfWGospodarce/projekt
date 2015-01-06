package org.pwr.transporter.server.web.services.sales;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.sales.Request;
import org.pwr.transporter.server.business.sales.RequestLogic;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.web.services.IService;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * <pre>
 *  Service delegates for  {@link Request}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class RequestService implements IService {

    @Autowired
    RequestLogic requestLogic;


    public List<Request> getByCustomerId(Long id) {
        return this.requestLogic.getByCustomerId(id);
    }


    public Request getByID(Long id) {
        return this.requestLogic.getByID(id);
    }


    public List<Request> search(Map<String, Object> parameterMap) {
        return this.requestLogic.search(parameterMap);
    }


    public Long insert(Request entity) {
        return this.requestLogic.insert(entity);
    }


    public void update(Request entity) {
        this.requestLogic.update(entity);
    }


    public void delete(Request entity) {
        this.requestLogic.delete(entity);
    }


    public void deleteById(Long id) {
        this.requestLogic.deleteById(id);
    }


    @SuppressWarnings("unchecked")
    public List<Request> getListRest(int amount, int fromRow) {
        return this.requestLogic.getListRest(amount, fromRow);
    }


    public long count() {
        return this.requestLogic.count();
    }


    public long count(Criteria criteria) {
        return this.requestLogic.count(criteria);
    }


    @SuppressWarnings("unchecked")
    public List<Request> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.requestLogic.getListRestCrit(amount, fromRow, criteria);
    }

}