package com.example.indvproject.ui.home;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.indvproject.R;
import com.example.indvproject.core.BaseActivity;
import com.example.indvproject.data.Constant;
import com.example.indvproject.data.Feed;
import com.example.indvproject.data.db.AppDatabase;

public class HomeActivity extends BaseActivity {
    AppDatabase appDatabase;
    ConstraintLayout homeContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        appDatabase = AppDatabase.getInstance(this);

        if (appDatabase.movieDao().getAll().size() == 0) {
            appDatabase.movieDao().insertAll(Feed.getData(this));
        }

        homeContainer = findViewById(R.id.homeContainer);
        getSupportFragmentManager().beginTransaction().add(R.id.container, new HomeFragment()).commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Constant.PURCHASED.equalsIgnoreCase("PURCHASED")) {
            Constant.PURCHASED = "";
            showSnackBar(homeContainer, "Product will be delivered within 7 day.", "OK");
        }
    }

    private void loadFragment(Fragment fragment, int container) {
        // create a FragmentManager
        FragmentManager fm = getSupportFragmentManager();
        // create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        // replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit(); // save the changes
    }
}