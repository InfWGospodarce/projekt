
package org.pwr.transporter.server.web.services.enums;


import java.util.List;

import org.pwr.transporter.entity.enums.base.AddrStreetPrefix;
import org.pwr.transporter.server.business.enums.AddrStreetPrefixLogic;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * <pre>
 *    Service for street prefix.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class AddrStreetPrefixService {

    @Autowired
    private AddrStreetPrefixLogic addrStreetPrefixLogic;


    public AddrStreetPrefix getByID(Long id) {
        return this.addrStreetPrefixLogic.getByID(id);
    }


    public List<AddrStreetPrefix> getList() {
        return this.addrStreetPrefixLogic.getList();
    }


    public Long insert(AddrStreetPrefix entity) {
        return this.addrStreetPrefixLogic.insert(entity);
    }


    public void update(AddrStreetPrefix entity) {
        this.addrStreetPrefixLogic.update(entity);
    }


    public void delete(AddrStreetPrefix entity) {
        this.addrStreetPrefixLogic.delete(entity);
    }


    public void deleteById(Long id) {
        this.addrStreetPrefixLogic.deleteById(id);
    }

}
