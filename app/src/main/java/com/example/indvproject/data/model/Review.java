package com.example.indvproject.data.model;

import androidx.room.Entity;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Review implements Serializable {
    private int id;
    private String author;
    private int rating;
    private String description;
    //private String createdOn = String.valueOf(new Date());

    public Review(int id, String author, int rating, String description/*, String createdOn*/) {
        this.id = id;
        this.author = author;
        this.rating = rating;
        this.description = description;
        //this.createdOn = createdOn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }*/

}
