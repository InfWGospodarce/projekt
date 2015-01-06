package org.pwr.transporter.server.web.services.sales;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.sales.SalesInvoice;
import org.pwr.transporter.server.business.sales.SalesInvoiceLogic;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.web.services.IService;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * <pre>
 *  Service delegates for  {@link SalesInvoice}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class SalesInvoiceService implements IService {

    @Autowired
    SalesInvoiceLogic salesInvoiceLogic;


    public List<SalesInvoice> getByCustomerId(Long id) {
        return this.salesInvoiceLogic.getByCustomerId(id);
    }


    public SalesInvoice getByID(Long id) {
        return this.salesInvoiceLogic.getByID(id);
    }


    public List<SalesInvoice> search(Map<String, Object> parameterMap) {
        return this.salesInvoiceLogic.search(parameterMap);
    }


    public Long insert(SalesInvoice entity) {
        return this.salesInvoiceLogic.insert(entity);
    }


    public void update(SalesInvoice entity) {
        this.salesInvoiceLogic.update(entity);
    }


    public void delete(SalesInvoice entity) {
        this.salesInvoiceLogic.delete(entity);
    }


    public void deleteById(Long id) {
        this.salesInvoiceLogic.deleteById(id);
    }


    @SuppressWarnings("unchecked")
    public List<SalesInvoice> getListRest(int amount, int fromRow) {
        return this.salesInvoiceLogic.getListRest(amount, fromRow);
    }


    public long count() {
        return this.salesInvoiceLogic.count();
    }


    public long count(Criteria criteria) {
        return this.salesInvoiceLogic.count(criteria);
    }


    @SuppressWarnings("unchecked")
    public List<SalesInvoice> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.salesInvoiceLogic.getListRestCrit(amount, fromRow, criteria);
    }

}
