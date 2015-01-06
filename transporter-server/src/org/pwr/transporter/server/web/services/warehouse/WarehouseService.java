package org.pwr.transporter.server.web.services.warehouse;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.warehouse.Warehouse;
import org.pwr.transporter.server.business.warehouse.WarehouseLogic;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.web.services.IService;
import org.springframework.beans.factory.annotation.Autowired;



public class WarehouseService implements IService {

    @Autowired
    WarehouseLogic warehouseLogic;


    public Warehouse getByID(Long id) {
        return this.warehouseLogic.getByID(id);
    }


    public Long insert(Warehouse entity) {
        return this.warehouseLogic.insert(entity);
    }


    public void update(Warehouse entity) {
        this.warehouseLogic.update(entity);
    }


    public void delete(Warehouse entity) {
        this.warehouseLogic.delete(entity);
    }


    public void deleteById(Long id) {
        this.warehouseLogic.deleteById(id);
    }


    @SuppressWarnings("unchecked")
    public List<Warehouse> getListRest(int amount, int fromRow) {
        return this.warehouseLogic.getListRest(amount, fromRow);
    }


    public long count() {
        return this.warehouseLogic.count();
    }


    public long count(Criteria criteria) {
        return this.warehouseLogic.count(criteria);
    }


    @SuppressWarnings("unchecked")
    public List<Warehouse> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.warehouseLogic.getListRestCrit(amount, fromRow, criteria);
    }


    public List<Warehouse> search(Map<String, Object> parameterMap) {
        return this.warehouseLogic.search(parameterMap);
    }

}
