package org.pwr.transporter.server.dao.impl;


import java.util.List;

import org.pwr.transporter.entity.base.CompanyData;
import org.pwr.transporter.server.dao.CompanyDataDAO;



/**
 * <pre>
 *    Implementation for company data DAO
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.4
 */
public class CompanyDataDAOImpl extends GenericDAOImpl<CompanyData> implements CompanyDataDAO {

    public CompanyDataDAOImpl() {
        setEntityClass(CompanyData.class);
    }


    @Override
    public CompanyData getFirst() {
        List<CompanyData> resultList = getList();
        if( !resultList.isEmpty() ) {
            return resultList.get(0);
        }
        return null;
    }


    @Override
    public void delete(CompanyData entity) {
    }


    @Override
    public void deleteById(Long id) {
    }
}
