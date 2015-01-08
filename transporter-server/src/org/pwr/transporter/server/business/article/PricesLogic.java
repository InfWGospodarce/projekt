package org.pwr.transporter.server.business.article;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.article.Prices;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.dao.article.PricesDAO;



public class PricesLogic {

    PricesDAO pricesDAO;


    public void setPricesDAO(PricesDAO pricesDAO) {
        this.pricesDAO = pricesDAO;
    }


    public Prices getByID(Long id) {
        return this.pricesDAO.getByID(id);
    }


    public List<Prices> search(Map<String, Object> parameterMap) {
        return this.pricesDAO.search(parameterMap);
    }


    public Long insert(Prices entity) {
        return this.pricesDAO.insert(entity);
    }


    public void update(Prices entity) {
        this.pricesDAO.update(entity);
    }


    public void delete(Prices entity) {
        this.pricesDAO.delete(entity);
    }


    public void deleteById(Long id) {
        this.pricesDAO.deleteById(id);
    }


    public List<Prices> getListRest(int amount, int fromRow) {
        return this.pricesDAO.getListRest(amount, fromRow);
    }


    public long count() {
        return this.pricesDAO.count();
    }


    public long count(Criteria criteria) {
        return this.pricesDAO.count(criteria);
    }


    public List<Prices> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.pricesDAO.getListRestCrit(amount, fromRow, criteria);
    }

}
