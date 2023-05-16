package com.example.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import com.example.model.Course;
import com.example.model.Student;
import com.example.model.Result;
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
    public Result<List<Course>> getCoursesByStudentID(String student_id) {
        Student student = studentRepository.getStudentByID(student_id);
        List<String> course_ids  = student.getCoursesTaken();
        List<Course> courses = new ArrayList<>();
        for (String course_id : course_ids) {
            courses.add(courseRepository.findCourseByCourseID(course_id));
        }
        return new Result<>(courses);
        /*if (studentRepository.isStudentExist(student_id)) {
            Student student = studentRepository.getStudentByID(student_id);
            List<String> course_ids  = student.getCoursesTaken();
            List<Course> courses = new ArrayList<>();
            for (String course_id : course_ids) {
                courses.add(courseRepository.findCourseByCourseID(course_id));
            }
            return new Result<>(courses);
        } else {
            Result<List<Course>> result = new Result<>();
            result.notStudent();
            return result;             
        }*/
    }

    @Override
    public Result<Course> getCourseByStudentIDandCourseID(String student_id, String course_id) {
        return new Result<>(courseRepository.findCourseByCourseID(course_id));
        /*Result<Course> result = new Result<>();
        if (studentRepository.isStudentExist(student_id)) {
            if (courseRepository.isCourseExist(course_id)) {
                Student student = studentRepository.getStudentByID(student_id);
                if (student.getCoursesTaken().contains(course_id)) {
                    return new Result<>(courseRepository.findCourseByCourseID(course_id));
                } else {
                    result.noCourseAccess();
                    return result;
                }
            } else {
                result.notCourse();
                return result;
            }
        } else {
            result.notStudent();
            return result;             
        }*/
    }
}
