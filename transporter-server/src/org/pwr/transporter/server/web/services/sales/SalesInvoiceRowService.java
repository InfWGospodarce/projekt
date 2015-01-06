package org.pwr.transporter.server.web.services.sales;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.sales.SalesInvoiceRow;
import org.pwr.transporter.entity.sales.SalesOrder;
import org.pwr.transporter.server.business.sales.SalesInvoiceRowLogic;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.web.services.IService;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * <pre>
 *  Service delegates for  {@link SalesInvoiceRow}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class SalesInvoiceRowService implements IService {

    @Autowired
    SalesInvoiceRowLogic salesInvoiceRowLogic;


    public SalesInvoiceRow getByID(Long id) {
        return this.salesInvoiceRowLogic.getByID(id);
    }


    public List<SalesOrder> getByDocumentId(Long id) {
        return this.salesInvoiceRowLogic.getByDocumentId(id);
    }


    public List<SalesInvoiceRow> search(Map<String, Object> parameterMap) {
        return this.salesInvoiceRowLogic.search(parameterMap);
    }


    public Long insert(SalesInvoiceRow entity) {
        return this.salesInvoiceRowLogic.insert(entity);
    }


    public void update(SalesInvoiceRow entity) {
        this.salesInvoiceRowLogic.update(entity);
    }


    public void delete(SalesInvoiceRow entity) {
        this.salesInvoiceRowLogic.delete(entity);
    }


    public void deleteById(Long id) {
        this.salesInvoiceRowLogic.deleteById(id);
    }


    @SuppressWarnings("unchecked")
    public List<SalesInvoiceRow> getListRest(int amount, int fromRow) {
        return this.salesInvoiceRowLogic.getListRest(amount, fromRow);
    }


    public long count() {
        return this.salesInvoiceRowLogic.count();
    }


    public long count(Criteria criteria) {
        return this.salesInvoiceRowLogic.count(criteria);
    }


    @SuppressWarnings("unchecked")
    public List<SalesInvoiceRow> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.salesInvoiceRowLogic.getListRestCrit(amount, fromRow, criteria);
    }

}
