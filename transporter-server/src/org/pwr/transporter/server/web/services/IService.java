package org.pwr.transporter.server.web.services;


import java.util.List;
import java.util.Map;

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

    public <T extends GenericEntity> List<T> getListRest(int amount, int fromRow);
    
    public <T extends GenericEntity> List<T> getListRestCrit(int amount, int fromRow, Map<String, Object> criteria);


    public long count();


	public long count(Map<String, Object> criteria);

}
