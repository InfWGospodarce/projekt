package org.pwr.transporter.server.business.warehouse;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.warehouse.Shelf;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.dao.warehouse.ShelfDAO;



/**
 * <pre>
 *    Logic for {@link Shelf} entity
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class ShelfLogic {

    private ShelfDAO shelfDAO;


    public void setShelfDAO(ShelfDAO shelfDAO) {
        this.shelfDAO = shelfDAO;
    }


    public Shelf getByID(Long id) {
        return this.shelfDAO.getByID(id);
    }


    public List<Shelf> search(Map<String, Object> parameterMap) {
        return this.shelfDAO.search(parameterMap);
    }


    public Long insert(Shelf entity) {
        return this.shelfDAO.insert(entity);
    }


    public void update(Shelf entity) {
        this.shelfDAO.update(entity);
    }


    public void delete(Shelf entity) {
        this.shelfDAO.delete(entity);
    }


    public void deleteById(Long id) {
        this.shelfDAO.deleteById(id);
    }


    public long count(Criteria criteria) {
        return this.shelfDAO.count(criteria);
    }


    public List<Shelf> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.shelfDAO.getListRestCrit(amount, fromRow, criteria);
    }


    public List<Shelf> getListRest(int amount, int fromRow) {
        return this.shelfDAO.getListRest(amount, fromRow);
    }


    public long count() {
        return this.shelfDAO.count();
    }

}
