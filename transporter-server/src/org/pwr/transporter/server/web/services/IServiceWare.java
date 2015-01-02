package org.pwr.transporter.server.web.services;


import java.util.List;

import org.pwr.transporter.entity.article.GenericWare;



/**
 * <pre>
 *    Interface for services
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.2
 */
public interface IServiceWare {

    public <T extends GenericWare> List<T> getListRest(int amount, int fromRow);


    public long count();

}
