package com.example.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Update;


import com.example.model.Task;

@Repository
public class TaskRepositoryImpl implements TaskRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Task setTask(Task task) {
        return mongoTemplate.save(task);
    }

    @Override
    public List<Task> getTasksByStudentID(String student_id) {
        Query query = new Query(Criteria.where("student_id").is(student_id));
        List<Task> tasks_list = mongoTemplate.find(query, Task.class);
        return tasks_list;
    }

    /*@Override
    public Task updateTasksByStudentIDandTaskID(String student_id, String task_id) {

    }*/

    @Override
    public Task updateTasksByTaskID (String student_id, String task_id, Task task) {
        
        Query query = new Query(Criteria.where("task_id").is(task_id));

        Update updateQuery = new Update();

        updateQuery.set("task_name", new_taskname);
        updateQuery.set("description", new_description);
        updateQuery.set("deadline", new_deadline);
        updateQuery.set("priority", new_priority);

        mongoTemplate.updateFirst(query, updateQuery, Task.class);

        Task result = mongoTemplate.findOne(query, Task.class);
        return result;

    }

}
