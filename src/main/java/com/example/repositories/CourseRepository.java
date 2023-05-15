package com.example.repositories;

import org.springframework.stereotype.Repository;

import com.example.model.Course;

@Repository
public interface CourseRepository {
    public Course findCourseByCourseID(String course_id);
    public Course findCourseByName(String course_name);
    public long count();
}
