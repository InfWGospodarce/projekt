package org.pwr.transporter.server.business.sales;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.sales.Request;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.dao.sales.RequestDAO;



/**
 * <pre>
 *  Delegates logic for {@link Request}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class RequestLogic {

    RequestDAO requestDAO;


    public RequestDAO getRequestDAO() {
        return this.requestDAO;
    }


    public void setRequestDAO(RequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }


    public List<Request> getByCustomerId(Long id) {
        return this.requestDAO.getByCustomerId(id);
    }


    public Request getByID(Long id) {
        return this.requestDAO.getByID(id);
    }


    public List<Request> search(Map<String, Object> parameterMap) {
        return this.requestDAO.search(parameterMap);
    }


    public Long insert(Request entity) {
        return this.requestDAO.insert(entity);
    }


    public void update(Request entity) {
        this.requestDAO.update(entity);
    }


    public void delete(Request entity) {
        this.requestDAO.delete(entity);
    }


    public void deleteById(Long id) {
        this.requestDAO.deleteById(id);
    }


    public List<Request> getListRest(int amount, int fromRow) {
        return this.requestDAO.getListRest(amount, fromRow);
    }


    public long count() {
        return this.requestDAO.count();
    }


    public long count(Criteria criteria) {
        return this.requestDAO.count(criteria);
    }


    public List<Request> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.requestDAO.getListRestCrit(amount, fromRow, criteria);
    }

}
