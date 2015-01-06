package org.pwr.transporter.server.dao.base;


import org.pwr.transporter.entity.base.CompanyData;
import org.pwr.transporter.server.dao.GenericDAO;



/**
 * <pre>
 *    Interface for company data.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.2
 */
public interface CompanyDataDAO extends GenericDAO<CompanyData> {

    public CompanyData getFirst();
}
