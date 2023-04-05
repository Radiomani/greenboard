package com.boyzcompany.unist.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

    @Id
    private String userId;
    private String gender;
    private String age;
    private String occupation;
    private String zip_code;

    public String getUserId() {
        return userId;
    }

    public String getGender() {
        return gender;
    }
    public String getAge() {
        return age;
    }

    public String getOccpation() {
        return occupation;
    }
    public String getZipCode() {
        return zip_code;
    }

    public void setUserId(String id) {
        userId = id;
    }
}