package com.example.controller;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Course;
import com.example.service.CourseService;

@RestController
@RequestMapping("greenboard/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // @PostMapping
    // public String save(@RequestBody Course course) {
    //     return courseService.save(course);
    // }

    @GetMapping("/{student_id}")
    @ResponseBody
    public ResponseEntity<List<Course>>
    getCoursesByStudentID(@PathVariable("student_id") String student_id) {
        return ResponseEntity.ok(courseService.getCoursesByStudentID(student_id));
    }

    @GetMapping("/{student_id}/{course_id}")
    @ResponseBody
    public ResponseEntity<Optional<Course>>
    getCoursesByStudentID(@PathVariable("student_id") String student_id, @PathVariable("course_id") String course_id) {
        return ResponseEntity.ok(courseService.getCourseByCourseID(course_id));
    }
}
