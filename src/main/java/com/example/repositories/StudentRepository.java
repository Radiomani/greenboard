package com.example.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Student;

@Repository
public interface StudentRepository {
    Student getStudentByID(String student_id);
}

