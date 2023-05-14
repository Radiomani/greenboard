package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Student;
import com.mongodb.client.result.UpdateResult;

public interface StudentService {

    String save(Student student);

    List<Student> getStudent();

    public Optional<Student> getStudentById(int id);

    public Optional<Student> getStudentById(String id);

    public UpdateResult updateStudentById(int id, Student updated_student);

    public int getMaxId();

}
