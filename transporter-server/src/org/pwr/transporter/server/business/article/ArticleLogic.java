package org.pwr.transporter.server.business.article;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.article.Article;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.dao.article.ArticleDAO;



public class ArticleLogic {

    ArticleDAO articleDAO;


    public void setArticleDAO(ArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
    }


    public Article getByID(Long id) {
        return this.articleDAO.getByID(id);
    }


    public List<Article> search(Map<String, Object> parameterMap) {
        return this.articleDAO.search(parameterMap);
    }


    public Long insert(Article entity) {
        return this.articleDAO.insert(entity);
    }


    public void update(Article entity) {
        this.articleDAO.update(entity);
    }


    public void delete(Article entity) {
        this.articleDAO.delete(entity);
    }


    public void deleteById(Long id) {
        this.articleDAO.deleteById(id);
    }


    public List<Article> getListRest(int amount, int fromRow) {
        return this.articleDAO.getListRest(amount, fromRow);
    }


    public long count() {
        return this.articleDAO.count();
    }


    public long count(Criteria criteria) {
        return this.articleDAO.count(criteria);
    }


    public List<Article> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.articleDAO.getListRestCrit(amount, fromRow, criteria);
    }

}
