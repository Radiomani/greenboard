package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Student;
import com.mongodb.client.result.UpdateResult;

public interface StudentService {

    String save(Student user);

    List<Student> getUser();

    public Optional<Student> getUserById(int id);

    public Optional<Student> getUserById(String id);

    public UpdateResult updateUserById(int id, Student updated_user);

    public int getMaxId();

}
