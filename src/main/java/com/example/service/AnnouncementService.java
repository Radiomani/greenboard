package com.example.service;

import java.util.List;

import com.example.model.Result;
import com.example.model.Announcement;

public interface AnnouncementService {
    public Result<List<Announcement>> getAnnouncementsByCourseID(String course_id);
    public Result<List<Announcement>> getAnnouncementsByStudentID(String student_id);
    public Result<List<Announcement>> getAnnouncementsByCourseIDandStudentID(String student_id, String course);    
}
