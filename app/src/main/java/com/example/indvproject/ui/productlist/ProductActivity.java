package com.example.indvproject.ui.productlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.example.indvproject.R;
import com.example.indvproject.core.BaseActivity;
import com.example.indvproject.data.db.AppDatabase;
import com.example.indvproject.data.model.Movie;
import com.example.indvproject.io.OnItemClickListener;
import com.example.indvproject.ui.detail.DetailActivity;

public class ProductActivity extends BaseActivity implements OnItemClickListener {

    RecyclerView rvProduct;
    ProductListAdapter productListAdapter;
    AppDatabase appDatabase;

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        setToolbar(R.id.toolbar, getString(R.string.movies));

        appDatabase = AppDatabase.getInstance(this);

        rvProduct = findViewById(R.id.rvProduct);

        setAdapter();

        productListAdapter.setData(this, appDatabase.movieDao().getAll(), this);
    }

    private void setAdapter() {
        productListAdapter = new ProductListAdapter();
        rvProduct.setLayoutManager(new GridLayoutManager(this, 2));
        rvProduct.setAdapter(productListAdapter);
        rvProduct.setHasFixedSize(true);
        rvProduct.setNestedScrollingEnabled(false);

        //animation
        //rvProduct.getAdapter().notifyDataSetChanged();
        rvProduct.scheduleLayoutAnimation();
    }

    @Override
    public void onItemClick(int position, Movie data) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("data", data);
        startActivity(intent);
    }
}