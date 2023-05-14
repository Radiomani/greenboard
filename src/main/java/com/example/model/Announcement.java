package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Document(collection = "announcements")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Announcement {

	@Id
	private String id;
	private String course_id;
	private String course_name;
	private String ann_header;
	private int timestamp;

	public Announcement() {
    }

    public Announcement(String course_id, String course_name,
						String ann_header, int timestamp) {
		this.course_id = course_id;
		this.course_name = course_name;
		this.ann_header = ann_header;
		this.timestamp = timestamp;
    }

	public String getCourseID() { return this.course_id; }
	public String getCourseName() { return this.course_name; }
	public String getAnnHeader() { return this.ann_header; }
	public int getTimeStamp() { return this.timestamp; }
	public void setCourseID(String course_id) { this.course_id = course_id; }
	public void setCourseName(String course_name) { this.course_name = course_name; }
	public void setAnnHeader(String ann_header) { this.ann_header = ann_header; }
	public void setTimeStamp(int timestamp) { this.timestamp = timestamp; }}
