package com.example.model;

// import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class
// import com.example.utils.TimeFormat;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Document(collection = "tasks")
@JsonInclude(JsonInclude.Include.NON_NULL) //include only non_null values
public class Task{

	@Id
	private String task_id;
    private String task_name;
	private String description;
    private int deadline;
	private String priority;


	public Task() {
    }

	public String getTaskName() { return this.task_name; }
	public String getDescription() { return this.description; }
	public int getDeadline() { return this.deadline; }
	public String getPriority() { return this.priority; }
	public void setTaskName(String task_name) { this.task_name = task_name; }
	public void setDescription(String description) { this.description = description; }
	public void setDeadline(int deadline) { this.deadline = deadline; }
	public void setPriority(String priority) { this.priority = priority; }
}
