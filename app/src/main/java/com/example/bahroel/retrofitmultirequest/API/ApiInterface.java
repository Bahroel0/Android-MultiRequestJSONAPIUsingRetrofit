package com.example.bahroel.retrofitmultirequest.API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("movie/top_rated")
    Call<JSONResponse> getFirstRequest(@Query("api_key") String apiKey);
    @GET("movie/{id}")
    Call<JSONResponse> getSecondRequest(@Path("id") int id, @Query("api_key") String apiKey);
}
