
package org.pwr.transporter.server.web.services;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.base.Address;
import org.pwr.transporter.server.business.AddressLogic;
import org.pwr.transporter.server.dao.AddressDAO;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * <pre>
 *    Service for {@link Address} entity.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class AddressService {

    @Autowired
    private AddressLogic addressLogic;


    public void setAddressDAO(AddressDAO addressDAO) {
        this.addressLogic.setAddressDAO(addressDAO);
    }


    public Address getByID(Long id) {
        return this.addressLogic.getByID(id);
    }


    public List<Address> getList() {
        return this.addressLogic.getList();
    }


    public List<Address> search(Map<String, Object> parameterMap) {
        return this.addressLogic.search(parameterMap);
    }


    public Long insert(Address entity) {
        return this.addressLogic.insert(entity);
    }


    public void update(Address entity) {
        this.addressLogic.update(entity);
    }


    public void delete(Address entity) {
        this.addressLogic.delete(entity);
    }


    public void deleteById(Long id) {
        this.addressLogic.deleteById(id);
    }

}
