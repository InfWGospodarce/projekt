package org.pwr.transporter.server.web.services;


import org.pwr.transporter.entity.base.Address;
import org.pwr.transporter.entity.base.CompanyData;
import org.pwr.transporter.server.business.AddressLogic;
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
 * @version 0.0.2
 */
public class CompanyDataService {

	@Autowired
	CompanyDataLogic companyDataLogic;

	@Autowired
	AddressLogic addressLogic;

	public void setCompanyDataDAO( CompanyDataDAO companyDataDAO ) {
		this.companyDataLogic.setCompanyDataDAO(companyDataDAO);
	}

	public CompanyData getCompanyData() {
		return this.companyDataLogic.getCompanyData();
	}

	public Long insert( CompanyData entity ) {
		Long addressId = addressLogic.insert(entity.getAddress());
		Address address = addressLogic.getByID(addressId);
		entity.setAddress(address);
		return this.companyDataLogic.insert(entity);
	}

	public void update( CompanyData entity ) {
		addressLogic.update(entity.getAddress());
		this.companyDataLogic.update(entity);
	}

}
