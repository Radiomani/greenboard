package com.example.service;

import java.util.List;

import com.example.model.Announcement;

public interface AnnouncementService {
    public List<Announcement> getAnnouncementsByCourseID(String course_id);
    public List<Announcement> getAnnouncementsByStudentID(String student_id);
    public List<Announcement> getAnnouncementsByCourseIDandStudentID(String student_id, String course);    
}
