package org.pwr.transporter.server.business.warehouse;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.warehouse.Warehouse;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.dao.warehouse.WarehouseDAO;



/**
 * <pre>
 *    Logic for {@link Warehouse} entity
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class WarehouseLogic {

    private WarehouseDAO warehouseDAO;


    public void setWarehouseDAO(WarehouseDAO warehouseDAO) {
        this.warehouseDAO = warehouseDAO;
    }


    public Warehouse getByID(Long id) {
        return this.warehouseDAO.getByID(id);
    }


    public List<Warehouse> search(Map<String, Object> parameterMap) {
        return this.warehouseDAO.search(parameterMap);
    }


    public Long insert(Warehouse entity) {
        return this.warehouseDAO.insert(entity);
    }


    public void update(Warehouse entity) {
        this.warehouseDAO.update(entity);
    }


    public void delete(Warehouse entity) {
        this.warehouseDAO.delete(entity);
    }


    public void deleteById(Long id) {
        this.warehouseDAO.deleteById(id);
    }


    public long count(Criteria criteria) {
        return this.warehouseDAO.count(criteria);
    }


    public List<Warehouse> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.warehouseDAO.getListRestCrit(amount, fromRow, criteria);
    }


    public List<Warehouse> getListRest(int amount, int fromRow) {
        return this.warehouseDAO.getListRest(amount, fromRow);
    }


    public long count() {
        return this.warehouseDAO.count();
    }

}
