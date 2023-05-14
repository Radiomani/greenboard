package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Document(collection = "student")
@JsonInclude(JsonInclude.Include.NON_NULL) //include only non_null values
public class Student {

	@Id
	private String id;
	private String student_id;
	private String email;
	private String name;

	// Student_id,gender,age,occupation,zip_code

	public Student() {
    }

	public String getStudent_id() { return this.student_id; }
	public String getEmail() { return this.email; }
	public String getName() { return this.name; }
	public void setStudentId(String id) { this.student_id = id; }
}
