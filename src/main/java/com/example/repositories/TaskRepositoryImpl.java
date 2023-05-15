package com.example.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


import com.example.model.Task;

@Repository
public class TaskRepositoryImpl implements TaskRepository {
    @Autowired
    MongoTemplate mongoTemplate;



    @Override
    public List<Task> getTasksByStudentID(String student_id) {
        Query query = new Query(Criteria.where("student_id").is(student_id));
        List<Task> tasks_list = mongoTemplate.find(query, Task.class);
        return tasks_list;
    }
}
