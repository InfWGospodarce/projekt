package org.pwr.transporter.server.dao.impl;


import java.util.List;

import org.pwr.transporter.entity.base.GenericDocument;
import org.pwr.transporter.server.dao.GenericDocumentDAO;



/**
 * <pre>
 *    Implements base operations for document
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 * @param <T>
 */
public class GenericDocumentDAOImpl<T extends GenericDocument> extends GenericDAOImpl<T> implements GenericDocumentDAO<T> {

    @Override
    public List<T> getByCustomerId(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

}
