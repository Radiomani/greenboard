package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.Announcement;
import com.example.model.Student;
import com.example.model.Result;
import com.example.repositories.AnnouncementRepository;
import com.example.repositories.StudentRepository;

import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AnnouncementServiceImpl implements AnnouncementService{
    
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private AnnouncementRepository announcementRepository;


    @Override
    public List<Announcement> getAnnouncementsByCourseID(String course_id) {
        return announcementRepository.getAnnouncementsByCourseID(course_id);
    }

    @Override
    public List<Announcement> getAnnouncementsByStudentID(String student_id) {
        Student student = studentRepository.getStudentByID();
        List<String> courses = student.getCoursesTaken();
        List<Announcement> anns = new ArrayList<>();
        for (String course : courses) {
            anns.addAll(announcementRepository.getAnnouncementsByCourseID(course));
        }
        return anns;
    }

    @Override
    public List<Announcement> getAnnouncementsByCourseIDandStudentID(String student_id, String course_id) {
        //Student student = studentRepository.getStudentByID();
        // List<String> courses = student.getCoursesTaken();
        return announcementRepository.getAnnouncementsByCourseID(course_id);
    }

}
