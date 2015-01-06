package org.pwr.transporter.server.web.services.article;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.article.Prices;
import org.pwr.transporter.server.business.article.PricesLogic;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.web.services.IService;
import org.springframework.beans.factory.annotation.Autowired;



public class PricesService implements IService {

    @Autowired
    PricesLogic pricesLogic;


    public Prices getByID(Long id) {
        return this.pricesLogic.getByID(id);
    }


    public List<Prices> search(Map<String, Object> parameterMap) {
        return this.pricesLogic.search(parameterMap);
    }


    public Long insert(Prices entity) {
        return this.pricesLogic.insert(entity);
    }


    public void update(Prices entity) {
        this.pricesLogic.update(entity);
    }


    public void delete(Prices entity) {
        this.pricesLogic.delete(entity);
    }


    public void deleteById(Long id) {
        this.pricesLogic.deleteById(id);
    }


    @SuppressWarnings("unchecked")
    public List<Prices> getListRest(int amount, int fromRow) {
        return this.pricesLogic.getListRest(amount, fromRow);
    }


    public long count() {
        return this.pricesLogic.count();
    }


    public long count(Criteria criteria) {
        return this.pricesLogic.count(criteria);
    }


    @SuppressWarnings("unchecked")
    public List<Prices> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.pricesLogic.getListRestCrit(amount, fromRow, criteria);
    }

}
