package com.example.repositories;
// import java.util.List;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.example.model.Announcement;


@Repository
public interface AnnouncementRepository {
    public List<Announcement> getAnnouncementsByCourseID(String course);
}
