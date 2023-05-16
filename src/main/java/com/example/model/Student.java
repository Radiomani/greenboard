package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Document(collection = "students")
@JsonInclude(JsonInclude.Include.NON_NULL) //include only non_null values
public class Student {

	@Id
	private String id;
	private String student_id;
	private String name;
	private String email;
	private List<String> courses_taken;

	private List<String> toListFuck(String courses_list) {
	String[] parts = courses_list.split(" ");
	List<String> partsList = Arrays.asList(parts);
		return partsList;
	}

	public Student(String student_id, String name, String email, String courses_list) {
		this.student_id = student_id;
		this.name = name;
		this.email = email;
		this.courses_taken = toListFuck(courses_list);
    }

	public String getStudentID() { return this.student_id; }
	public String getEmail() { return this.email; }
	public String getName() { return this.name; }
	public List<String> getCoursesTaken() { return this.courses_taken; }
	public void setStudentID(String student_id) { this.student_id = student_id; }
	public void setEmail(String email) { this.email = email; }
	public void setName(String name) { this.name = name; }
	public void setCoursesTaken(List<String> courses_taken) {this.courses_taken = courses_taken; }
}
