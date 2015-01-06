package org.pwr.transporter.server.web.services.article;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.article.Packaging;
import org.pwr.transporter.server.business.article.PackagingLogic;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.web.services.IService;
import org.springframework.beans.factory.annotation.Autowired;



public class PackagingService implements IService {

    @Autowired
    PackagingLogic packagingLogic;


    public Packaging getByID(Long id) {
        return this.packagingLogic.getByID(id);
    }


    public Long insert(Packaging entity) {
        return this.packagingLogic.insert(entity);
    }


    public void update(Packaging entity) {
        this.packagingLogic.update(entity);
    }


    public void delete(Packaging entity) {
        this.packagingLogic.delete(entity);
    }


    public void deleteById(Long id) {
        this.packagingLogic.deleteById(id);
    }


    @SuppressWarnings("unchecked")
    public List<Packaging> getListRest(int amount, int fromRow) {
        return this.packagingLogic.getListRest(amount, fromRow);
    }


    public long count() {
        return this.packagingLogic.count();
    }


    public long count(Criteria criteria) {
        return this.packagingLogic.count(criteria);
    }


    @SuppressWarnings("unchecked")
    public List<Packaging> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.packagingLogic.getListRestCrit(amount, fromRow, criteria);
    }


    public List<Packaging> search(Map<String, Object> parameterMap) {
        return this.packagingLogic.search(parameterMap);
    }

}
