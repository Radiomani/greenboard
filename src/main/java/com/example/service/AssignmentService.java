package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Assignment;
import com.mongodb.client.result.UpdateResult;

public interface AssignmentService {

    String save(Assignment assignment);

    List<Assignment> getAssignment();

    public Optional<Assignment> getAssignmentById(int id);

    public Optional<Assignment> getAssignmentById(String id);

    public UpdateResult updateAssignmentById(int id, Assignment updated_assignment);

    public int getMaxId();

}
