package com.boyzcompany.unist.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employee {

    @Id
    private String employeeId;
    private String name;
    private String role;

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public void setEmployeeId(String id) {
        employeeId = id;
    }
}