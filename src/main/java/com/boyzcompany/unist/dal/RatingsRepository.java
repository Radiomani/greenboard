package com.boyzcompany.unist.dal;

import com.boyzcompany.unist.model.Ratings;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingsRepository extends MongoRepository<Ratings, String> {
}
