package com.example.indvproject.data.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.indvproject.data.model.Review;

import java.util.List;

@Dao
public interface CartDao {
    @Query("Select * from Cart")
    List<Integer> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(int movieId);

    @Query("DELETE FROM Cart")
    void deleteAll();
}
