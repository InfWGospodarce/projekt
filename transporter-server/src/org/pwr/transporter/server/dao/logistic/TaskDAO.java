package org.pwr.transporter.server.dao.logistic;


import java.util.List;

import org.pwr.transporter.entity.logistic.Task;
import org.pwr.transporter.server.dao.GenericDAO;


public interface TaskDAO extends GenericDAO<Task> {

	List<Task> getByUserId( Long id );

}
