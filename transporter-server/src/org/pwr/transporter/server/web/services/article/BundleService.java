package org.pwr.transporter.server.web.services.article;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.article.Bundle;
import org.pwr.transporter.server.business.article.BundleLogic;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.web.services.IService;
import org.springframework.beans.factory.annotation.Autowired;



public class BundleService implements IService {

    @Autowired
    BundleLogic bundleLogic;


    public Bundle getByID(Long id) {
        return this.bundleLogic.getByID(id);
    }


    public Long insert(Bundle entity) {
        return this.bundleLogic.insert(entity);
    }


    public void update(Bundle entity) {
        this.bundleLogic.update(entity);
    }


    public void delete(Bundle entity) {
        this.bundleLogic.delete(entity);
    }


    public void deleteById(Long id) {
        this.bundleLogic.deleteById(id);
    }


    @SuppressWarnings("unchecked")
    public List<Bundle> getListRest(int amount, int fromRow) {
        return this.bundleLogic.getListRest(amount, fromRow);
    }


    public long count() {
        return this.bundleLogic.count();
    }


    public long count(Criteria criteria) {
        return this.bundleLogic.count(criteria);
    }


    @SuppressWarnings("unchecked")
    public List<Bundle> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.bundleLogic.getListRestCrit(amount, fromRow, criteria);
    }


    public List<Bundle> search(Map<String, Object> parameterMap) {
        return this.bundleLogic.search(parameterMap);
    }

}
