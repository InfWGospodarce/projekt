package org.pwr.transporter.entity.article;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.pwr.transporter.entity.NamesForHibernate;
import org.pwr.transporter.entity.enums.article.ArticleType;



/**
 * <pre>
 *    Define article for sales.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.4
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "article")
@PrimaryKeyJoinColumn(name = NamesForHibernate.GENERIC_WARE_ID)
public class Article extends GenericWare {

    /**  */
    private static final long serialVersionUID = 5680839600729637175L;

    // *******************************************************************************************************************************
    // ****** FIELDS
    // *******************************************************************************************************************************

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    private ArticleType articleType;


    // *******************************************************************************************************************************
    // ****** SETTERS AND GETTERS
    // *******************************************************************************************************************************

    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public ArticleType getArticleType() {
        return this.articleType;
    }


    public void setArticleType(ArticleType articleType) {
        this.articleType = articleType;
    }
}
