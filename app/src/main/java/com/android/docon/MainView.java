package com.android.docon;

import com.android.docon.model.Movie;

import java.util.List;

/**
 * Created by Abhishek.Kumar on 2/2/2017.
 */

public interface MainView {
    void showProgressBar();
    void hideProgressBar();
    void setDataToList(List<Movie> movies);
    void showError(String msg);
}
