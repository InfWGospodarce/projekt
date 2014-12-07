package org.pwr.transporter.server.web.services;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.base.Country;
import org.pwr.transporter.server.business.CountryLogic;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * <pre>
 *    Country service
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class CountryService {

    @Autowired
    CountryLogic countryLogic;


    public Country getByID(Long id) {
        return this.countryLogic.getByID(id);
    }


    public List<Country> getList() {
        return this.countryLogic.getList();
    }


    public List<Country> search(Map<String, Object> parameterMap) {
        return this.countryLogic.search(parameterMap);
    }


    public Long insert(Country entity) {
        return this.countryLogic.insert(entity);
    }


    public void update(Country entity) {
        this.countryLogic.update(entity);
    }


    public void delete(Country entity) {
        this.countryLogic.delete(entity);
    }


    public void deleteById(Long id) {
        this.countryLogic.deleteById(id);
    }


    public Country getInternalCountry() {
        return this.countryLogic.getInternalCountry();
    }

}
