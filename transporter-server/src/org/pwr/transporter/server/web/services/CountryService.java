package org.pwr.transporter.server.web.services;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.Generic;
import org.pwr.transporter.entity.base.Country;
import org.pwr.transporter.server.business.CountryLogic;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * <pre>
 *    Country service
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.2
 */
public class CountryService implements IService {

    @Autowired
    CountryLogic countryLogic;

    @Autowired
    CurrencyService currencyService;


    public Country getByID(Long id) {
        return this.countryLogic.getByID(id);
    }


    public List<Country> search(Map<String, Object> parameterMap) {
        return this.countryLogic.search(parameterMap);
    }


    public Long insert(Country entity) {
        entity.setCurrency(currencyService.getByID(Long.valueOf(entity.getCurrencyId())));
        return this.countryLogic.insert(entity);
    }


    public void update(Country entity) {
        entity.setCurrency(currencyService.getByID(Long.valueOf(entity.getCurrencyId())));
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


    @SuppressWarnings("unchecked")
    public List<Country> getListRest(int amount, int fromRow) {
        return countryLogic.getListRest(amount, fromRow);
    }


    public long count() {
        return countryLogic.count();
    }


    @SuppressWarnings("unchecked")
    @Override
    public <T extends Generic> List<T> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return (List<T>) countryLogic.getListRestCrit(amount, fromRow, criteria);
    }


    @Override
    public long count(Criteria criteria) {
        return countryLogic.count(criteria);
    }


    public List<Country> getList() {
        return countryLogic.getList();
    }

}
