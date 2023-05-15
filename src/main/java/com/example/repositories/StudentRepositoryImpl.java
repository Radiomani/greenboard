package com.example.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
// import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.model.Student;


@Repository
public class StudentRepositoryImpl implements StudentRepository{

    @Autowired
    MongoTemplate mongoTemplate;
    public Student save(Student student) {
        return mongoTemplate.save(student);
    }

    @Override
    public Student getStudentByID(String student_id) {
        Query query = new Query(Criteria.where("student_id").is(student_id));
        Student result = mongoTemplate.findOne(query, Student.class);
        return result;
    }
}