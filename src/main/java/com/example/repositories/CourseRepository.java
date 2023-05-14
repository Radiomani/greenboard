package com.example.repositories;

import com.example.model.Course;


public interface CourseRepository {
    public Course findCourseByCourseID(int course_id);
    public Course findCourseByName(String course_name);
    public long count();
}
