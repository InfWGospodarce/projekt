package org.pwr.transporter.server.business;


import org.pwr.transporter.entity.base.CompanyData;
import org.pwr.transporter.server.dao.CompanyDataDAO;



/**
 * <pre>
 *    Logic for {@link CompanyData}
 * </pre>
 * <hr/>
 * 
 * @author x0r
 * @version 0.0.2
 */
public class CompanyDataLogic {

    CompanyDataDAO companyDataDAO;


    public void setCompanyDataDAO(CompanyDataDAO companyDataDAO) {
        this.companyDataDAO = companyDataDAO;
    }


    public long count() {
        return this.companyDataDAO.count();
    }


    public CompanyData getCompanyData() {
        return this.companyDataDAO.getFirst();
    }


    /**
     * <pre>
     *        There should be only one object of company data.
     * </pre>
     * <hr/>
     * 
     * @param entity
     * @return
     */
    public Long insert(CompanyData entity) {
        if( this.companyDataDAO.count() == 0 ) {
            return this.companyDataDAO.insert(entity);
        }
        return null;
    }


    public void update(CompanyData entity) {
        this.companyDataDAO.update(entity);
    }
}
