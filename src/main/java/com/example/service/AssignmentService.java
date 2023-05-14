package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Assignment;
import com.mongodb.client.result.UpdateResult;

public interface AssignmentService {

    String getAssingmentsByCourseID(String course_id);
    String getAssingmentsByStudentID(String student_id);
    List<Assignment> getAssignmentsByCourseIDandStudentID(String course_id, String student_id);
}
