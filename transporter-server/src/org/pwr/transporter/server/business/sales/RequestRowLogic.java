package org.pwr.transporter.server.business.sales;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.sales.RequestRow;
import org.pwr.transporter.entity.sales.SalesOrder;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.dao.sales.RequestRowDAO;



/**
 * <pre>
 *  Delegates logic for {@link RequestRow}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class RequestRowLogic {

    RequestRowDAO requestRowDAO;


    public RequestRowDAO getRequestRowDAO() {
        return this.requestRowDAO;
    }


    public void setRequestRowDAO(RequestRowDAO requestRowDAO) {
        this.requestRowDAO = requestRowDAO;
    }


    public RequestRow getByID(Long id) {
        return this.requestRowDAO.getByID(id);
    }


    public List<SalesOrder> getByDocumentId(Long id) {
        return this.requestRowDAO.getByDocumentId(id);
    }


    public List<RequestRow> search(Map<String, Object> parameterMap) {
        return this.requestRowDAO.search(parameterMap);
    }


    public Long insert(RequestRow entity) {
        return this.requestRowDAO.insert(entity);
    }


    public void update(RequestRow entity) {
        this.requestRowDAO.update(entity);
    }


    public void delete(RequestRow entity) {
        this.requestRowDAO.delete(entity);
    }


    public void deleteById(Long id) {
        this.requestRowDAO.deleteById(id);
    }


    public List<RequestRow> getListRest(int amount, int fromRow) {
        return this.requestRowDAO.getListRest(amount, fromRow);
    }


    public long count() {
        return this.requestRowDAO.count();
    }


    public long count(Criteria criteria) {
        return this.requestRowDAO.count(criteria);
    }


    public List<RequestRow> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.requestRowDAO.getListRestCrit(amount, fromRow, criteria);
    }

}
