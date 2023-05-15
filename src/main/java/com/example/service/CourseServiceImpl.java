package com.example.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import com.example.model.Course;
import com.example.model.Student;
import com.example.repositories.StudentRepository;
import com.example.repositories.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CourseServiceImpl implements CourseService{
    
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Optional<Course> getCourseByCourseID(String course_id) {
        return Optional.of(courseRepository.getCourseByID(course_id));
    }

    @Override List<Course> getCoursesByStudentID(String student_id) {
        Student student = studentRepository.getStudentByID(student_id);
        List<String> course_ids  = student.getCoursesTaken();
        List<Course> courses = new ArrayList<>();
        for (Course c : courses) {
            c.add(courseRepository.getCourseByID(c));
        }
        return courses;
    }
}
