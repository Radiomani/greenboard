package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.querydsl.binding.QuerydslBindings.PathBinder;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Document(collection = "courses")
@JsonInclude(JsonInclude.Include.NON_NULL) //include only non_null values
public class Course {

	@Id
	private String id;
	private String course_id;
	private String course_name;
	private String professor_name;

	public Course() {

	}

	public Course(String course_id, String course_name, String professor_name) {
		this.course_id = course_id;
		this.course_name = course_name;
		this.professor_name = professor_name;
	}

	String getCourseID() { return course_id; }
	String getCourseName() { return course_name; }
	String getProfessorName() { return professor_name; }
	void setCourseID(String course_id) { this.course_id = course_id; }
	void setCourseName(String course_name) { this.course_name = course_name; }
	void setProfessorName(String professor_name) { this.professor_name = professor_name; } 
}
