package com.example.service;

import java.util.List;

import com.example.model.Assignment;

public interface AssignmentService {

    String getAssingmentsByCourseID(String course_id);
    String getAssingmentsByStudentID(String student_id);
    List<Assignment> getAssignmentsByCourseIDandStudentID(String course_id, String student_id);
    Assignment getAssignmentByCourseIDandStudentIDandByAssingmentID(String course_id, String student_id, String assingment_id);
}
