package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.Task;
import com.example.repositories.TaskRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.TaskUtils;

@Service
public class TaskServiceImpl implements TaskService{
    
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getTasksByStudentID(String student_id) {
        return taskRepository.getTasksByStudentID(student_id);
    }

    @Override
    public Optional<Task> getTaskByStudentIDandTaskID(String student_id, String task_id) {
        List<Task> tasks = taskRepository.getTasksByStudentID(student_id);
        Task task = new Task();
        boolean found = false;
        for (Task t : tasks) {
            if (task_id == t.getTaskName()) {
                task = t;
                found = true;
            }
        }
        if (found) return Optional.of(task);
        else return Optional.empty(); 
    }

    public Optional<Task> setTaskByStudentID(String student_id, Task task) {
        task.setStudentID(student_id);
        return taskRepository.setTask(task);
    }

    public Optional<Task> updateTasksByStudentIDandTaskID(String student_id, String task_id, Task task) {
        return taskRepository.updateTaskByStudentIDandTaskID(student_id, task_id, task);
    }

    public String deleteTaskByStudentIDandTaskID(String student_id, String task_id) {
        return deleteTaskByStudentIDandTaskID(student_id, task_id);
    }   
}
