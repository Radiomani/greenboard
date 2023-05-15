package com.example.service;

import java.util.List;
import java.util.Optional;


import com.example.model.Assignment;

public interface AssignmentService {
    public List<Assignment> getAssingmentsByStudentID(String student_id);
    public List<Assignment> getAssignmentsByCourseIDandStudentID(String course_id, String student_id);
    public Optional<Assignment> getAssignmentByCourseIDandStudentIDandByAssingmentID(String course_id, String student_id, String assingment_id);
}
