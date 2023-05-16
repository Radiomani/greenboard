package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.ResponseException;
import com.example.model.Result;
import com.example.model.Task;
import com.example.service.StudentService;
import com.example.service.TaskService;

@RestController
@RequestMapping("/calendar/tasks")
public class TaskController {
    
    @Autowired
    private TaskService taskService;

    @ExceptionHandler(ResponseException.class)
    public ResponseEntity<String> handleObjectIdException(ResponseException ex) {
        return ResponseEntity.status(ex.getStatus())
                             .body(ex.getMessage());
    }

    @GetMapping("/{student_id}")
    @ResponseBody
    public ResponseEntity<List<Task>>
    getTasksByStudentID(@PathVariable("student_id") String student_id) {
        Result<List<Task>> result = taskService.getTasksByStudentID(student_id);
        return ResponseEntity.ok(result.getResult());
        /*if (result.isSafe()) {
            return ResponseEntity.ok(result.getResult());
        } else if (!result.isStudent()) {
            throw new ResponseException("Student does NOT exist!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            throw new ResponseException("Something wrong happens!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }*/
    }

    @GetMapping("/{student_id}/{task_name}")
    @ResponseBody
    public ResponseEntity<Task>
    getTaskByStudentIDandTaskID(@PathVariable("student_id") String student_id, @PathVariable("task_name") String task_id) {
        Result<Task> result = taskService.getTaskByStudentIDandTaskID(student_id, task_id);
        return ResponseEntity.ok(result.getResult());
        /*if (result.isSafe()) {
            return ResponseEntity.ok(result.getResult());
        } else if (!result.isStudent()) {
            throw new ResponseException("Student does NOT exist!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        } else if (!result.isTask()){
            throw new ResponseException("Taks does NOT exist!!!", HttpStatus.NOT_FOUND);
        } else {
            throw new ResponseException("Something wrong happens!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }*/
    }

    @PostMapping("/{student_id}")
    @ResponseBody
    public ResponseEntity<Task>
    setTaskByStudentID(@PathVariable("student_id") String student_id, @RequestBody Task task) {
        Result<Task> result = taskService.setTaskByStudentID(student_id, task);
        return ResponseEntity.ok(result.getResult());
        /*if (result.isSafe()) {
            return ResponseEntity.ok(result.getResult());
        } else if (!result.isStudent()) {
            throw new ResponseException("Student does NOT exist!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            throw new ResponseException("Something wrong happens!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }*/
    }

    @PutMapping("/{student_id}/{task_name}")
    @ResponseBody
    public ResponseEntity<Task>
    updateTaskByStudentIDandTaskName(@PathVariable("student_id") String student_id, @PathVariable("task_id") String task_id, @RequestBody Task task) {
        Result<Task> result = taskService.updateTaskByStudentIDandTaskID(student_id, task_id, task);
        return ResponseEntity.ok(result.getResult());

        /*if (result.isSafe()) {
            return ResponseEntity.ok(result.getResult());
        } else if (!result.isStudent()) {
            throw new ResponseException("Student does NOT exist!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        } else if (!result.isTask()){
            throw new ResponseException("Taks does NOT exist!!!", HttpStatus.NOT_FOUND);
        } else {            
            throw new ResponseException("Something wrong happens!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }*/
    }

    /*@DeleteMapping("/{student_id}/{task_name}")
    @ResponseBody
    public ResponseEntity<Optional<String>>
    deleteTaskByStudentIDandTaksID(@PathVariable("student_id") String student_id, @PathVariable("task_id") String task_id) {
        return ResponseEntity.ok(taskService.deleteTaskByStudentIDandTaskID(student_id, task_id));
    }*/
}