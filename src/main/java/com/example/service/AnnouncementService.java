package com.example.service;

import java.util.List;

import com.example.model.Announcement;

public interface AnnouncementService {
    List<Announcement> getAnnouncementsByCourseID(String course_id);
    List<Announcement> getAnnouncementsByUserID(String user_id);
    List<Announcement> getAnnouncementsByCourseIDandUserID(String user_id, String course);    
}
