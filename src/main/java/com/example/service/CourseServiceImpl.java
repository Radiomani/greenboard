package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.Course;
import com.example.repositories.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CourseServiceImpl implements CourseService{
    
    @Autowired
    private CourseRepository movieRepository;

    // @Override
    // public String save(Movie movie){
    //     return movieRepository.save(movie).getId();
    // }

    @Override
    public Course getMovieById(int id){
        return movieRepository.findMovieByMovieID(id);
    }

    @Override
    public long count() {
        return movieRepository.count();
    }
}
