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
	private int student_id;
	private String email;
	private String name;

	// Student_id,gender,age,occupation,zip_code

	public Student() {
    }

	// public Student(String gender, int age, int occupation, String zip_code) {
    //     this.gender = gender;
	// 	this.age = age;
	// 	this.occupation = occupation;
	// 	this.zip_code = zip_code;
    // }

    // public Student(int Student_id, String gender, int age, int occupation, String zip_code) {
	// 	this.Student_id = Student_id;
    //     this.gender = gender;
	// 	this.age = age;
	// 	this.occupation = occupation;
	// 	this.zip_code = zip_code;
    // }

	public int getStudent_id() { return this.student_id; }
	public String getEmail() { return this.email; }
	public String getName() { return this.name; }

	public void setStudentId(int id) { this.student_id = id; }
}
