package org.pwr.transporter.server.dao.impl;


import java.util.List;

import org.pwr.transporter.entity.base.GenericDocumentRow;
import org.pwr.transporter.entity.sales.SalesOrder;
import org.pwr.transporter.server.dao.GenericDocumentRowDAO;



/**
 * <pre>
 *     Implements base operations for document row
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 * @param <T>
 */
public class GenericDocumentRowDAOImpl<T extends GenericDocumentRow> extends GenericDAOImpl<T> implements GenericDocumentRowDAO<T> {

    @Override
    public List<SalesOrder> getByDocumentId(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

}
