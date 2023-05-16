package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.ResponseException;
import com.example.model.Student;
import com.example.model.Result;
import com.example.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ExceptionHandler(ResponseException.class)
    public ResponseEntity<String> handleObjectIdException(ResponseException ex) {
        return ResponseEntity.status(ex.getStatus())
                             .body(ex.getMessage());
    }

    @PostMapping
    public ResponseEntity<Student>
    saveStudent(@RequestBody Student student) {
        Result<Student> result = studentService.save(student);
        if (result.isSafe()) {
            return ResponseEntity.ok(result.getResult());
        } else if (!result.saveSuccess()) {
            throw new ResponseException("Saving student failed!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            throw new ResponseException("Something wrong happens!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{student_id}")
    public ResponseEntity<Student>
    getStudent(@PathVariable("student_id") String id) {
        Result<Student> result = studentService.getStudentByID(id);
        return ResponseEntity.ok(result.getResult());
        if (result.isSafe()) {
            return ResponseEntity.ok(result.getResult());
        } else if (!result.isStudent()) {
            throw new ResponseException("Student does NOT exist!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            throw new ResponseException("Something wrong happens!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }    

    @PutMapping("/update/{student_id}")
    public ResponseEntity<Student>
    updateStudent(@PathVariable("student_id") String id, @RequestBody Student student) {
        Result<Student> result = studentService.updateStudentByID(id, student);
        if (result.isSafe()) {
            return ResponseEntity.ok(result.getResult());
        } else if (!result.isStudent()) {
            throw new ResponseException("Student does NOT exist!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            throw new ResponseException("Something wrong happens!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}