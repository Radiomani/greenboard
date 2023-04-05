package com.boyzcompany.unist.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Movie {

    @Id
    private String movieId;
    private String name;
    private List <String> genre;

    public String getMovieId() {
        return movieId;
    }

    public String getName() {
        return name;
    }

    public List<String> getGenres() {
        return genre;
    }

    public void setMovieId(String id) {
        movieId = id;
    }
}