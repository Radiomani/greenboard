package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Assignment;
import com.mongodb.client.result.UpdateResult;

public interface AssignmentService {

    String getAssingmentByCourseID(String course_id);
    String getAssingmentByStudentID(String student_id);
    List<Assignment> getAssignmentByCourseIDandStudentID(String course_id, String student_id);

}
