package com.example.repositories;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.example.model.Assignment;


@Repository
public interface AssignmentRepository {

    public List<Assignment> getAssignmentsByCourseID(String coruse_id);
    public Assignment getAssignmentByID(String id);
    public boolean isAssignmentExistByAssignmentID(String assignment_id);
    
}
