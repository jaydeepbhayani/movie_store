package com.example.indvproject.ui.productlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.indvproject.R;
import com.example.indvproject.data.model.Movie;
import com.example.indvproject.io.OnItemClickListener;

import org.w3c.dom.Text;

import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductViewHolder> {
    List<Movie> movieList;
    Context context;

    private OnItemClickListener onItemClickListener;

    void setData(Context context, List<Movie> movieList, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.movieList = movieList;
        this.onItemClickListener = onItemClickListener;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Movie data = movieList.get(position);

        holder.tvTitle.setText(data.getName());
        holder.tvYear.setText(data.getYear());

        Glide.with(context)
                .load(data.getImageUrl())
                .error(R.drawable.ic_round_mood_bad_24)
                .into(holder.ivBackground);

        holder.ivBackground.setOnClickListener(view -> {
            onItemClickListener.onItemClick(position, data);
        });
        /*Picasso.get().load(data.getImageUrl())
                .placeholder(R.drawable.progress_animation)
                .resize(50, 50)
                //.centerCrop()
                .into(holder.ivBackground, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });*/
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView ivBackground;
        TextView tvTitle;
        TextView tvYear;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            ivBackground = itemView.findViewById(R.id.ivBackground);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvYear = itemView.findViewById(R.id.tvYear);

        }
    }
}
