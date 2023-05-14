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
@RequestMapping("/Assignments")
public class AssignmentController {

    @Autowired
    private AssignmentService assignAssignmentService;

    @ExceptionHandler(ObjectIdException.class)
    public ResponseEntity<String> handleObjectIdException() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body("Something wrong when saving the assignAssignment");
    }

    @ExceptionHandler(ParameterErrorNumberException.class)
    public ResponseEntity<String> handleParameterErrorNumber() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body("assignAssignment id does not exist!");
    }

    @ExceptionHandler(ParameterErrorStringException.class)
    public ResponseEntity<String> handleParameterErrorString() {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                             .body("Parameter is not a number!");
    }

    @PostMapping
    public ResponseEntity<Assignment> saveAssignment(@RequestBody Assignment assignAssignment) {
        String new_id = assignAssignmentService.save(assignAssignment);
        Optional<Assignment> new_assignAssignment = assignAssignmentService.getAssignmentById(new_id);
        if(new_assignAssignment == null) {
            throw new ObjectIdException("Something wrong when saving the assignAssignment!");
        } 
        return ResponseEntity.ok(new_assignAssignment.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assignment> getAssignment(@PathVariable("id") String id) {
        if(id.length() == 0) {
            throw new ParameterErrorStringException("Parameter is not a number!");
        }
        try {
            int assignAssignment_id = Integer.parseInt(id);
            Optional<Assignment> result = assignAssignmentService.getAssignmentById(assignAssignment_id);
            if(result.isPresent()) {
                return ResponseEntity.ok(result.get());
            }
            throw new ParameterErrorNumberException("Assignment id does not exist!");
        } catch(NumberFormatException e) {
            throw new ParameterErrorStringException("Parameter is not a number!");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Assignment> updateAssignment(@PathVariable("id") String id, @RequestBody Assignment assignAssignment) {
        if(id.length() == 0) {
            throw new ParameterErrorStringException("Parameter is not a number!");
        }
        try {
            int assignAssignment_id = Integer.parseInt(id);
            UpdateResult result = assignAssignmentService.updateAssignmentById(assignAssignment_id, assignAssignment);
            if(result.getMatchedCount() == 0) {
                throw new ParameterErrorNumberException("Assignment id does not exist!");
            }
            if(!result.wasAcknowledged()) {
                throw new ObjectIdException("Something wrong when saving the Assignment!");
            }
            return ResponseEntity.ok(assignAssignmentService.getAssignmentById(assignAssignment_id).get());
        } catch(NumberFormatException e) {
            throw new ParameterErrorStringException("Parameter is not a number!");
        }
    }
}