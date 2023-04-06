package com.boyzcompany.unist.dal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.boyzcompany.unist.model.Rating;

@Repository
public interface RatingRepository extends MongoRepository<Rating, String> {
}
