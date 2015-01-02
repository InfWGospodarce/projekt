package org.pwr.transporter.server.dao.impl.sales;


import java.util.List;

import org.pwr.transporter.entity.sales.SalesOrder;
import org.pwr.transporter.server.dao.impl.GenericDAOImpl;
import org.pwr.transporter.server.dao.sales.SalesOrderDAO;



public class SalesOrderDAOImpl extends GenericDAOImpl<SalesOrder> implements SalesOrderDAO {

    public SalesOrderDAOImpl() {
        setEntityClass(SalesOrder.class);
    }


    @Override
    public List<SalesOrder> getByUserId(Long id) {
        // TODO Auto-generated method stub
        return null;
    }
}
