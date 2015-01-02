package org.pwr.transporter.server.web.services.logistic;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.logistic.Vehicle;
import org.pwr.transporter.server.business.logistic.VehicleLogic;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.dao.logistic.VehicleDAO;
import org.pwr.transporter.server.web.services.IService;
import org.springframework.beans.factory.annotation.Autowired;



public class VehicleService implements IService {

    @Autowired
    VehicleLogic vehicleLogic;


    public void setVehicleDAO(VehicleDAO vehicleDAO) {
        vehicleLogic.setVehicleDAO(vehicleDAO);
    }


    public Vehicle getByID(Long id) {
        return vehicleLogic.getByID(id);
    }


    public List<Vehicle> search(Map<String, Object> parameterMap) {
        return vehicleLogic.search(parameterMap);
    }


    public Long insert(Vehicle entity) {
        return vehicleLogic.insert(entity);
    }


    public void update(Vehicle entity) {
        vehicleLogic.update(entity);
    }


    public void delete(Vehicle entity) {
        vehicleLogic.delete(entity);
    }


    public void deleteById(Long id) {
        vehicleLogic.deleteById(id);
    }


    public long count(Criteria criteria) {
        return this.vehicleLogic.count(criteria);
    }


    @SuppressWarnings("unchecked")
    public List<Vehicle> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return this.vehicleLogic.getListRestCrit(amount, fromRow, criteria);
    }


    @SuppressWarnings("unchecked")
    public List<Vehicle> getListRest(int amount, int fromRow) {
        return this.vehicleLogic.getListRest(amount, fromRow);
    }


    public long count() {
        return this.vehicleLogic.count();
    }

}
