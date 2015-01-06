package org.pwr.transporter.server.business.article;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.article.Bundle;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.dao.article.BundleDAO;



public class BundleLogic {

    BundleDAO bundleDAO;


    public void setBundleDAO(BundleDAO bundleDAO) {
        this.bundleDAO = bundleDAO;
    }


    public Bundle getByID(Long id) {
        return this.bundleDAO.getByID(id);
    }


    public List<Bundle> search(Map<String, Object> parameterMap) {
        return this.bundleDAO.search(parameterMap);
    }


    public Long insert(Bundle entity) {
        return this.bundleDAO.insert(entity);
    }


    public void update(Bundle entity) {
        this.bundleDAO.update(entity);
    }


    public void delete(Bundle entity) {
        this.bundleDAO.delete(entity);
    }


    public void deleteById(Long id) {
        this.bundleDAO.deleteById(id);
    }


    public List<Bundle> getListRest(int amount, int fromRow) {
        return this.bundleDAO.getListRest(amount, fromRow);
    }


    public long count() {
        return this.bundleDAO.count();
    }


    public long count(Criteria criteria) {
        return this.bundleDAO.count(criteria);
    }


    public List<Bundle> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.bundleDAO.getListRestCrit(amount, fromRow, criteria);
    }

}
