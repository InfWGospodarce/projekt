package org.pwr.transporter.server.web.services;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.base.Address;
import org.pwr.transporter.server.business.AddressLogic;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.dao.base.AddressDAO;
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
public class AddressService implements IService {

	@Autowired
	private AddressLogic addressLogic;

	public void setAddressDAO( AddressDAO addressDAO ) {
		this.addressLogic.setAddressDAO(addressDAO);
	}

	public Address getByID( Long id ) {
		return this.addressLogic.getByID(id);
	}

	public List<Address> search( Map<String, Object> parameterMap ) {
		return this.addressLogic.search(parameterMap);
	}

	public Long insert( Address entity ) {
		return this.addressLogic.insert(entity);
	}

	public void update( Address entity ) {
		this.addressLogic.update(entity);
	}

	public void delete( Address entity ) {
		this.addressLogic.delete(entity);
	}

	public void deleteById( Long id ) {
		this.addressLogic.deleteById(id);
	}

	public long count( Criteria criteria ) {
		return this.addressLogic.count(criteria);
	}

	@SuppressWarnings("unchecked")
	public List<Address> getListRestCrit( int amount, int fromRow, Criteria criteria ) {
		return this.addressLogic.getListRestCrit(amount, fromRow, criteria);
	}

	@SuppressWarnings("unchecked")
	public List<Address> getListRest( int amount, int fromRow ) {
		return addressLogic.getListRest(amount, fromRow);
	}

	public long count() {
		return addressLogic.count();
	}

}
