package org.pwr.transporter.server.web.services;


import org.pwr.transporter.entity.base.CompanyData;
import org.pwr.transporter.server.business.CompanyDataLogic;
import org.pwr.transporter.server.dao.CompanyDataDAO;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * <pre>
 *    Service {@link CompanyData}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class CompanyDataService {

    @Autowired
    CompanyDataLogic companyDataLogic;


    public void setCompanyDataDAO(CompanyDataDAO companyDataDAO) {
        this.companyDataLogic.setCompanyDataDAO(companyDataDAO);
    }


    public CompanyData getCompanyData() {
        return this.companyDataLogic.getCompanyData();
    }


    public Long insert(CompanyData entity) {
        return this.companyDataLogic.insert(entity);
    }


    public void update(CompanyData entity) {
        this.companyDataLogic.update(entity);
    }

}
