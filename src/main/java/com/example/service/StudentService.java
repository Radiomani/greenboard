package com.example.service;

import java.util.Optional;

import com.example.model.Result;
import com.example.model.Student;

public interface StudentService {
    public String save(Student student);
    public Optional<Student> getStudentByID(String student_id);
    //public Result<String> updateStudentByID(String student_id, Student new_student);
}
