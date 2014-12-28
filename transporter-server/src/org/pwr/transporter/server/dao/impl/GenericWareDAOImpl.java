package org.pwr.transporter.server.dao.impl;


import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.pwr.transporter.entity.article.GenericWare;
import org.pwr.transporter.server.dao.GenericWareDAO;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * <pre>
 *    Implementation of base database generic actions.
 * </pre>
 * <hr/>
 * 
 * @author W.S., copied from examples
 * @version 0.1.2
 */
public abstract class GenericWareDAOImpl<T extends GenericWare> implements GenericWareDAO<T> {

    protected Class<T> clazz;

    @Autowired
    protected SessionFactory sessionFactory;


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public GenericWareDAOImpl() {
    }


    public void setEntityClass(final Class<T> clazz) {
        this.clazz = clazz;
    }


    @SuppressWarnings("unchecked")
    public T getByID(Long id) {
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        T t = (T) getCurrentSession().get(clazz, id);
        // Hibernate.initialize(t);
        tx.commit();
        return t;
    }


    @SuppressWarnings("unchecked")
    public List<T> getList() {
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        String cname = clazz.getName();
        Query query = session.createQuery("from " + cname);
        List<T> resultList = query.list();
        // Hibernate.initialize();
        tx.commit();
        return resultList;
    }


    @SuppressWarnings("unchecked")
    public List<T> getListRest(int amount, int fromRow) {
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        String cname = clazz.getName();
        Query query = session.createQuery("from " + cname);
        query.setMaxResults(amount);
        query.setFirstResult(fromRow);
        List<T> resultList = query.list();
        // Hibernate.initialize();
        tx.commit();
        return resultList;
    }


    @SuppressWarnings("unchecked")
    public List<T> search(Map<String, Object> parameterMap) {
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        Criteria criteria = getCurrentSession().createCriteria(clazz);
        Set<String> fieldName = parameterMap.keySet();
        for( String field : fieldName ) {
            criteria.add(Restrictions.ilike(field, parameterMap.get(field)));
        }
        List<T> resultList = criteria.list();
        // Hibernate.initialize(resultList);
        tx.commit();
        return resultList;
    }


    public Long insert(T entity) {
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        Long id = (Long) session.save(entity);
        tx.commit();
        return id;
    }


    public void update(T entity) {
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        getCurrentSession().update(entity);
        tx.commit();
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
        Transaction tx = session.beginTransaction();
        Criteria criteria = session.createCriteria(clazz);
        Integer count = ( (Number) criteria.setProjection(Projections.rowCount()).uniqueResult() ).intValue();
        tx.commit();
        return count;
    }
}
