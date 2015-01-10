package org.pwr.transporter.server.dao.impl;


import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.pwr.transporter.entity.Generic;
import org.pwr.transporter.server.core.hb.criteria.Between;
import org.pwr.transporter.server.dao.GenericDAO;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * <pre>
 *    Implementation of base database generic actions.
 * </pre>
 * <hr/>
 * 
 * @author W.S., copied from examples
 * @version 0.1.7
 */
public abstract class GenericDAOImpl<T extends Generic> implements GenericDAO<T> {

    private static Logger logger = Logger.getLogger(GenericDAOImpl.class);

    protected Class<T> clazz;

    @Autowired
    protected SessionFactory sessionFactory;


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public GenericDAOImpl() {
    }


    public void setEntityClass(final Class<T> clazz) {
        this.clazz = clazz;
    }


    @SuppressWarnings("unchecked")
    public T getByID(Long id) {
        getCurrentSession().getTransaction().begin();
        T t = (T) getCurrentSession().get(clazz, id);
        // Hibernate.initialize(t);
        getCurrentSession().getTransaction().commit();
        return t;
    }


    @Deprecated
    @SuppressWarnings("unchecked")
    public List<T> getList() {
        getCurrentSession().getTransaction().begin();
        String cname = clazz.getName();
        Query query = getCurrentSession().createQuery("from " + cname + " order by 1");
        List<T> resultList = query.list();
        // Hibernate.initialize();
        getCurrentSession().getTransaction().commit();
        return resultList;
    }


    @SuppressWarnings("unchecked")
    public List<T> getListRest(int amount, int fromRow) {
        Session session = getCurrentSession();
        session.getTransaction().begin();

        DetachedCriteria idsOnlyCriteria = DetachedCriteria.forClass(clazz);
        idsOnlyCriteria.setProjection(Projections.distinct(Projections.id()));

        Criteria criteria = session.createCriteria(clazz);
        criteria.add(Subqueries.propertyIn("id", idsOnlyCriteria));
        criteria.setMaxResults(amount);
        criteria.setFirstResult(fromRow);
        List<T> resultList = criteria.list();
        // Hibernate.initialize();
        getCurrentSession().getTransaction().commit();
        return resultList;
    }


    @SuppressWarnings("unchecked")
    public List<T> getListRestCrit(int amount, int fromRow, org.pwr.transporter.server.core.hb.criteria.Criteria parameterCriteria) {
        Session session = getCurrentSession();
        session.getTransaction().begin();

        DetachedCriteria idsOnlyCriteria = DetachedCriteria.forClass(clazz);
        idsOnlyCriteria.setProjection(Projections.distinct(Projections.id()));

        Criteria criteria = getCurrentSession().createCriteria(clazz);
        criteria.add(Subqueries.propertyIn("id", idsOnlyCriteria));
        loadCriteria(parameterCriteria, criteria);
        criteria.setMaxResults(amount);
        criteria.setFirstResult(fromRow);
        List<T> resultList = criteria.list();
        logger.debug("List objects: " + resultList.size());
        // Hibernate.initialize();
        getCurrentSession().getTransaction().commit();
        return resultList;
    }


    @Override
    public long count(org.pwr.transporter.server.core.hb.criteria.Criteria parameterCriteria) {
        Session session = getCurrentSession();
        session.getTransaction().begin();
        Criteria criteria = session.createCriteria(clazz);
        loadCriteria(parameterCriteria, criteria, false);
        Integer count = ( (Number) criteria.setProjection(Projections.rowCount()).uniqueResult() ).intValue();
        session.getTransaction().commit();
        logger.debug("Count: " + count);
        return count;
    }


    private void loadCriteria(org.pwr.transporter.server.core.hb.criteria.Criteria parameterCriteria, Criteria criteria) {
        loadCriteria(parameterCriteria, criteria, true);
    }


