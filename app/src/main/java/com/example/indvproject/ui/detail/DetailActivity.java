package com.example.indvproject.ui.detail;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.indvproject.R;
import com.example.indvproject.core.BaseActivity;
import com.example.indvproject.data.Constant;
import com.example.indvproject.data.model.Movie;
import com.example.indvproject.data.model.Review;

import java.util.List;

public class DetailActivity extends BaseActivity {

    TextView tvTitle;
    TextView tvYear;
    TextView tvDescription;
    TextView tvType;
    TextView tvCast;
    TextView tvDirector;
    ImageView ivBackground;
    TextView tvAvgRating;
    TextView tvPrice;
    Button btnBuyNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setToolbar(R.id.toolbar, getString(R.string.detail));

        tvTitle = findViewById(R.id.tvTitle);
        tvYear = findViewById(R.id.tvYear);
        tvPrice = findViewById(R.id.tvPrice);
        tvDescription = findViewById(R.id.tvDescription);
        ivBackground = findViewById(R.id.ivBackground);
        tvAvgRating = findViewById(R.id.tvAvgRating);

        tvType = findViewById(R.id.tvType);
        tvCast = findViewById(R.id.tvCast);
        tvDirector = findViewById(R.id.tvDirector);
        btnBuyNow = findViewById(R.id.btnBuyNow);

        Movie data = (Movie) getIntent().getSerializableExtra(Constant.DATA);

        Glide.with(this)
                .load(data.getImageUrl())
                .error(R.drawable.ic_round_mood_bad_24)
                .into(ivBackground);

        tvTitle.setText(data.getName());
        tvDescription.setText(data.getDescription());
        tvYear.setText(data.getYear());
        tvPrice.setText(data.getPrice() + " CAD");
        tvAvgRating.setText(findAvgRating(data.getReviews())+" / 10");
        tvType.setText(data.getType());
        tvCast.setText(data.getCast());
        tvDirector.setText(data.getDirector());
        tvDescription.setText(data.getDescription());

        btnBuyNow.setOnClickListener(view -> {
            DetailBottomSheetDialog bottomSheet = new DetailBottomSheetDialog();
            bottomSheet.show(getSupportFragmentManager(),
                    "ModalBottomSheet");
        });

    }

    private String findAvgRating(List<Review> reviewList) {
        if (reviewList != null && reviewList.size() > 0) {
            int avgRating = 0;
            int sum = 0;

            for (Review review : reviewList) {
                sum += review.getRating();
            }
            avgRating = sum / reviewList.size();

            return String.valueOf(avgRating);
        } else return " -";
    }
}