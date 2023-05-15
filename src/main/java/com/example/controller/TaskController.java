package com.example.controller;

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
@RequestMapping("/greenboard/dashboard/task_id")
public class TaskController {
    
    @Autowired
    private TaskService taskService;


    @GetMapping("/{task_id}")
    @ResponseBody
    public Tasl getTask(@PathVariable("task_id") String task_id) {
        return taskService.getCourseById(task_id);
    }
}
