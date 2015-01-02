package org.pwr.transporter.server.dao;


import org.pwr.transporter.entity.article.GenericWare;



/**
 * <pre>
 *    Base interface for dao implementations.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.2
 * @param <T>
 * @param <ID>
 */
public interface GenericWareDAO<T extends GenericWare> extends GenericDAO<T> {

}