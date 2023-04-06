package com.boyzcompany.unist.dal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.boyzcompany.unist.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
