package com.example.indvproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.indvproject.ui.home.HomeActivity;
import com.example.indvproject.ui.productlist.ProductActivity;

public class SplashActivity extends AppCompatActivity {

    long ANIMATION_DURATION = 2000;
    Animation slideLeftToRight;
    private Animation slideDownAnimation = null;
    LinearLayout logoContainer;
    TextView tvCredit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        logoContainer = findViewById(R.id.logoContainer);
        tvCredit = findViewById(R.id.tvCredit);

        slideDownAnimation = AnimationUtils.loadAnimation(
                this,
                R.anim.item_animation_fall_down
        );
        slideLeftToRight = AnimationUtils.loadAnimation(this, R.anim.item_animation_from_bottom);
        logoContainer.startAnimation(slideDownAnimation);
        tvCredit.startAnimation(slideLeftToRight);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                finish();
            }
        }, ANIMATION_DURATION);
    }
}