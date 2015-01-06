package org.pwr.transporter.server.dao;


import java.util.List;

import org.pwr.transporter.entity.base.GenericDocument;



/**
 * <pre>
 *    Base interface for dao implementations.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.3
 * @param <T>
 * @param <ID>
 */
public interface GenericDocumentDAO<T extends GenericDocument> extends GenericDAO<T> {

    List<T> getByCustomerId(Long id);

}