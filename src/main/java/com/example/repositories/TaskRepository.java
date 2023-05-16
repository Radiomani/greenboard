package com.example.repositories;


import java.util.List;
import org.springframework.stereotype.Repository;

import com.example.model.Task;


@Repository
public interface TaskRepository {
    public boolean isTaskExistByTaskID(String task_id);
    public List<Task> getTasksByStudentID(String student_id);
    public Task setTask(Task task);
    public Task updateTasksByTaskID (String student_id, String task_id, Task task);
    /*public Task updateTasksByStudentIDandTaskID(String task_id);
    public Task updateTasksByStudentIDandTaskID(String student_id, String task_id);*/
}
