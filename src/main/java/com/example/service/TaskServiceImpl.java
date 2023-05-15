package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.Task;
import com.example.model.Student;
import com.example.model.Result;
import com.example.repositories.TaskRepository;
import com.example.repositories.StudentRepository;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.ReplaceRootOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.repository.support.Repositories;
@Service
public class TaskServiceImpl implements TaskService{
    
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getTasksByStudentID(String student_id) {
        Student student;
    }

    public Optional<Task> getTasksByStudentIDandTaksName(String student_id, String task_name) {
        
    }
    public String setTaskByStudentID(String student_id, Task task);
    public String deleteTaksByStudentIDandTaskName(String student_id, String task_name);   
}
