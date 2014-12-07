package org.pwr.transporter.server.web.services.logistic;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.logistic.Task;
import org.pwr.transporter.server.business.logistic.TaskLogic;
import org.pwr.transporter.server.dao.logistic.TaskDAO;
import org.springframework.beans.factory.annotation.Autowired;


public class TaskService {

	@Autowired
	TaskLogic taskLogic;

	public void setTaskDAO( TaskDAO taskDAO ) {
		taskLogic.setTaskDAO(taskDAO);
	}

	public Task getByID( Long id ) {
		return taskLogic.getByID(id);
	}

	public List<Task> getList() {
		return taskLogic.getList();
	}

	public List<Task> search( Map<String, Object> parameterMap ) {
		return taskLogic.search(parameterMap);
	}

	public Long insert( Task entity ) {
		return taskLogic.insert(entity);
	}

	public void update( Task entity ) {
		taskLogic.update(entity);
	}

	public void delete( Task entity ) {
		taskLogic.delete(entity);
	}

	public void deleteById( Long id ) {
		taskLogic.deleteById(id);
	}

	public List<Task> getByUserId( Long id ) {
		return taskLogic.getByUserId(id);
	}

}
