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

    @Override
    public boolean isCourseExist(String course_id) {
        Query query = new Query(Criteria.where("course_id").is(course_id));

        Course course = mongoTemplate.findOne(query, Course.class);

        if (course == null) {
            return false;
        }

        else {
            return true;
        }
    }

    @Override
    public Course findCourseByCourseID(String course_id) {
        Query query = new Query(Criteria.where("course_id").is(course_id));
        Course result = mongoTemplate.findOne(query, Course.class);
        return result;
    }

    @Override
    public Course findCourseByName(String course_name) {
        Query query = new Query(Criteria.where("course_name").is(course_name));
        Course result = mongoTemplate.findOne(query, Course.class);
        return result;
    }

    @Override
    public long count() {
        return mongoTemplate.count(new Query(), Course.class);
    }
}
