package com.android.docon.network;

import com.android.docon.model.MovieDetailsData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Abhishek.Kumar on 2/2/2017.
 */

public interface ServerCommunicationInterface {

        @GET("movie/top_rated")
        Call<MovieDetailsData> getTopRatedMovies(@Query("api_key") String apiKey);

}
