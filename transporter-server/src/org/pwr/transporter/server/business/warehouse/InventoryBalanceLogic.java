package org.pwr.transporter.server.business.warehouse;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.warehouse.InventoryBalance;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.dao.warehouse.InventoryBalanceDAO;



/**
 * <pre>
 *    Logic for {@link InventoryBalance} entity
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class InventoryBalanceLogic {

    private InventoryBalanceDAO inventoryBalanceDAO;


    public void setInventoryBalanceDAO(InventoryBalanceDAO inventoryBalanceDAO) {
        this.inventoryBalanceDAO = inventoryBalanceDAO;
    }


    public InventoryBalance getByID(Long id) {
        return this.inventoryBalanceDAO.getByID(id);
    }


    public List<InventoryBalance> search(Map<String, Object> parameterMap) {
        return this.inventoryBalanceDAO.search(parameterMap);
    }


    public Long insert(InventoryBalance entity) {
        return this.inventoryBalanceDAO.insert(entity);
    }


    public void update(InventoryBalance entity) {
        this.inventoryBalanceDAO.update(entity);
    }


    public void delete(InventoryBalance entity) {
        this.inventoryBalanceDAO.delete(entity);
    }


    public void deleteById(Long id) {
        this.inventoryBalanceDAO.deleteById(id);
    }


    public long count(Criteria criteria) {
        return this.inventoryBalanceDAO.count(criteria);
    }


    public List<InventoryBalance> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.inventoryBalanceDAO.getListRestCrit(amount, fromRow, criteria);
    }


    public List<InventoryBalance> getListRest(int amount, int fromRow) {
        return this.inventoryBalanceDAO.getListRest(amount, fromRow);
    }


    public long count() {
        return this.inventoryBalanceDAO.count();
    }

}
