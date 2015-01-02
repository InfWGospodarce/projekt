package org.pwr.transporter.server.business.logistic;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.logistic.Itinerary;
import org.pwr.transporter.server.dao.logistic.ItineraryDAO;



public class ItineraryLogic {

    ItineraryDAO itineraryDAO;


    public void setItineraryDAO(ItineraryDAO itineraryDAO) {
        this.itineraryDAO = itineraryDAO;
    }


    public Itinerary getByID(Long id) {
        return itineraryDAO.getByID(id);
    }


    public List<Itinerary> getList() {
        return itineraryDAO.getList();
    }


    public List<Itinerary> search(Map<String, Object> parameterMap) {
        return itineraryDAO.search(parameterMap);
    }


    public Long insert(Itinerary entity) {
        return itineraryDAO.insert(entity);
    }


    public void update(Itinerary entity) {
        itineraryDAO.update(entity);
    }


    public void delete(Itinerary entity) {
        itineraryDAO.delete(entity);
    }


    public void deleteById(Long id) {
        itineraryDAO.deleteById(id);
    }


    public List<Itinerary> getListRest(int amount, int fromRow) {
        return itineraryDAO.getListRest(amount, fromRow);
    }


    public long count() {
        return itineraryDAO.count();
    }


    public long count(Map<String, Object> criteria) {
        return this.itineraryDAO.count(criteria);
    }


    public List<Itinerary> getListRestCrit(int amount, int fromRow, Map<String, Object> criteria) {
        return this.itineraryDAO.getListRestCrit(amount, fromRow, criteria);
    }

}
