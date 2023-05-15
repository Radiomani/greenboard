package com.example.service;

import java.util.List;
import java.util.Optional;


import com.example.model.Assignment;

public interface AssignmentService {
    public List<Assignment> getAssignmentsByStudentID(String student_id);
    public List<Assignment> getAssignmentsByStudentIDandCourseID(String student_id, String course_id);
    public Optional<Assignment> getAssignmentByStudentIDandCourseIDandByAssingmentID(String student_id, String course_id, String assingment_id);
}
