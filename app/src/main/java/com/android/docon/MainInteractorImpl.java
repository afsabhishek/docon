package com.android.docon;

import android.util.Log;

import com.android.docon.model.Movie;
import com.android.docon.model.MovieDetailsData;
import com.android.docon.network.ServerCommunication;
import com.android.docon.network.ServerCommunicationInterface;
import com.android.docon.util.Constant;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by Abhishek.Kumar on 2/2/2017.
 */

public class MainInteractorImpl implements MainInteractor{
    @Override
    public void fetchDataFromNetwork(final onNetworkCallFinishListener listener) {
        ServerCommunicationInterface mServerCommunication = ServerCommunication.getClient().create(ServerCommunicationInterface.class);

        Call<MovieDetailsData> call = mServerCommunication.getTopRatedMovies(Constant.API_KEY);

        call.enqueue(new Callback<MovieDetailsData>() {
            @Override
            public void onResponse(Call<MovieDetailsData>call, Response<MovieDetailsData> response) {
                List<Movie> movies = response.body().getResults();
                Log.d(TAG, "Number of movies received: " + movies.size());
                listener.onSuccess(movies);
            }

            @Override
            public void onFailure(Call<MovieDetailsData>call, Throwable t) {

                Log.e(TAG, t.toString());
                listener.onError("Server not Connected .Try again in sometime");
            }
        });
    }
}
