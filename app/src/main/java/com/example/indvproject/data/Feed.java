package com.example.indvproject.data;

import android.content.Context;

import com.example.indvproject.data.model.Movie;
import com.example.indvproject.data.model.Review;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Feed {

    public static String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }

    public static List<Movie> getData(Context context) {
        List<Movie> movieList = new ArrayList<>();

        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset(context));
            //Toast.makeText(this, "SAKSHI:" + obj, Toast.LENGTH_SHORT).show();
            //String name = obj.optString("name"
            JSONArray jsonArrayData = obj.getJSONArray("data");

            for (int i = 0; i < jsonArrayData.length(); i++) {
                JSONObject jsonObjectMovie = jsonArrayData.optJSONObject(i);
                JSONArray jsonArrayReview = jsonObjectMovie.getJSONArray("reviews");

                List<Review> reviewList = new ArrayList<>();

                for (int j = 0; j < jsonArrayReview.length(); j++) {
                    JSONObject jsonObjectReview = jsonArrayReview.optJSONObject(j);
                    Review review = new Review(
                            j,
                            jsonObjectReview.optString("author"),
                            jsonObjectReview.optInt("rating"),
                            jsonObjectReview.optString("reviewText")
                    );
                    reviewList.add(review);
                }

                //String cast = jsonObjectMovie.optJSONArray("cast").toString();

                Movie movie = new Movie(
                        i,
                        jsonObjectMovie.getString("name"),
                        jsonObjectMovie.optString("type"),
                        jsonObjectMovie.optString("year"),
                        jsonObjectMovie.optDouble("price"),
                        jsonObjectMovie.optString("imageurl"),
                        jsonObjectMovie.optString("cast"),
                        jsonObjectMovie.optString("director"),
                        jsonObjectMovie.optString("description"),
                        reviewList
                );

                movieList.add(movie);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return movieList;
    }
}
