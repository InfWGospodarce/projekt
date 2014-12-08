package org.pwr.transporter.server.dao.impl;


import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.pwr.transporter.entity.GenericEntity;
import org.pwr.transporter.server.dao.GenericDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTransactionManager;



/**
 * <pre>
 *    Implementation of base database generic actions.
 * </pre>
 * <hr/>
 * 
 * @author x0r, copied from examples
 * @version 0.0.8
 */
public abstract class GenericDAOImpl<T extends GenericEntity> implements GenericDAO<T> {

    protected Class<T> clazz;

    @Autowired
    protected HibernateTransactionManager transactionManager;


    public void setTransactionManager(HibernateTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }


    public GenericDAOImpl() {
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
        Session session = transactionManager.getSessionFactory().getCurrentSession();
        return session;
    }

}
