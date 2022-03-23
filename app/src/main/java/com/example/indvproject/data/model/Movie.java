package com.example.indvproject.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.indvproject.data.db.typeconverter.ReviewTypeConverter;

import java.io.Serializable;
import java.util.List;

@Entity
public class Movie implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String type;
    private String year;
    private double price;
    private String imageUrl;
    private String cast;
    private String director;
    private String description;

    @TypeConverters(ReviewTypeConverter.class)
    private List<Review> reviews;

    public Movie(int id, String name, String type, String year, double price, String imageUrl, String cast, String director, String description, List<Review> reviews) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.year = year;
        this.price = price;
        this.imageUrl = imageUrl;
        this.cast = cast;
        this.director = director;
        this.description = description;
        this.reviews = reviews;
    }

    /*public Movie(String name, String type, String year, String imageUrl, String cast, String director, String description, List<Review> reviews) {
        this.name = name;
        this.type = type;
        this.year = year;
        this.imageUrl = imageUrl;
        this.cast = cast;
        this.director = director;
        this.description = description;
        this.reviews = reviews;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

}

