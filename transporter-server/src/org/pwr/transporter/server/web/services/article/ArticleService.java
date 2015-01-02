package org.pwr.transporter.server.web.services.article;


import java.util.List;

import org.pwr.transporter.entity.article.Article;
import org.pwr.transporter.server.business.article.ArticleLogic;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.web.services.IService;
import org.springframework.beans.factory.annotation.Autowired;



public class ArticleService implements IService {

    @Autowired
    ArticleLogic articleLogic;


    public Article getByID(Long id) {
        return this.articleLogic.getByID(id);
    }


    public Long insert(Article entity) {
        return this.articleLogic.insert(entity);
    }


    public void update(Article entity) {
        this.articleLogic.update(entity);
    }


    public void delete(Article entity) {
        this.articleLogic.delete(entity);
    }


    public void deleteById(Long id) {
        this.articleLogic.deleteById(id);
    }


    @SuppressWarnings("unchecked")
    public List<Article> getListRest(int amount, int fromRow) {
        return this.articleLogic.getListRest(amount, fromRow);
    }


    public long count() {
        return this.articleLogic.count();
    }


    public long count(Criteria criteria) {
        return this.articleLogic.count(criteria);
    }


    @SuppressWarnings("unchecked")
    public List<Article> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.articleLogic.getListRestCrit(amount, fromRow, criteria);
    }

}
