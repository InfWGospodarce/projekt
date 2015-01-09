package org.pwr.transporter.entity.article;


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.pwr.transporter.entity.NamesForHibernate;
import org.pwr.transporter.entity.base.TaxItem;
import org.pwr.transporter.entity.base.Unit;
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
@PrimaryKeyJoinColumn(referencedColumnName = "id", name = NamesForHibernate.GENERIC_WARE_ID)
public class Article extends GenericWare {

    /**  */
    private static final long serialVersionUID = 5680839600729637175L;


    public Article() {
        super();
        mixedPrice = BigDecimal.ZERO;
        currentPrice = BigDecimal.ZERO;
    }


    // *******************************************************************************************************************************
    // ****** FIELDS
    // *******************************************************************************************************************************

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "mixed_price")
    private BigDecimal mixedPrice;

    @Column(name = "current_price")
    private BigDecimal currentPrice;

    @ManyToOne
    private Unit unit;

    @Transient
    private String unitId;

    @Column(name = "article_type")
    private ArticleType articleType;

    @Transient
    private String articleTypeValue;

    @ManyToOne
    private TaxItem taxItem;

    @Transient
    private String taxItemId;


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


    public BigDecimal getMixedPrice() {
        return this.mixedPrice;
    }


    public void setMixedPrice(BigDecimal mixedPrice) {
        this.mixedPrice = mixedPrice;
    }


    public TaxItem getTaxItem() {
        return this.taxItem;
    }


    public void setTaxItem(TaxItem taxItem) {
        this.taxItem = taxItem;
    }


    public BigDecimal getCurrentPrice() {
        return this.currentPrice;
    }


    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }


    public Unit getUnit() {
        return this.unit;
    }


    public void setUnit(Unit unit) {
        this.unit = unit;
    }


    public String getUnitId() {
        return this.unitId;
    }


    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }


    public String getArticleTypeValue() {
        return this.articleTypeValue;
    }


    public void setArticleTypeValue(String articleTypeValue) {
        this.articleTypeValue = articleTypeValue;
    }


    public String getTaxItemId() {
        return this.taxItemId;
    }


    public void setTaxItemId(String taxItemId) {
        this.taxItemId = taxItemId;
    }


    @Override
    public BigDecimal getDepth() {
        return super.getDepth();
    }


    @Override
    public BigDecimal getHeight() {
        return super.getHeight();
    }


    @Override
    public Long getId() {
        return super.getId();
    }


    @Override
    public String getSearchKey() {
        return super.getSearchKey();
    }


    @Override
    public BigDecimal getWeight() {
        return super.getWeight();
    }


    @Override
    public BigDecimal getWidth() {
        return super.getWidth();
    }


    @Override
    public void setActive(boolean active) {
        super.setActive(active);
    }


    @Override
    public void setDepth(BigDecimal depth) {
        super.setDepth(depth);
    }


    @Override
    public void setHeight(BigDecimal height) {
        super.setHeight(height);
    }


    @Override
    public void setId(Long id) {
        super.setId(id);
    }


    @Override
    public void setSearchKey(String searchKey) {
        super.setSearchKey(searchKey);
    }


    @Override
    public void setWeight(BigDecimal weight) {
        super.setWeight(weight);
    }


    @Override
    public void setWidth(BigDecimal width) {
        super.setWidth(width);
    }
}
