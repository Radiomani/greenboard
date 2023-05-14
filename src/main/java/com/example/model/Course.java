package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Document(collection = "movie")
@JsonInclude(JsonInclude.Include.NON_NULL) //include only non_null values
public class Course {

	@Id
	private String id;
	private int movie_id;
	private String movie_name;
	private String genre;

	public Course() {
    }

	public Course(String movie_name, String genre) {
		this.movie_name = movie_name;
		this.genre = genre;
	}

    public Course(int movie_id, String movie_name, String genre) {
        this.movie_id = movie_id;
		this.movie_name = movie_name;
		this.genre = genre;
    }
}
