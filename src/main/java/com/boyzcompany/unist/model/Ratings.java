package com.boyzcompany.unist.model;

import java.sql.Timestamp;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
 
@Document
public class Ratings {

    @Id
    private String rating;
    private Timestamp timeStamp;
  
    // UserID::MovieID::Rating::Timestamp
    User user = new User();
    Movie movie = new Movie();

    
    public String getUserId() {
        return user.getUserId();
    }

    public String getmovieId() {
        return movie.getMovieId();
    }
    public String getRating() {
        return rating;
    }

    public Timestamp getTimestamp() {
        return timeStamp ;
    }
    public void setRating(String rate) {
         rating = rate;
    }

    public void setTimeStamp() {
        timeStamp = new Timestamp(System.currentTimeMillis());
    }
}