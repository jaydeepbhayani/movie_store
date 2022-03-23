package com.example.indvproject.data.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.indvproject.data.db.dao.MovieDao;
import com.example.indvproject.data.db.dao.ReviewDao;
import com.example.indvproject.data.model.Cart;
import com.example.indvproject.data.model.Movie;

@Database(
        entities = {Movie.class , Cart.class },
        version = 2,
        exportSchema = false
)
public abstract class AppDatabase extends RoomDatabase {

    public abstract MovieDao movieDao();
    //abstract ReviewDao reviewDao();

    private static String DB_NAME = "db_moviestore";
    private static AppDatabase appDb = null;

    public static AppDatabase getInstance(Context context) {
        if (appDb == null) {
            appDb = buildDatabaseInstance(context);
        }
        return appDb;
    }

    private static AppDatabase buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(
                context,
                AppDatabase.class,
                DB_NAME
            ).allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }
}
