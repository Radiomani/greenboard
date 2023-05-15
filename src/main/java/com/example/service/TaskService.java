package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Task;

public interface TaskService {
    public List<Task> getTasksByStudentID(String student_id);
    public Optional<Task> getTasksByStudentIDandTaskName(String student_id, String task_name);
    public String setTaskByStudentID(String student_id, Task task);
    public String deleteTaksByStudentIDandTaskName(String student_id, String task_name);    
}
