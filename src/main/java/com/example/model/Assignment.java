package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Document(collection = "assignment")
@JsonInclude(JsonInclude.Include.NON_NULL) //include only non_null values
public class Assignment {

	@Id
	private String id;
	private int assignment_id;
	private String gender;
	private int age;
	private int occupation;
	private String zip_code;

	// Assignment_id,gender,age,occupation,zip_code

	public Assignment() {
    }

	// public Assignment(String gender, int age, int occupation, String zip_code) {
    //     this.gender = gender;
	// 	this.age = age;
	// 	this.occupation = occupation;
	// 	this.zip_code = zip_code;
    // }

    // public Assignment(int Assignment_id, String gender, int age, int occupation, String zip_code) {
	// 	this.Assignment_id = Assignment_id;
    //     this.gender = gender;
	// 	this.age = age;
	// 	this.occupation = occupation;
	// 	this.zip_code = zip_code;
    // }

	public int getAssignment_id() { return this.assignment_id; }
	public String getGender() { return this.gender; }
	public int getAge() { return this.age; }
	public int getOccupation() { return this.occupation; }
	public String getZip_code() { return this.zip_code; }

	public void setAssignmentId(int id) { this.assignment_id = id; }
}
