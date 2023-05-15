package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Task;

public interface TaskService {
    public List<Task> getTasksByStudentID(String student_id);
    public Optional<Task> getTaskByStudentIDandTaskID(String student_id, String task_id);
    public Optional<Task> setTaskByStudentID(String student_id, Task task);
    public Optional<Task> updateTaskByStudentIDandTaskID(String student_id, String task_id, Task task);
    public String deleteTaskByStudentIDandTaskID(String student_id, String task_id);    
}
