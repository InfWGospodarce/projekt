package org.pwr.transporter.server.dao.impl.logistic;

import org.pwr.transporter.entity.logistic.Itinerary;
import org.pwr.transporter.server.dao.impl.GenericDAOImpl;
import org.pwr.transporter.server.dao.logistic.ItineraryDAO;

public class ItineraryDAOImpl extends GenericDAOImpl<Itinerary> implements ItineraryDAO{
	
	public ItineraryDAOImpl() {
		setEntityClass(Itinerary.class);
	}

}
