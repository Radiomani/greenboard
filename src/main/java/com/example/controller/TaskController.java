package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ResponseEntity<List<Task>>
    getTasksByStudentID(@PathVariable("student_id") String student_id) {
        return ResponseEntity.ok(taskService.getTasksByStudentID(student_id));
    }

    @GetMapping("/{student_id}/{task_name}")
    @ResponseBody
    public ResponseEntity<Optional<Task>>
    getTaskByStudentIDandTaskID(@PathVariable("student_id") String student_id, @PathVariable("task_name") String task_id) {
        return ResponseEntity.ok(taskService.getTasksByStudentIDandTaskID(student_id, task_id));
    }

    @PostMapping("/{student_id}")
    @ResponseBody
    public ResponseEntity<Optional<Task>>
    setTaskByStudentID(@PathVariable("student_id") String student_id, @RequestBody Task task) {
        return ResponseEntity.ok(taskService.setTaskByStudentID(student_id, task));
    }

    @PutMapping("/{student_id}/{task_name}")
    @ResponseBody
    public ResponseEntity<Optional<Task>>
    updateTaskByStudentIDandTaskName(@PathVariable("student_id") String student_id, @PathVariable("task_id") String task_id, @RequestBody Task task) {
        return ResponseEntity.ok(taskService.updateTaskByStudentIDandTaskID(student_id, task_id, task));
    }

    @DeleteMapping("/{student_id}/{task_name}")
    @ResponseBody
    public ResponseEntity<Optional<String>>
    deleteTaskByStudentIDandTaksID(@PathVariable("student_id") String student_id, @PathVariable("task_id") String task_id) {
        return ResponseEntity.ok(taskService.deleteTaskByStudentIDandTaskID(student_id, task_id));
    }
}