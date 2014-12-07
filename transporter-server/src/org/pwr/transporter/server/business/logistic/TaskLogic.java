package org.pwr.transporter.server.business.logistic;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.logistic.Task;
import org.pwr.transporter.server.dao.logistic.TaskDAO;


public class TaskLogic {

	TaskDAO taskDAO;

	public void setTaskDAO( TaskDAO taskDAO ) {
		this.taskDAO = taskDAO;
	}

	public Task getByID( Long id ) {
		return taskDAO.getByID(id);
	}

	public List<Task> getList() {
		return taskDAO.getList();
	}

	public List<Task> search( Map<String, Object> parameterMap ) {
		return taskDAO.search(parameterMap);
	}

	public Long insert( Task entity ) {
		return taskDAO.insert(entity);
	}

	public void update( Task entity ) {
		taskDAO.update(entity);
	}

	public void delete( Task entity ) {
		taskDAO.delete(entity);
	}

	public void deleteById( Long id ) {
		taskDAO.deleteById(id);
	}

	public List<Task> getByUserId( Long id ) {
		return taskDAO.getByUserId(id);
	}

}
