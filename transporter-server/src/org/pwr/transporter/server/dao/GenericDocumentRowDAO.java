package org.pwr.transporter.server.dao;


import java.util.List;

import org.pwr.transporter.entity.base.GenericDocumentRow;
import org.pwr.transporter.entity.sales.SalesOrder;



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
public interface GenericDocumentRowDAO<T extends GenericDocumentRow> extends GenericDAO<T> {

    List<SalesOrder> getByDocumentId(Long id);

}