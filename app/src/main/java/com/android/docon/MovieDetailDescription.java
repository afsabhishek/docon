package com.android.docon;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Abhishek.Kumar on 2/3/2017.
 */

public class MovieDetailDescription extends Activity {
    String title,description,posterPath;
    @InjectView(R.id.detail_title)TextView titleTextView;
    @InjectView(R.id.detail_description)TextView descriptionTextView;
    @InjectView(R.id.detail_poster)ImageView posterImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailedview);
        ButterKnife.inject(this);
        getIntentData();
        setupUI();
    }

    private void setupUI() {
        titleTextView.setText(title);
        descriptionTextView.setText(description);
        Picasso.with(this).load(posterPath).into(posterImageView);
    }

    private void getIntentData() {
        if(getIntent().hasExtra("title"))
            title = getIntent().getStringExtra("title");
        if(getIntent().hasExtra("poster"))
            posterPath = getIntent().getStringExtra("poster");
        if(getIntent().hasExtra("description"))
            description = getIntent().getStringExtra("description");

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }


}
