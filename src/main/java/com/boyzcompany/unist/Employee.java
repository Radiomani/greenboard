package com.boyzcompany.unist;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employee {

    @Id
    private String employeeId;
    private String name;
    private Date creationDate = new Date();
    private Map<String, String> employeeSettings = new HashMap<>();

    public String getemployeeId() {
        return employeeId;
    }

    public void setemployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Map<String, String> getemployeeSettings() {
        return employeeSettings;
    }

    public void setemployeeSettings(Map<String, String> employeeSettings) {
        this.employeeSettings = employeeSettings;
    }
}