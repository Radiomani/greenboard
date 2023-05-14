package com.example.service;

import java.util.List;

import com.example.model.Announcement;

public interface AnnouncementService {
    List<Announcement> getAnnouncementsByCourseID(String course_id);
    List<Announcement> getAnnouncementsByStudentID(String student_id);
    List<Announcement> getAnnouncementsByCourseIDandUserID(String student_id, String course);    
}
