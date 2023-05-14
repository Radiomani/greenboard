package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.Course;
import com.example.repositories.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CourseServiceImpl implements CourseService{
    
    @Autowired
    private CourseRepository courseRepository;

    // @Override
    // public String save(course course){
    //     return courseRepository.save(course).getId();
    // }

    @Override
    public Course getCourseById(int id){
        return courseRepository.findCourseByCourseID(id);
    }

    @Override
    public long count() {
        return courseRepository.count();
    }
}