    private void loadCriteria(org.pwr.transporter.server.core.hb.criteria.Criteria parameterCriteria, Criteria criteria, boolean sort) {
        Iterator<Entry<String, Object>> iterator = parameterCriteria.getLikeCriteria().entrySet().iterator();
        while( iterator.hasNext() ) {
            Entry<String, Object> entry = iterator.next();
            if( entry.getKey().contains(".id.") ) {
                String fieldName = entry.getKey().substring(0, entry.getKey().indexOf(".id."));
                String field = entry.getKey().substring(entry.getKey().indexOf(".id.") + 4, entry.getKey().length());
                criteria.createAlias(fieldName, fieldName + "field");
                criteria.add(Restrictions.like(fieldName + "field" + "." + field, (String) entry.getValue(), MatchMode.ANYWHERE));
            } else {
                criteria.add(Restrictions.like(entry.getKey(), (String) entry.getValue(), MatchMode.ANYWHERE));
            }
        }

        iterator = parameterCriteria.getEqualCriteria().entrySet().iterator();
        while( iterator.hasNext() ) {
            Entry<String, Object> entry = iterator.next();
            if( entry.getKey().contains(".id.") ) {
                String fieldName = entry.getKey().substring(0, entry.getKey().indexOf(".id."));
                String field = entry.getKey().substring(entry.getKey().indexOf(".id.") + 4, entry.getKey().length());
                criteria.createAlias(fieldName, fieldName).add(Restrictions.eq(fieldName + "." + field, entry.getValue()));
            } else {
                criteria.add(Restrictions.eq(entry.getKey(), entry.getValue()));
            }
        }

        iterator = parameterCriteria.getIdsCriteria().entrySet().iterator();
        while( iterator.hasNext() ) {
            Entry<String, Object> entry = iterator.next();
            if( entry.getKey().contains(".id.") ) {
                String fieldName = entry.getKey().substring(0, entry.getKey().indexOf(".id."));
                String field = entry.getKey().substring(entry.getKey().indexOf(".id.") + 4, entry.getKey().length());
                criteria.createAlias(fieldName, fieldName).add(Restrictions.eq(fieldName + "." + field, entry.getValue()));
            } else {
                criteria.add(Restrictions.eq(entry.getKey(), entry.getValue()));
            }
        }

        if( sort ) {
            Iterator<Entry<String, Object>> iteratorC = parameterCriteria.getSortCriteria().entrySet().iterator();
            while( iteratorC.hasNext() ) {
                Entry<String, Object> entry = iteratorC.next();

                if( entry.getKey().contains(".id.") ) {
                    String fieldName = entry.getKey().substring(0, entry.getKey().indexOf(".id."));
                    String field = entry.getKey().substring(entry.getKey().indexOf(".id.") + 4, entry.getKey().length());
                    if( entry.getValue().equals(org.pwr.transporter.server.core.hb.criteria.Criteria.SortOptions.ASC) ) {
                        logger.debug("Set order by: " + entry.getKey());
                        criteria.createAlias(fieldName, fieldName + "field").addOrder(Order.asc(fieldName + "field" + "." + field));
                    } else {
                        criteria.createAlias(fieldName, fieldName + "field").addOrder(Order.desc(fieldName + "field" + "." + field));
                    }
                } else {
                    if( entry.getValue().equals(org.pwr.transporter.server.core.hb.criteria.Criteria.SortOptions.ASC) ) {
                        logger.debug("Set order by: " + entry.getKey());
                        criteria.addOrder(Order.asc(entry.getKey()));
                    } else {
                        criteria.addOrder(Order.desc(entry.getKey()));
                    }
                }

            }
        }

        Iterator<Entry<String, Between>> iteratorB = parameterCriteria.getBetweenCriteria().entrySet().iterator();
        while( iteratorB.hasNext() ) {
            Entry<String, Between> entry = iteratorB.next();
            criteria.add(Restrictions.between(entry.getKey(), entry.getValue().getFirst(), entry.getValue().getSecond()));
        }

        if( parameterCriteria.getOrderBy() != null ) {

        }

    }


    @SuppressWarnings("unchecked")
    public List<T> search(Map<String, Object> parameterMap) {
        getCurrentSession().getTransaction().begin();
        Criteria criteria = getCurrentSession().createCriteria(clazz);
        Set<String> fieldName = parameterMap.keySet();
        for( String field : fieldName ) {
            Object value = parameterMap.get(field);
            if( value instanceof Boolean ) {
                criteria.add(Restrictions.eq(field, value));
            } else if( value instanceof Long ) {
                criteria.add(Restrictions.eq(field, value));
            } else if( value instanceof Enum ) {
                criteria.add(Restrictions.eq(field, value));
            } else {
                criteria.add(Restrictions.ilike(field, value));
            }
        }
        List<T> resultList = criteria.list();
        // Hibernate.initialize(resultList);
        getCurrentSession().getTransaction().commit();
        return resultList;
    }


    public Long insert(T entity) {
        getCurrentSession().getTransaction().begin();
        Long id = (Long) getCurrentSession().save(entity);
        getCurrentSession().getTransaction().commit();
        return id;
    }


    public void update(T entity) {
        getCurrentSession().getTransaction().begin();
        getCurrentSession().update(entity);
        getCurrentSession().getTransaction().commit();
    }


    /**
     * Do not delete anything.
     */
    public void delete(T entity) {
        entity.setActive(false);
        getCurrentSession().update(entity);
    }


    public void deleteById(Long id) {
        delete(getByID(id));
    }


    protected DetachedCriteria createDetachedCriteria() {
        return DetachedCriteria.forClass(clazz);
    }


    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public long count() {
        Session session = getCurrentSession();
        session.getTransaction().begin();
        Criteria criteria = session.createCriteria(clazz);
        Integer count = ( (Number) criteria.setProjection(Projections.rowCount()).uniqueResult() ).intValue();
        session.getTransaction().commit();
        logger.debug("Count: " + count);
        return count;
    }
}
