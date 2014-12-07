package org.pwr.transporter.server.dao;


import org.pwr.transporter.entity.base.CompanyData;



/**
 * <pre>
 *    Interface for company data.
 * </pre>
 * <hr/>
 * 
 * @author x0r
 * @version 0.0.1
 */
public interface CompanyDataDAO extends GenericDAO<CompanyData> {

    public long count();


    public CompanyData getFirst();
}
