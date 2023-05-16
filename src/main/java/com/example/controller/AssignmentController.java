package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//mport org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.ResponseException;
import com.example.model.Assignment;
import com.example.model.Result;
import com.example.service.AssignmentService;

@RestController
@RequestMapping("/dashboard/deadlines")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @ExceptionHandler(ResponseException.class)
    public ResponseEntity<String> handleObjectIdException(ResponseException ex) {
        return ResponseEntity.status(ex.getStatus())
                             .body(ex.getMessage());
    }

    @GetMapping("/{student_id}")
    public ResponseEntity<List<Assignment>>
    getAssignmentsByStudentID(@PathVariable("student_id") String student_id) {
        Result<List<Assignment>> result = assignmentService.getAssignmentsByStudentID(student_id);
        if (result.isSafe()) {
            return ResponseEntity.ok(result.getResult());
        } else if(!result.isStudent()) {
            throw new ResponseException("Student does NOT exist!!!", HttpStatus.NOT_FOUND);
        } else {
            throw new ResponseException("Something wrong happens!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/{student_id}/{course_id}")
    public ResponseEntity<List<Assignment>>
    getAssignmentsByStudentIDandCourseID(@PathVariable("student_id") String student_id, @PathVariable("course_id") String course_id) {
        Result<List<Assignment>> result = assignmentService.getAssignmentsByStudentIDandCourseID(student_id, course_id);
        return ResponseEntity.ok(result.getResult());
        /*if (result.isSafe()) {
            return ResponseEntity.ok(result.getResult());
        } else if (!result.isStudent()) {
            throw new ResponseException("Student does NOT exist!!!", HttpStatus.NOT_FOUND);
        } else if (!result.isCourse()) {
            throw new ResponseException("Course does NOT exist", HttpStatus.NOT_FOUND);
        } else if (!result.courseAccess()) {
            throw new ResponseException("Student has NO access to course!!!", HttpStatus.NOT_ACCEPTABLE);
        } else {
            throw new ResponseException("Something wrong happens!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }*/
    }

    @GetMapping("/{student_id}/{course_id}/{assignment_id}")
    public ResponseEntity<Assignment>
    getAssignmentByStudentIDandCourseIDandByAssingmentID
            (@PathVariable("student_id") String student_id,
            @PathVariable("course_id") String course_id,
            @PathVariable("assignment_id") String assignment_id) {
        Result<Assignment> result = assignmentService.getAssignmentByStudentIDandCourseIDandByAssingmentID
                                                                    (student_id, course_id, assignment_id);
        return ResponseEntity.ok(result.getResult());
        /*if (result.isSafe()) {
            return ResponseEntity.ok(result.getResult());
        } else if (!result.isStudent()) {
            throw new ResponseException("Student does NOT exist!!!", HttpStatus.NOT_FOUND);
        } else if (!result.isCourse()) {
            throw new ResponseException("Course does NOT exist", HttpStatus.NOT_FOUND);
        } else if (!result.courseAccess()) {
            throw new ResponseException("Student has NO access to course!!!", HttpStatus.NOT_ACCEPTABLE);
        } else if (!result.isAssignment()) {
            throw new ResponseException("Assignment does NOT exist!!!", HttpStatus.NOT_FOUND);
        } else {
            throw new ResponseException("Something wrong happens!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }*/
    }

    /*@PostMapping
    public void subtmitAssignment(@RequestBody Assignment assignment ) {
        String new_id = assignmentService.subtmitAssignment(assignment);
        Optional<Assignment> new_assignment = assignmentService.getAssignmentById(new_id);
        if(new_assignment == null) {
            throw new ObjectIdException("Something wrong when saving the assignment!");
        } 
        return ResponseEntity.ok(new_assignment.get());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Assignment> updateAssignment(@PathVariable("id") String id, @RequestBody Assignment assignment) {
        if(id.length() == 0) {
            throw new ParameterErrorStringException("Parameter is not a number!");
        }
        try {
            int assignment_id = Integer.parseInt(id);
            UpdateResult result = assignmentService.updateAssignmentById(assignment_id, assignment);
            if(result.getMatchedCount() == 0) {
                throw new ParameterErrorNumberException("Assignment id does not exist!");
            }
            if(!result.wasAcknowledged()) {
                throw new ObjectIdException("Something wrong when saving the Assignment!");
            }
            return ResponseEntity.ok(assignmentService.getAssignmentById(assignment_id).get());
        } catch(NumberFormatException e) {
            throw new ParameterErrorStringException("Parameter is not a number!");
        }
    }*/
}