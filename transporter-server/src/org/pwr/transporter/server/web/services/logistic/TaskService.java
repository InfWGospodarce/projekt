package org.pwr.transporter.server.web.services.logistic;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.logistic.Task;
import org.pwr.transporter.server.business.logistic.TaskLogic;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.dao.logistic.TaskDAO;
import org.pwr.transporter.server.web.services.IService;
import org.springframework.beans.factory.annotation.Autowired;



public class TaskService implements IService {

    @Autowired
    TaskLogic taskLogic;


    public void setTaskDAO(TaskDAO taskDAO) {
        taskLogic.setTaskDAO(taskDAO);
    }


    public Task getByID(Long id) {
        return taskLogic.getByID(id);
    }


    public List<Task> search(Map<String, Object> parameterMap) {
        return taskLogic.search(parameterMap);
    }


    public Long insert(Task entity) {
        return taskLogic.insert(entity);
    }


    public void update(Task entity) {
        taskLogic.update(entity);
    }


    public void delete(Task entity) {
        taskLogic.delete(entity);
    }


    public void deleteById(Long id) {
        taskLogic.deleteById(id);
    }


    public List<Task> getByUserId(Long id) {
        return taskLogic.getByUserId(id);
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<Task> getListRest(int amount, int fromRow) {
        return taskLogic.getListRest(amount, fromRow);
    }


    @Override
    public long count() {
        return taskLogic.count();
    }


    @Override
    public long count(Criteria criteria) {
        return taskLogic.count(criteria);
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<Task> getListRestCrit(int amount, int fromRow, Criteria criteria) {
        return taskLogic.getListRestCrit(amount, fromRow, criteria);
    }
}
