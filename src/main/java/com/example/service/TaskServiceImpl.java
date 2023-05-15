package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.Task;
import com.example.repositories.TaskRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TaskServiceImpl implements TaskService{
    
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getTasksByStudentID(String student_id) {
        return taskRepository.getTasksByStudentID(student_id);
    }

    @Override
    public Optional<Task> getTasksByStudentIDandTaskName(String student_id, String task_name) {
        List<Task> tasks = taskRepository.getTasksByStudentID(student_id);
        Task task = new Task();
        boolean found = false;
        for (Task t : tasks) {
            if (task_name == t.getTaskName()) {
                task = t;
                found = true;
            }
        }
        if (found) return Optional.of(task);
        else return Optional.empty(); 
    }

    /*public Optional<Task> getTasksByStudentIDandTaksName(String student_id, String task_name) {
        
    }*/
}
