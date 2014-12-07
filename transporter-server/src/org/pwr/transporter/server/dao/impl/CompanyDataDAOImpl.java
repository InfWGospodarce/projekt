package org.pwr.transporter.server.dao.impl;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.pwr.transporter.entity.base.CompanyData;
import org.pwr.transporter.server.dao.CompanyDataDAO;



/**
 * <pre>
 *    Implementation for company data DAO
 * </pre>
 * <hr/>
 * 
 * @author x0r
 * @version 0.0.3
 */
public class CompanyDataDAOImpl extends GenericDAOImpl<CompanyData> implements CompanyDataDAO {

    public CompanyDataDAOImpl() {
        setEntityClass(CompanyData.class);
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


    @Override
    public CompanyData getFirst() {
        List<CompanyData> resultList = getList();
        if( !resultList.isEmpty() ) {
            return resultList.get(0);
        }
        return null;
    }


    @Override
    public void delete(CompanyData entity) {
    }


    @Override
    public void deleteById(Long id) {
    }
}
