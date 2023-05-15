package com.example.model;

import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

import org.hibernate.type.DateType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Document(collection = "tasks")
@JsonInclude(JsonInclude.Include.NON_NULL) //include only non_null values
public class Task{

	@Id
    private String task_name;
	private String description;
    DateTimeFormatter deadline = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private String priority;


	public Task() {
    }

	public String getTask_name() { return this.task_name; }
	public String getDescription() { return this.description; }
	public DateTimeFormatter getDeadline() { return this.deadline; }
	public void setPriority (String prior) { this.priority= prior; }
}
