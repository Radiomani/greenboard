package com.example.repositories;

import com.example.model.Course;


public interface CourseRepository {
    public Course findMovieByMovieID(int movie_id);
    public Course findMovieByName(String movie_name);
    public long count();
}
