package org.pwr.transporter.server.business;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.base.Address;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.dao.AddressDAO;
import org.pwr.transporter.server.dao.CountryDAO;
import org.pwr.transporter.server.dao.enums.AddrStreetPrefixDAO;



/**
 * <pre>
 *    Logic for {@link Address} entity
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.4
 */
public class AddressLogic {

    private AddressDAO addressDAO;

    private CountryDAO countryDAO;

    private AddrStreetPrefixDAO addrStreetPrefixDAO;


    public void setAddressDAO(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }


    public void setAddrStreetPrefixDAO(AddrStreetPrefixDAO addrStreetPrefixDAO) {
        this.addrStreetPrefixDAO = addrStreetPrefixDAO;
    }


    public void setCountryDAO(CountryDAO countryDAO) {
        this.countryDAO = countryDAO;
    }


    public Address getByID(Long id) {
        return this.addressDAO.getByID(id);
    }


    public List<Address> search(Map<String, Object> parameterMap) {
        return this.addressDAO.search(parameterMap);
    }


    public Long insert(Address entity) {
        entity.setCountry(countryDAO.getByID(Long.parseLong(entity.getCountryId())));
        entity.setAddrStreetPrefix(addrStreetPrefixDAO.getByID(Long.parseLong(entity.getAddrStreetPrefixId())));
        String searchKey = entity.getCity() + " " + entity.getStreet();
        entity.setSearchKey(searchKey);
        return this.addressDAO.insert(entity);
    }


    public void update(Address entity) {
        entity.setCountry(countryDAO.getByID(Long.parseLong(entity.getCountryId())));
        entity.setAddrStreetPrefix(addrStreetPrefixDAO.getByID(Long.parseLong(entity.getAddrStreetPrefixId())));
        this.addressDAO.update(entity);
    }


    public void delete(Address entity) {
        this.addressDAO.delete(entity);
    }


    public void deleteById(Long id) {
        this.addressDAO.deleteById(id);
    }


    public long count(Criteria criteria) {
        return this.addressDAO.count(criteria);
    }


    public List<Address> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.addressDAO.getListRestCrit(amount, fromRow, criteria);
    }


    public List<Address> getListRest(int amount, int fromRow) {
        return this.addressDAO.getListRest(amount, fromRow);
    }


    public long count() {
        return this.addressDAO.count();
    }

}
