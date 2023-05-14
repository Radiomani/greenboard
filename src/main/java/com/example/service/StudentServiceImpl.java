package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.Student;
import com.example.repositories.StudentRepository;
import com.mongodb.client.result.UpdateResult;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@Service
public class StudentServiceImpl implements StudentService{
    
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public String save(Student student){
        student.setStudentId(getMaxId() + 1);
        return studentRepository.save(student).getId();
    }

    @Override
    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(int id) {
        Query query = new Query(Criteria.where("student_id").is(id));
        Student student = mongoTemplate.findOne(query, Student.class);
        if(student == null) {
            return Optional.empty();
        }
        return Optional.of(student);
    }

    @Override
    public Optional<Student> getStudentById(String id) {
        return studentRepository.findById(id);
    }

    @Override
    public UpdateResult updateStudentById(int id, Student updated_student) {
        Query query = new Query(Criteria.where("student_id").is(id));
        Update update = new Update()
        .set("gender", updated_student.getGender())
        .set("age", updated_student.getAge())
        .set("occupation", updated_student.getOccupation())
        .set("zip_code", updated_student.getZip_code());
        UpdateResult result = mongoTemplate.updateFirst(query, update, Student.class);
        return result;
    }

    @Override
    public int getMaxId() {
        Query query = new Query();
        query.limit(1).with(Sort.by(Sort.Direction.DESC, "student_id"));
        return mongoTemplate.find(query, Student.class).get(0).getStudent_id();
    }
}
