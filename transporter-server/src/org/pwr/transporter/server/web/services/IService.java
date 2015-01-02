package org.pwr.transporter.server.web.services;


import java.util.List;

import org.pwr.transporter.entity.Generic;
import org.pwr.transporter.server.core.hb.criteria.Criteria;



/**
 * <pre>
 *    Interface for services
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.3
 */
public interface IService {

    public <T extends Generic> List<T> getListRest(int amount, int fromRow);


    public <T extends Generic> List<T> getListRestCrit(int amount, int fromRow, Criteria criteria);


    public long count();


    public long count(Criteria criteria);

}
