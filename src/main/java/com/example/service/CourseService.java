package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Course;

public interface CourseService {
    public Optional<Course> getCourseByCourseID(String course_id);
    public List<Course> getCoursesByStudentID(String student_id);
}
