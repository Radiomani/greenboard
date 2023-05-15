package com.example.repositories;


import java.util.List;
import org.springframework.stereotype.Repository;

import com.example.model.Task;


@Repository
public interface TaskRepository {
    public List<Task> getTasksByStudentID(String student_id);
}
