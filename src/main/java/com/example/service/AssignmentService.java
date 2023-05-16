package com.example.service;

import java.util.List;

import com.example.model.Result;
import com.example.model.Assignment;

public interface AssignmentService {
    public Result<List<Assignment>> getAssignmentsByStudentID(String student_id);
    public Result<List<Assignment>> getAssignmentsByStudentIDandCourseID(String student_id, String course_id);
    public Result<Assignment> getAssignmentByStudentIDandCourseIDandByAssingmentID(String student_id, String course_id, String assingment_id);
}
