package org.pwr.transporter.server.dao.impl.logistic;


import java.util.List;

import org.pwr.transporter.entity.logistic.Task;
import org.pwr.transporter.server.dao.impl.GenericDAOImpl;
import org.pwr.transporter.server.dao.logistic.TaskDAO;


public class TaskDAOImpl extends GenericDAOImpl<Task> implements TaskDAO {

	public TaskDAOImpl() {
		setEntityClass(Task.class);
	}

	@Override
	public List<Task> getByUserId( Long id ) {
		// TODO Fix
		return this.getList();
	}
}
