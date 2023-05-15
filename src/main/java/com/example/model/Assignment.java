package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Document(collection = "assignments")
@JsonInclude(JsonInclude.Include.NON_NULL) //include only non_null values
public class Assignment {

	@Id
	private String id;
	private String assignment_id;
	private int deadline;
	private String course_id;
	private String course_name;
	// Assignment_id,gender,age,occupation,zip_code

	public Assignment() {
    }

	public String getAssignmentID() { return this.assignment_id; }
	public int getDeadline() { return this.deadline; }
	public String getCourseID() { return this.course_id; }
	public String getCourseName() { return this.course_name; }

	public void setAssignmentId(String id) { this.assignment_id = id; }
	public void setDeadline(int deadline) { this.deadline = deadline; }
	public void setCourseID(String course_id) { this.course_id = course_id; }
	public void setCourseName(String course_id) { this.course_name = course_id; }
}
