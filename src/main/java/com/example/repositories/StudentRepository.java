package com.example.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Student;

@Repository
public interface StudentRepository {
    public Student save(Student student);
    public Student getStudentByID(String student_id);
    public Student updateStudentByID(String student_id, String name, String email);
}

