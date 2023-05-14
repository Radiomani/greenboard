package com.example.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
// import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import com.example.model.Announcement;

@Repository
public class AnnouncementRepositoryImpl implements AnnouncementRepository {
    @Autowired
    MongoTemplate mongoTemplate;



    @Override
    public List<Announcement> getAnnouncementsByCourseID(String course_id) {
        Query query = new Query(Criteria.where("course_id").is(course_id));
        List<Announcement> announcements_list = mongoTemplate.find(query, Announcement.class);
        return announcements_list;
    }
}
