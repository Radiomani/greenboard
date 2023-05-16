package com.example.service;

import java.util.List;

import com.example.model.Course;
import com.example.model.Result;

public interface CourseService {
    public Result<List<Course>> getCoursesByStudentID(String student_id);
    public Result<Course> getCourseByStudentIDandCourseID(String student_id, String course_id);
}
