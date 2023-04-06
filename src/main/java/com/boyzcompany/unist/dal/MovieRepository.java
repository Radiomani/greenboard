package com.boyzcompany.unist.dal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.boyzcompany.unist.model.Movie;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {
}
