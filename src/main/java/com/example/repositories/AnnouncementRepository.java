package com.example.repositories;
// import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Announcement;


@Repository
public interface AnnouncementRepository extends MongoRepository<Announcement, String> {

}
