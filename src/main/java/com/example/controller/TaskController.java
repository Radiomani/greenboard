package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Task;
import com.example.service.TaskService;

@RestController
@RequestMapping("/calendar/tasks")
public class TaskController {
    
    @Autowired
    private TaskService taskService;


    @GetMapping("/{student_id}")
    @ResponseBody
    public List<Task>
    getTasksByStudentID(@PathVariable("student_id") String student_id) {
        return taskService.getTasksByStudentID(student_id);
    }

    @GetMapping("/{student_id}/{task_id}")
    @ResponseBody
    public Optional<Task>
    getTasksByStudentID(@PathVariable("student_id") String student_id, @PathVariable("task_id") String task_id) {
        return taskService.getTasksByStudentIDandTaskName(student_id, task_id);
    }
}
