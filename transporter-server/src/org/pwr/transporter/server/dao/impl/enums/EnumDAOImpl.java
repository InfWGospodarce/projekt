package org.pwr.transporter.server.dao.impl.enums;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.pwr.transporter.entity.enums.GenericEnum;
import org.pwr.transporter.server.dao.enums.EnumDAO;
import org.pwr.transporter.server.dao.impl.GenericDAOImpl;



/**
 * <pre>
 *    Generic DAO impl for all enums
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.2
 * @param <T>
 */
public class EnumDAOImpl<T extends GenericEnum> extends GenericDAOImpl<T> implements EnumDAO<T> {

    @SuppressWarnings("unchecked")
    public Long insert(T entity) {
        int value = 0;
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();

        String cname = clazz.getName();
        Query query = session.createQuery("from " + cname + " order by value");
        List<T> resultList = query.list();
        if( !resultList.isEmpty() ) {
            value = resultList.get(resultList.size() - 1).getValue() + 1;
        }

        entity.setValue(value);
        Long id = (Long) session.save(entity);
        tx.commit();
        return id;
    }
}
