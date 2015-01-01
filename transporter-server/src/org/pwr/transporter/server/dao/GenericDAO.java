package org.pwr.transporter.server.dao;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.Generic;



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
public interface GenericDAO<T extends Generic> {

    T getByID(Long id);


    /**
     * <pre>
     *        Get full list of rows, better use {@link #getListRest(long, long)}
     * </pre>
     * <hr/>
     * 
     * @return
     */
    List<T> getList();


    /**
     * <pre>
     * Search
     * </pre>
     * <hr/>
     * 
     * @param parameterMap
     * @return
     */
    List<T> search(Map<String, Object> parameterMap);


    /**
     * <pre>
     *        Insert object, but not fully populated
     * </pre>
     * <hr/>
     * 
     * @param entity
     * @return
     */
    Long insert(T entity);


    /**
     * <pre>
     *        Update object
     * </pre>
     * <hr/>
     * 
     * @param entity
     */
    void update(T entity);


    /**
     * <pre>
     *        Delete, sets only active=false
     * </pre>
     * <hr/>
     * 
     * @param entity
     */
    void delete(T entity);


    /**
     * <pre>
     *        Delete, sets only active=false
     * </pre>
     * <hr/>
     * 
     * @param id
     */
    void deleteById(Long id);


    /**
     * <pre>
     *        Get amount rows fromRow number
     * </pre>
     * <hr/>
     * 
     * @param amount
     * @param fromRow
     * @return
     */
    public List<T> getListRest(int amount, int fromRow);


    public long count();


    public long count(Map<String, Object> criteria);


    public List<T> getListRestCrit(int amount, int fromRow, Map<String, Object> criteria);

}