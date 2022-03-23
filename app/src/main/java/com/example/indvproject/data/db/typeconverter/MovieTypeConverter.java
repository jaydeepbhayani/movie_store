package com.example.indvproject.data.db.typeconverter;

import androidx.room.TypeConverter;

import com.example.indvproject.data.model.Movie;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class MovieTypeConverter {
    private Gson gson = new Gson();

    @TypeConverter
    private List<Movie> storedStringToMovie(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        //Type listType = new TypeToken<List<Movie>>(){}.getType();

        return gson.fromJson(data, new TypeToken<List<Movie>>(){}.getType());

    }

    @TypeConverter
    private String movieToStoredString(List<Movie> myObjects) {
        Gson gson = new Gson();
        return gson.toJson(myObjects);
    }
}
