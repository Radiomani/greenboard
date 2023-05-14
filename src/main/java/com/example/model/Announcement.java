package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Document(collection = "announcement")
@JsonInclude(JsonInclude.Include.NON_NULL) //include only non_null values
public class Announcement {

	@Id
	private String id;
	private int user_id;
	private int student_id;
	private int announcement;
	private int timestamp;

	public Announcement() {
    }

    public Announcement(int student_id, int announcement, int timestamp) {
		this.student_id = student_id;
		this.announcement = announcement;
		this.timestamp = timestamp;
    }

	public int getStudentId() { return this.student_id; }
	public int getAnnouncement() { return this.announcement; }
}
