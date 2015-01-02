package org.pwr.transporter.server.web.services.logistic;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.logistic.Itinerary;
import org.pwr.transporter.server.business.logistic.ItineraryLogic;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.dao.logistic.ItineraryDAO;
import org.pwr.transporter.server.web.services.IService;
import org.springframework.beans.factory.annotation.Autowired;



public class ItineraryService implements IService {

    @Autowired
    ItineraryLogic itineraryLogic;


    public void setItineraryDAO(ItineraryDAO itineraryDAO) {
        itineraryLogic.setItineraryDAO(itineraryDAO);
    }


    public Itinerary getByID(Long id) {
        return itineraryLogic.getByID(id);
    }


    public List<Itinerary> search(Map<String, Object> parameterMap) {
        return itineraryLogic.search(parameterMap);
    }


    public Long insert(Itinerary entity) {
        return itineraryLogic.insert(entity);
    }


    public void update(Itinerary entity) {
        itineraryLogic.update(entity);
    }


    public void delete(Itinerary entity) {
        itineraryLogic.delete(entity);
    }


    public void deleteById(Long id) {
        itineraryLogic.deleteById(id);
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<Itinerary> getListRest(int amount, int fromRow) {
        return itineraryLogic.getListRest(amount, fromRow);
    }


    public long count() {
        return itineraryLogic.count();
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<Itinerary> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return itineraryLogic.getListRestCrit(amount, fromRow, criteria);
    }


    @Override
    public long count(Criteria criteria) {
        return itineraryLogic.count(criteria);
    }

}
