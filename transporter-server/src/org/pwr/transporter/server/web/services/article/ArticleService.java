package org.pwr.transporter.server.web.services.article;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.article.Article;
import org.pwr.transporter.entity.enums.article.ArticleType;
import org.pwr.transporter.server.business.TaxItemLogic;
import org.pwr.transporter.server.business.UnitLogic;
import org.pwr.transporter.server.business.article.ArticleLogic;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.web.services.IService;
import org.springframework.beans.factory.annotation.Autowired;


public class ArticleService implements IService {

	@Autowired
	ArticleLogic articleLogic;

	@Autowired
	UnitLogic unitLogic;

	@Autowired
	TaxItemLogic taxItemLogic;

	public Article getByID( Long id ) {
		return this.articleLogic.getByID(id);
	}

	public Long insert( Article entity ) {
		fixIds(entity);
		return this.articleLogic.insert(entity);
	}

	public void update( Article entity ) {
		fixIds(entity);
		this.articleLogic.update(entity);
	}

	private void fixIds( Article entity ) {
		entity.setArticleType(ArticleType.getByValue(Integer.valueOf(entity.getArticleTypeValue())));
		entity.setUnit(unitLogic.getByID(Long.valueOf(entity.getUnitId())));
		if ( entity.getTaxItemId() != null ) {
			entity.setTaxItem(taxItemLogic.getByID(Long.valueOf(entity.getTaxItemId())));
		}
	}

	public void delete( Article entity ) {
		this.articleLogic.delete(entity);
	}

	public void deleteById( Long id ) {
		this.articleLogic.deleteById(id);
	}

	@SuppressWarnings("unchecked")
	public List<Article> getListRest( int amount, int fromRow ) {
		return this.articleLogic.getListRest(amount, fromRow);
	}

	public long count() {
		return this.articleLogic.count();
	}

	public long count( Criteria criteria ) {
		return this.articleLogic.count(criteria);
	}

	@SuppressWarnings("unchecked")
	public List<Article> getListRestCrit( int amount, int fromRow, Criteria criteria ) {
		return this.articleLogic.getListRestCrit(amount, fromRow, criteria);
	}

	public List<Article> search( Map<String, Object> parameterMap ) {
		return this.articleLogic.search(parameterMap);
	}

}
