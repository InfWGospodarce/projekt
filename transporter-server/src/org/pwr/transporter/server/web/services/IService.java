package org.pwr.transporter.server.web.services;


import java.util.List;

import org.pwr.transporter.entity.GenericEntity;



/**
 * <pre>
 *    Interface for services
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.2
 */
public interface IService {

    public <T extends GenericEntity> List<T> getListRest(long amount, long fromRow);


    public long count();

}
