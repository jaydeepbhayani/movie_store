package com.example.indvproject.data.db.typeconverter;

import androidx.room.TypeConverter;

import com.example.indvproject.data.model.Review;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class ReviewTypeConverter {
    private Gson gson = new Gson();

    @TypeConverter
    public List<Review> storedStringToTranslations(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Review>>(){}.getType();
        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public String sourceToStoredString(List<Review>  myObjects) {
        Gson gson = new Gson();
        return gson.toJson(myObjects);
    }
}
