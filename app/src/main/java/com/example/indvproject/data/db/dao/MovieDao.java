package com.example.indvproject.data.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.indvproject.data.model.Movie;

import java.util.List;

@Dao
public interface MovieDao {
    @Query("Select * from Movie")
    List<Movie> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Movie> movies);

    // below method is use to
    // add data to database.
    @Insert
    void insert(Movie model);

    // below method is use to update
    // the data in our database.
    @Update
    void update(Movie model);

    // below line is use to delete a
    // specific course in our database.
    @Delete
    void delete(Movie model);

    // on below line we are making query to
    // delete all courses from our database.
    @Query("DELETE FROM Movie")
    void deleteAllCourses();

}
