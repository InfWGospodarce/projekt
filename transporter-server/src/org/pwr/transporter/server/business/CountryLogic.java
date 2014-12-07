package org.pwr.transporter.server.business;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.base.CompanyData;
import org.pwr.transporter.entity.base.Country;
import org.pwr.transporter.server.dao.CompanyDataDAO;
import org.pwr.transporter.server.dao.CountryDAO;



/**
 * <pre>
 *    Logic for country
 * </pre>
 * <hr/>
 * 
 * @author x0r
 * @version 0.0.2
 */
public class CountryLogic {

    CountryDAO countryDAO;

    CompanyDataDAO companyDataDAO;


    public void setCompanyDataDAO(CompanyDataDAO companyDataDAO) {
        this.companyDataDAO = companyDataDAO;
    }


    public void setCountryDAO(CountryDAO countryDAO) {
        this.countryDAO = countryDAO;
    }


    public Country getByID(Long id) {
        return this.countryDAO.getByID(id);
    }


    public List<Country> getList() {
        return this.countryDAO.getList();
    }


    public List<Country> search(Map<String, Object> parameterMap) {
        return this.countryDAO.search(parameterMap);
    }


    public Long insert(Country entity) {
        return this.countryDAO.insert(entity);
    }


    public void update(Country entity) {
        this.countryDAO.update(entity);
    }


    public void delete(Country entity) {
        this.countryDAO.delete(entity);
    }


    public void deleteById(Long id) {
        this.countryDAO.deleteById(id);
    }


    public Country getInternalCountry() {
        CompanyData comp = companyDataDAO.getFirst();
        if( comp != null ) {
            return comp.getAddress().getCountry();
        }
        return null;
    }

}
