package org.pwr.transporter.server.business.logistic;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.logistic.Vehicle;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.dao.logistic.VehicleDAO;



public class VehicleLogic {

    VehicleDAO vehicleDAO;


    public void setVehicleDAO(VehicleDAO vehicleDAO) {
        this.vehicleDAO = vehicleDAO;
    }


    public Vehicle getByID(Long id) {
        return vehicleDAO.getByID(id);
    }


    public List<Vehicle> search(Map<String, Object> parameterMap) {
        return vehicleDAO.search(parameterMap);
    }


    public Long insert(Vehicle entity) {
        return vehicleDAO.insert(entity);
    }


    public void update(Vehicle entity) {
        vehicleDAO.update(entity);
    }


    public void delete(Vehicle entity) {
        vehicleDAO.delete(entity);
    }


    public void deleteById(Long id) {
        vehicleDAO.deleteById(id);
    }


    public long count(Criteria criteria) {
        return this.vehicleDAO.count(criteria);
    }


    public List<Vehicle> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.vehicleDAO.getListRestCrit(amount, fromRow, criteria);
    }


    public List<Vehicle> getListRest(int amount, int fromRow) {
        return this.vehicleDAO.getListRest(amount, fromRow);
    }


    public long count() {
        return this.vehicleDAO.count();
    }

}
