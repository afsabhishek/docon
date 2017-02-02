package com.android.docon;

import com.android.docon.model.Movie;

import java.util.List;

/**
 * Created by Abhishek.Kumar on 2/2/2017.
 */

public interface MainInteractor {
    interface onNetworkCallFinishListener{
        void onSuccess(List<Movie> movies);
        void onError(String msg);
    }

    void fetchDataFromNetwork(onNetworkCallFinishListener listener);
}
