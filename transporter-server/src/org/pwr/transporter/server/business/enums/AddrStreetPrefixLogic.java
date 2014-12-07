package org.pwr.transporter.server.business.enums;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.enums.base.AddrStreetPrefix;
import org.pwr.transporter.server.dao.enums.AddrStreetPrefixDAO;



/**
 * <pre>
 *    Logic class for street prefix.
 * </pre>
 * <hr/>
 * 
 * @author x0r
 * @version 0.0.3
 */
public class AddrStreetPrefixLogic {

    AddrStreetPrefixDAO addrStreetPrefixDAO;


    public void setAddrStreetPrefixDAO(AddrStreetPrefixDAO addrStreetPrefixDAO) {
        this.addrStreetPrefixDAO = addrStreetPrefixDAO;
    }


    public AddrStreetPrefix getByID(Long id) {
        return this.addrStreetPrefixDAO.getByID(id);
    }


    public List<AddrStreetPrefix> getList() {
        return this.addrStreetPrefixDAO.getList();
    }


    public List<AddrStreetPrefix> search(Map<String, Object> parameterMap) {
        return this.addrStreetPrefixDAO.search(parameterMap);
    }


    public Long insert(AddrStreetPrefix entity) {
        return this.addrStreetPrefixDAO.insert(entity);
    }


    public void update(AddrStreetPrefix entity) {
        this.addrStreetPrefixDAO.update(entity);
    }


    public void delete(AddrStreetPrefix entity) {
        this.addrStreetPrefixDAO.delete(entity);
    }


    public void deleteById(Long id) {
        this.addrStreetPrefixDAO.deleteById(id);
    }

}
