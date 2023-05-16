package com.example.service;

import java.util.List;

import com.example.model.Result;
import com.example.model.Task;

public interface TaskService {
    public Result<List<Task>> getTasksByStudentID(String student_id);
    public Result<Task> getTaskByStudentIDandTaskID(String student_id, String task_id);
    public Result<Task>setTaskByStudentID(String student_id, Task task);
    public Result<Task> updateTaskByStudentIDandTaskID(String student_id, String task_id, Task task);
    //public Result<String> deleteTaskByStudentIDandTaskID(String student_id, String task_id);    
}
