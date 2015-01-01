package org.pwr.transporter.server.dao.impl.article;


import org.pwr.transporter.entity.article.Article;
import org.pwr.transporter.server.dao.article.ArticleDAO;
import org.pwr.transporter.server.dao.impl.GenericDAOImpl;



public class ArticleDAOImpl extends GenericDAOImpl<Article> implements ArticleDAO {

    public ArticleDAOImpl() {
        setEntityClass(Article.class);
    }

}
