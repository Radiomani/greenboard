package com.example.service;

import java.util.List;

import com.example.model.Result;

public interface AnnouncementService {
    Result<List<Object>> getAnnouncementsByCourseID(String course_id);
    Result<List<Object>> getAnnouncementsByUserID(String user_id);
    Result<List<Object>> getAnnouncementsByCourseIDandUserID(String user_id, String course);    
}
