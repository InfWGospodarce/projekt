package org.pwr.transporter.server.web.services.warehouse;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.warehouse.InventoryBalance;
import org.pwr.transporter.server.business.warehouse.InventoryBalanceLogic;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.web.services.IService;
import org.springframework.beans.factory.annotation.Autowired;



public class InventoryBalanceService implements IService {

    @Autowired
    InventoryBalanceLogic inventoryBalanceLogic;


    public InventoryBalance getByID(Long id) {
        return this.inventoryBalanceLogic.getByID(id);
    }


    public Long insert(InventoryBalance entity) {
        return this.inventoryBalanceLogic.insert(entity);
    }


    public void update(InventoryBalance entity) {
        this.inventoryBalanceLogic.update(entity);
    }


    public void delete(InventoryBalance entity) {
        this.inventoryBalanceLogic.delete(entity);
    }


    public void deleteById(Long id) {
        this.inventoryBalanceLogic.deleteById(id);
    }


    @SuppressWarnings("unchecked")
    public List<InventoryBalance> getListRest(int amount, int fromRow) {
        return this.inventoryBalanceLogic.getListRest(amount, fromRow);
    }


    public long count() {
        return this.inventoryBalanceLogic.count();
    }


    public long count(Criteria criteria) {
        return this.inventoryBalanceLogic.count(criteria);
    }


    @SuppressWarnings("unchecked")
    public List<InventoryBalance> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.inventoryBalanceLogic.getListRestCrit(amount, fromRow, criteria);
    }


    public List<InventoryBalance> search(Map<String, Object> parameterMap) {
        return this.inventoryBalanceLogic.search(parameterMap);
    }

}
