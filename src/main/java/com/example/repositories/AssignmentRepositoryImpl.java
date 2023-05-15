package com.example.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
// import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import com.example.model.Assignment;

@Repository
public class AssignmentRepositoryImpl implements AssignmentRepository {
    @Autowired
    MongoTemplate mongoTemplate;



    @Override
    public List<Assignment> getAssignmentsByCourseID(String course_id) {
        Query query = new Query(Criteria.where("course_id").is(course_id));
        List<Assignment> assignments_list = mongoTemplate.find(query, Assignment.class);
        return assignments_list;
    }

    public Assignment getAssignmentByID(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        Assignment result = mongoTemplate.findOne(query, Assignment.class);
        return result;
    }

}
