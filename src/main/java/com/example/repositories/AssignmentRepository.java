package com.example.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Assignment;

@Repository
public interface AssignmentRepository extends MongoRepository<Assignment, String> {
    Assignment findById();
}
