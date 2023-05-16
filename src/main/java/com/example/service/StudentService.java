package com.example.service;

import com.example.model.Result;
import com.example.model.Student;

public interface StudentService {
    public Result<Student> save(Student student);
    public Result<Student> getStudentByID(String student_id);
    public Result<Student> updateStudentByID(String student_id, Student new_student);
}
