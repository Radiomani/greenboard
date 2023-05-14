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
    private StudentRepository userRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public String save(Student user){
        user.setUserId(getMaxId() + 1);
        return userRepository.save(user).getId();
    }

    @Override
    public List<Student> getUser(){
        return userRepository.findAll();
    }

    @Override
    public Optional<Student> getUserById(int id) {
        Query query = new Query(Criteria.where("user_id").is(id));
        Student user = mongoTemplate.findOne(query, Student.class);
        if(user == null) {
            return Optional.empty();
        }
        return Optional.of(user);
    }

    @Override
    public Optional<Student> getUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public UpdateResult updateUserById(int id, Student updated_user) {
        Query query = new Query(Criteria.where("user_id").is(id));
        Update update = new Update()
        .set("gender", updated_user.getGender())
        .set("age", updated_user.getAge())
        .set("occupation", updated_user.getOccupation())
        .set("zip_code", updated_user.getZip_code());
        UpdateResult result = mongoTemplate.updateFirst(query, update, Student.class);
        return result;
    }

    @Override
    public int getMaxId() {
        Query query = new Query();
        query.limit(1).with(Sort.by(Sort.Direction.DESC, "user_id"));
        return mongoTemplate.find(query, Student.class).get(0).getUser_id();
    }
}
