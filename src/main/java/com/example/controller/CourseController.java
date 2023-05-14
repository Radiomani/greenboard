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
@RequestMapping("/movies")
public class CourseController {

    @Autowired
    private CourseService movieService;

    // @PostMapping
    // public String save(@RequestBody Movie movie) {
    //     return movieService.save(movie);
    // }

    @GetMapping("/{movie}")
    @ResponseBody
    public Course getMovie(@PathVariable("movie") int movie) {
        return movieService.getMovieById(movie);
    }
}
