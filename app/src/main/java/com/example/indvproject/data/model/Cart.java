package com.example.indvproject.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Cart {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int movieId;

    public Cart(int id, int movieId) {
        this.id = id;
        this.movieId = movieId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

}
