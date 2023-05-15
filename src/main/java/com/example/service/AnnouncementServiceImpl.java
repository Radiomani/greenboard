package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.Announcement;
import com.example.model.Student;
import com.example.model.Result;
import com.example.repositories.AnnouncementRepository;
import com.example.repositories.StudentRepository;

import com.example.repositories.CourseRepository;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AnnouncementServiceImpl implements AnnouncementService{
    
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private AnnouncementRepository announcementRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Result<List<Announcement>>
    getAnnouncementsByCourseID(String course_id) {
        if (courseRepository.isCourseExist(course_id))
        {
            List<Announcement> ret = announcementRepository.getAnnouncementsByCourseID(course_id);
            return new Result<>(ret);
        } else {
            Result<List<Announcement>> result = new Result<>();
            result.notCourse();
            return result;
        }   
    }

    @Override
    public Result<List<Announcement>>
    getAnnouncementsByStudentID(String student_id) {
        if (studentRepository.isStudentExist(student_id)) {
            Student student = studentRepository.getStudentByID(student_id);
            List<String> courses = student.getCoursesTaken();
            List<Announcement> anns = new ArrayList<>();
            for (String course : courses) {
                anns.addAll(announcementRepository.getAnnouncementsByCourseID(course));
            }
            return new Result<>(anns);
        } else {
            Result<List<Announcement>> result = new Result<>();
            result.notStudent();
            return result;
        }

    }

    @Override
    public Result<List<Announcement>>
    getAnnouncementsByCourseIDandStudentID(String student_id, String course_id) {
        if (studentRepository.isStudentExist(student_id)) {
            if (courseRepository.isCourseExist(course_id)) {
                Student student = studentRepository.getStudentByID(student_id);
                if (student.getCoursesTaken().contains(course_id)) {
                    return new Result<>(announcementRepository.getAnnouncementsByCourseID(course_id));
                } else {
                    Result<List<Announcement>> result = new Result<>();
                    result.noCourseAccess();
                    return result;
                }
            } else {
                Result<List<Announcement>> result = new Result<>();
                result.notCourse();
                return result;
            }
        } else {
            Result<List<Announcement>> result = new Result<>();
            result.notStudent();
            return result;
        }
    }
}
