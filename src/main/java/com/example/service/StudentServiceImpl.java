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

    @Override
    public String save(Student student){
        return studentRepository.save(student).getId();
    }

    @Override
    public Optional<Student> getStudentByID(String student_id) {
        return Optional.of(studentRepository.getStudentByID(student_id));
    }
}
