package com.example.service;

import java.util.List;

import com.example.model.Announcement;
import com.example.model.Result;

public interface AnnouncementService {

    String save(Announcement rating);

    Result<List<Object>> getStudentAnnouncementGTE(double rating);

}
