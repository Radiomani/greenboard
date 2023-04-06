package com.boyzcompany.unist.dal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.boyzcompany.unist.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
