package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.ResponseException;
import com.example.model.Announcement;
import com.example.model.Result;
import com.example.service.AnnouncementService;

@RestController
@RequestMapping("/announcements")
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    @ExceptionHandler(ResponseException.class)
    public ResponseEntity<String> HandleException(ResponseException ex) {
        return ResponseEntity.status(ex.getStatus())
                .body(ex.getMessage());
    }

    @GetMapping("/{student_id}")
    @ResponseBody
    public ResponseEntity<List<Announcement>> getAnnouncementsByStudentID(@PathVariable("student_id") String student_id) {
        Result<List<Announcement>> result = announcementService.getAnnouncementsByStudentID(student_id);
        return ResponseEntity.ok(result.getResult());
        /*if (result.isSafe()) {
            return ResponseEntity.ok(result.getResult());
        } else if (!result.isStudent()) {
            throw new ResponseException("Student does NOT exist!!!", HttpStatus.NOT_FOUND);
        } else {
            throw new ResponseException("Something wrong happens!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }*/
    }

    @GetMapping("/{student_id}/{course_id}")
    @ResponseBody
    public ResponseEntity<List<Announcement>> getAnnouncementsByCourseIDandStudentID(
            @PathVariable("student_id") String student_id, @PathVariable("course_id") String course_id) {
        Result<List<Announcement>> result = announcementService.getAnnouncementsByCourseIDandStudentID(student_id, course_id);
        return ResponseEntity.ok(result.getResult());
        /*if (result.isSafe()) {
            return ResponseEntity.ok(result.getResult());
        } else if (!result.isStudent()) {
            throw new ResponseException("Student does NOT exist!!!", HttpStatus.NOT_FOUND);
        } else if (!result.isCourse()) {
            throw new ResponseException("Course does NOT exist!!!", HttpStatus.NOT_FOUND);
        } else if (!result.courseAccess()) {
            throw new ResponseException("Student has NO access to course!!!", HttpStatus.NOT_ACCEPTABLE);
        } else {
            throw new ResponseException("Something wrong happens!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }*/
    }
}
