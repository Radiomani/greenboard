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
import com.example.model.Assignment;
import com.example.service.AssignmentService;
import com.mongodb.client.result.UpdateResult;

@RestController
@RequestMapping("/dashboard/assignments")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @ExceptionHandler(ObjectIdException.class)
    public ResponseEntity<String> handleObjectIdException() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body("Something wrong when saving the assignment");
    }

    @ExceptionHandler(ParameterErrorNumberException.class)
    public ResponseEntity<String> handleParameterErrorNumber() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body("assignment id does not exist!");
    }

    @ExceptionHandler(ParameterErrorStringException.class)
    public ResponseEntity<String> handleParameterErrorString() {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                             .body("Parameter is not a number!");
    }

    @PostMapping
    public void subtmitAssignment(@RequestBody Assignment assignment ) {
        String new_id = assignmentService.subtmitAssignment(assignment);
        Optional<Assignment> new_assignment = assignmentService.getAssignmentById(new_id);
        if(new_assignment == null) {
            throw new ObjectIdException("Something wrong when saving the assignment!");
        } 
        return ResponseEntity.ok(new_assignment.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Assignment>> getAssignment(@PathVariable("id") String id) {
       
            return ResponseEntity.ok(assignmentService.getAssignmentById(id));
           
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
    }
}