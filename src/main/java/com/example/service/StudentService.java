package com.example.service;

import java.util.Optional;

import com.example.model.Student;

public interface StudentService {

    String save(Student student);
    Optional<Student> getStudentByStudentID(String student_id);
}
