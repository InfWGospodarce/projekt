package org.pwr.transporter.server.business.article;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.article.Packaging;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.dao.article.PackagingDAO;



public class PackagingLogic {

    PackagingDAO packagingDAO;


    public void setPackagingDAO(PackagingDAO packagingDAO) {
        this.packagingDAO = packagingDAO;
    }


    public Packaging getByID(Long id) {
        return this.packagingDAO.getByID(id);
    }


    public List<Packaging> search(Map<String, Object> parameterMap) {
        return this.packagingDAO.search(parameterMap);
    }


    public Long insert(Packaging entity) {
        return this.packagingDAO.insert(entity);
    }


    public void update(Packaging entity) {
        this.packagingDAO.update(entity);
    }


    public void delete(Packaging entity) {
        this.packagingDAO.delete(entity);
    }


    public void deleteById(Long id) {
        this.packagingDAO.deleteById(id);
    }


    public List<Packaging> getListRest(int amount, int fromRow) {
        return this.packagingDAO.getListRest(amount, fromRow);
    }


    public long count() {
        return this.packagingDAO.count();
    }


    public long count(Criteria criteria) {
        return this.packagingDAO.count(criteria);
    }


    public List<Packaging> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.packagingDAO.getListRestCrit(amount, fromRow, criteria);
    }

}
