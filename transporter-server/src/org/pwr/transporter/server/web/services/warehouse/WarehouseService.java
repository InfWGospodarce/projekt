package org.pwr.transporter.server.web.services.warehouse;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.base.Country;
import org.pwr.transporter.entity.enums.base.AddrStreetPrefix;
import org.pwr.transporter.entity.warehouse.Warehouse;
import org.pwr.transporter.server.business.warehouse.WarehouseLogic;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.dao.warehouse.WarehouseDAO;
import org.pwr.transporter.server.web.services.CountryService;
import org.pwr.transporter.server.web.services.IService;
import org.pwr.transporter.server.web.services.enums.AddrStreetPrefixService;
import org.springframework.beans.factory.annotation.Autowired;



public class WarehouseService implements IService {

    @Autowired
    WarehouseLogic warehouseLogic;

    @Autowired
    AddrStreetPrefixService addrStreetPrefixService;

    @Autowired
    CountryService countryService;


    public void setWarehouseDAO(WarehouseDAO warehouseDAO) {
        this.warehouseLogic.setWarehouseDAO(warehouseDAO);
    }


    public Warehouse getByID(Long id) {
        return this.warehouseLogic.getByID(id);
    }


    public List<Warehouse> search(Map<String, Object> parameterMap) {
        return this.warehouseLogic.search(parameterMap);
    }


    public Long insert(Warehouse entity) {
        fixAddres(entity);
        return this.warehouseLogic.insert(entity);
    }


    private void fixAddres(Warehouse entity) {
        AddrStreetPrefix addrPref = addrStreetPrefixService.getByID(Long.valueOf(entity.getAddress().getAddrStreetPrefixId()));
        entity.getAddress().setAddrStreetPrefix(addrPref);
        Country country = countryService.getByID(Long.valueOf(entity.getAddress().getCountryId()));
        entity.getAddress().setCountry(country);
    }


    public void update(Warehouse entity) {
        fixAddres(entity);
        this.warehouseLogic.update(entity);
    }


    public void delete(Warehouse entity) {
        this.warehouseLogic.delete(entity);
    }


    public void deleteById(Long id) {
        this.warehouseLogic.deleteById(id);
    }


    public long count(Criteria criteria) {
        return this.warehouseLogic.count(criteria);
    }


    public List<Warehouse> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.warehouseLogic.getListRestCrit(amount, fromRow, criteria);
    }


    public List<Warehouse> getListRest(int amount, int fromRow) {
        return this.warehouseLogic.getListRest(amount, fromRow);
    }


    public long count() {
        return this.warehouseLogic.count();
    }

}
