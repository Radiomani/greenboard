package com.example.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
// import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Course;


@Repository
public class CourseRepositoryImpl implements CourseRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public Course findMovieByMovieID(int movie_id) {
        Query query = new Query(Criteria.where("movie_id").is(movie_id));
        Course result = mongoTemplate.findOne(query, Course.class);
        return result;
    }

    public Course findMovieByName(String movie_name) {
        Query query = new Query(Criteria.where("movie_name").is(movie_name));
        Course result = mongoTemplate.findOne(query, Course.class);
        return result;
    }

    public long count() {
        return mongoTemplate.count(new Query(), Course.class);
    }
}
