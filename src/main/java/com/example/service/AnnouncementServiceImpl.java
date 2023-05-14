package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.Announcement;
import com.example.model.Result;
import com.example.repositories.AnnouncementRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.ReplaceRootOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.data.mongodb.core.query.Criteria;

@Service
public class AnnouncementServiceImpl implements AnnouncementService{
    
    @Autowired
    private AnnouncementRepository announcementRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public String save(Announcement announcement){
        return announcementRepository.save(announcement).getId();
    }

    @Override
    public Result<List<Object>> getStudentAnnouncementGTE(double announcement){
        if(announcement < 1 || announcement > 5) {
            return new Result<List<Object>>(false);
        }

        // Efficiently calculate the average announcement of each student
        GroupOperation avgAnnouncement = Aggregation.group("$student_id")
                                            .avg("$announcement").
                                            as("avg_announcement");

        // Create a Matching criteria for each student, where the average announcement should be >= the threshold.
        MatchOperation filterannouncement = Aggregation.match(
            Criteria.where("avg_announcement").gte(announcement)
        );

        // Sort the movies by their ID
        SortOperation sortOperation = Aggregation.sort(Sort.Direction.ASC, "student_id");

        // Assign the student ID to their information from the student collection
        LookupOperation studentLookup = Aggregation.lookup("student", "_id", "student_id", "matching_student");

        // Unwind the student information, i.e., remove the unnecessary brackets
        UnwindOperation unwindstudent = Aggregation.unwind("$matching_student");

        // Make the matching students as root
        ReplaceRootOperation replaceRoot = Aggregation.replaceRoot("$matching_student");

        // Only consider student names and their genres
        ProjectionOperation projectstudent = Aggregation.project("student_name", "genre")
                                                      .andExclude("_id");
        // Finalize the query
        Aggregation aggregation = Aggregation.newAggregation(
            avgAnnouncement,
            filterannouncement,
            sortOperation,
            studentLookup,
            unwindstudent,
            replaceRoot,
            projectstudent
        );

        AggregationResults<Object> results = mongoTemplate.aggregate(
            aggregation, 
            "announcement", 
            Object.class
        );

        // Return the results
        return new Result<List<Object>>(true, results.getMappedResults());
    }
}
