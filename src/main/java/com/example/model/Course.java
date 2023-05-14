package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Document(collection = "course")
@JsonInclude(JsonInclude.Include.NON_NULL) //include only non_null values
public class Course {

	@Id
	private String id;
	private int course_id;
	private String course_name;
	private String genre;

	public Course() {
    }

	public Course(String course_name, String genre) {
		this.course_name = course_name;
		this.genre = genre;
	}

    public Course(int course_id, String course_name, String genre) {
        this.course_id = course_id;
		this.course_name = course_name;
		this.genre = genre;
    }
}
