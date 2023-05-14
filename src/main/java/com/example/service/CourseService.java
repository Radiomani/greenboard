package com.example.service;

import com.example.model.Course;

public interface CourseService {
    public Course getCourseById(String course_id);
    public Course getCoursesByStudentID(String student_id);
}
