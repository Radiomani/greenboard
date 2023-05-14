package com.example.controller;

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
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // @PostMapping
    // public String save(@RequestBody Course course) {
    //     return courseService.save(course);
    // }

    @GetMapping("/{course}")
    @ResponseBody
    public Course getcourse(@PathVariable("course") int course) {
        return courseService.getCourseById(course);
    }
}
