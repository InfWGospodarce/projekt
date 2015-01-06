package org.pwr.transporter.server.web.services.sales;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.sales.SalesOrder;
import org.pwr.transporter.entity.sales.SalesOrderRow;
import org.pwr.transporter.server.business.sales.SalesOrderRowLogic;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.web.services.IService;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * <pre>
 *  Service delegates for  {@link SalesOrderRow}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class SalesOrderRowService implements IService {

    @Autowired
    SalesOrderRowLogic salesOrderRowLogic;


    public SalesOrderRow getByID(Long id) {
        return this.salesOrderRowLogic.getByID(id);
    }


    public List<SalesOrder> getByDocumentId(Long id) {
        return this.salesOrderRowLogic.getByDocumentId(id);
    }


    public List<SalesOrderRow> search(Map<String, Object> parameterMap) {
        return this.salesOrderRowLogic.search(parameterMap);
    }


    public Long insert(SalesOrderRow entity) {
        return this.salesOrderRowLogic.insert(entity);
    }


    public void update(SalesOrderRow entity) {
        this.salesOrderRowLogic.update(entity);
    }


    public void delete(SalesOrderRow entity) {
        this.salesOrderRowLogic.delete(entity);
    }


    public void deleteById(Long id) {
        this.salesOrderRowLogic.deleteById(id);
    }


    @SuppressWarnings("unchecked")
    public List<SalesOrderRow> getListRest(int amount, int fromRow) {
        return this.salesOrderRowLogic.getListRest(amount, fromRow);
    }


    public long count() {
        return this.salesOrderRowLogic.count();
    }


    public long count(Criteria criteria) {
        return this.salesOrderRowLogic.count(criteria);
    }


    @SuppressWarnings("unchecked")
    public List<SalesOrderRow> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.salesOrderRowLogic.getListRestCrit(amount, fromRow, criteria);
    }

}
