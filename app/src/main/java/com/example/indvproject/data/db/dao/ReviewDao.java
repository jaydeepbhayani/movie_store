package com.example.indvproject.data.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.indvproject.data.model.Review;

import java.util.List;

@Dao
public interface ReviewDao {
    //@Query("Select * from Review")
    List<Review> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Review> reviewList);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Review review);

    //@Query("DELETE FROM Review")
    void deleteAll();
}
