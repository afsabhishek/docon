package com.android.docon.adapter;

import com.android.docon.MovieDetailDescription;
import com.android.docon.R;
import com.android.docon.model.Movie;
import com.android.docon.util.Constant;
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Abhishek.Kumar on 2/2/2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private List<Movie> movies;
    private int rowLayout;
    private Context context;


    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.movies_layout) LinearLayout moviesLayout;
        @InjectView(R.id.title) TextView movieTitle;
        @InjectView(R.id.subtitle) TextView data;
//        @InjectView(R.id.description) TextView movieDescription;
        @InjectView(R.id.rating) TextView rating;
        @InjectView(R.id.poster) ImageView poster;


        public MovieViewHolder(View v) {
            super(v);
            ButterKnife.inject(this,v);

        }
    }

    public MoviesAdapter(List<Movie> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public MoviesAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);

        return new MovieViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        final String movieTitle = movies.get(position).getTitle();
        holder.movieTitle.setText(movieTitle);
        holder.data.setText(movies.get(position).getReleaseDate());
        final String posterPath = (Constant.BASE_URL_MOVIE+"w500"+movies.get(position).getPosterPath());
        Picasso.with(context).load(posterPath).into(holder.poster);
        final String movieDescription = movies.get(position).getOverview();
//        holder.movieDescription.setText(movieDescription);
        holder.rating.setText(movies.get(position).getVoteAverage().toString());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MovieDetailDescription.class);
                intent.putExtra("title", movieTitle);
                intent.putExtra("poster",posterPath);
                intent.putExtra("description",movieDescription);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
