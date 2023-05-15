package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.ObjectIdException;
import com.example.exception.ParameterErrorNumberException;
import com.example.exception.ParameterErrorStringException;
import com.example.model.Student;
import com.example.service.StudentService;
import com.mongodb.client.result.UpdateResult;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ExceptionHandler(ObjectIdException.class)
    public ResponseEntity<String> handleObjectIdException() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body("Something wrong when saving the student");
    }

    @ExceptionHandler(ParameterErrorNumberException.class)
    public ResponseEntity<String> handleParameterErrorNumber() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body("student id does not exist!");
    }

    @ExceptionHandler(ParameterErrorStringException.class)
    public ResponseEntity<String> handleParameterErrorString() {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                             .body("Parameter is not a number!");
    }

    @PostMapping
    public ResponseEntity<Student>
    saveStudent(@RequestBody Student student) {
        String new_id = studentService.save(student);
        Optional<Student> new_student = studentService.getStudentByID(new_id);
        if(new_student == null) {
            throw new ObjectIdException("Something wrong when saving the student!");
        } 
        return ResponseEntity.ok(new_student.get());
    }

    @GetMapping("/{student_id}")
    public ResponseEntity<Optional<Student>>
    getStudent(@PathVariable("student_id") String id) {
        return ResponseEntity.ok(studentService.getStudentByID(id));
    }
    
    

    /* @PutMapping("/students/registration/{student_id}")
    public ResponseEntity<Optional<Student>>
    updateStudent(@PathVariable("student_id") String id, @RequestBody Student student) {
        if(id.length() == 0) {
            throw new ParameterErrorStringException("Id is invalid!");
        }
        try {
            // int student_id = Integer.parseInt(id);
            UpdateResult result = studentService.updateStudentByID(id, student);
            if(result.getMatchedCount() == 0) {
                throw new ParameterErrorNumberException("student id does not exist!");
            }
            if(!result.wasAcknowledged()) {
                throw new ObjectIdException("Something wrong when saving the student!");
            }
            // return ResponseEntity.ok(studentService.getStudentByID(id).get());
            Optional<Student> optionalStudent = studentService.getStudentByID(id);
            if (optionalStudent.isPresent()) {
                // Student student_obj = optionalStudent.get();
                return ResponseEntity.ok(optionalStudent);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch(NumberFormatException e) {
            throw new ParameterErrorStringException("Parameter is not a number!");
        }
    }*/
}