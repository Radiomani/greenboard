package com.example.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.UpdateDefinition;
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

    @Override
    public Student updateStudentByID(String student_id, String new_student_id, String new_name, String new_email) {
        
        Query query = new Query(Criteria.where("student_id").is(student_id));

        Update updateQuery = new Update();
        updateQuery.set("student_id", new_student_id);
        updateQuery.set("email", new_email);
        updateQuery.set("name", new_name);

        mongoTemplate.updateFirst(query, updateQuery, Student.class);

        Student result = mongoTemplate.findOne(query, Student.class);
        return result;

    }

}