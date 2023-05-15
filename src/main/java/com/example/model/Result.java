package com.example.model;

import javax.swing.text.StyledEditorKit.BoldAction;

public class Result<T> {
    private boolean is_safe;
    private boolean is_student;
    private boolean is_announcement;
    private boolean is_assignment;
    private boolean is_course;
    private boolean is_task;
    private boolean course_access;
    private boolean task_access;

    private T result;

    public Result() {
        this.is_student = true;
        this.is_announcement = true;
        this.is_assignment = true;
        this.is_course = true;
        this.is_task = true;
        this.course_access = true;
        this.task_access = true;
        this.is_safe = true;
    }

    public Result(T result) {
        this.result = result;
        this.is_student = true;
        this.is_announcement = true;
        this.is_assignment = true;
        this.is_course = true;
        this.is_task = true;
        this.course_access = true;
        this.task_access = true;
        this.is_safe = true;
    }
    
    public boolean isStudent() { return this.is_student; }
    public boolean isAnnouncement() { return this.is_announcement; }
    public boolean isAssignment() { return this.is_assignment; }
    public boolean isCourse() { return this.is_course; }
    public boolean isTask() { return this.is_task; }
    public boolean courseAccess() { return this.course_access; }
    public boolean taksAccess() { return this.task_access; }
    public boolean isSafe() { return this.is_safe; }
    public void notStudent() {
        this.is_student = false;
        this.is_safe = false;
    }
    public void notAnnouncement() {
        this.is_announcement = false;
        this.is_safe = false;
    }
    public void notAssignment() {
        this.is_assignment = false;
        this.is_safe = false;
    }
    public void notCourse() {
        this.is_course = false;
        this.is_safe = false;
    }
    public void notTask() {
        this.is_task = false;
        this.is_safe = false;
    }
    public void noCourseAccess() {
        this.course_access = false;
        this.is_safe = false;
    }
    public void noTaskAccess() {
        this.task_access = false;
        this.is_safe = false;
    }

    public T getResult() { return this.result;}
}
