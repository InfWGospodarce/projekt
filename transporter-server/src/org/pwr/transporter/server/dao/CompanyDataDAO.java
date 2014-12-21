package org.pwr.transporter.server.dao;


import org.pwr.transporter.entity.base.CompanyData;



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
