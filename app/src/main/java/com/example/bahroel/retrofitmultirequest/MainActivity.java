package com.example.bahroel.retrofitmultirequest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.bahroel.retrofitmultirequest.API.ApiClient;
import com.example.bahroel.retrofitmultirequest.API.ApiInterface;
import com.example.bahroel.retrofitmultirequest.API.JSONResponse;
import com.example.bahroel.retrofitmultirequest.Adapter.MovieAdapter;
import com.example.bahroel.retrofitmultirequest.Model.Movie;
import com.example.bahroel.retrofitmultirequest.Model.MovieDetail;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private final String API_KEY = "7e8f60e325cd06e164799af1e317d7a7";
    private RecyclerView recyclerView;
    private ArrayList<Movie> movies;
    private MovieDetail movieDetail;
    private MovieAdapter movieAdapter;
    private int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Hasil Multi Request");


        recyclerView = (RecyclerView)findViewById(R.id.rvMovies);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        ApiInterface request = ApiClient.getClient().create(ApiInterface.class);
        Call<JSONResponse> call = request.getFirstRequest(API_KEY);
        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                JSONResponse jsonResponse = response.body();

                movies = new ArrayList<>(Arrays.asList(jsonResponse.getMovies()));

//                for(i=0; i< movies.size(); i++){
//                    ApiInterface request1 = ApiClient.getClient().create(ApiInterface.class);
//                    Call<JSONResponse> call1 = request1.getSecondRequest(movies.get(i).getId(),API_KEY);
//                    call.enqueue(new Callback<JSONResponse>() {
//                        @Override
//                        public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
//                            JSONResponse jsonResponse1 = response.body();
//                            movieDetail = new MovieDetail(jsonResponse1.getMovieDetail());
//                            movies.get(i).setImdb_id(movieDetail.getImdb_id());
//                            movies.get(i).setOverview(movieDetail.getOverview());
//                        }
//
//                        @Override
//                        public void onFailure(Call<JSONResponse> call, Throwable t) {
//
//                        }
//                    });
//                }

                movieAdapter = new MovieAdapter(movies);
                recyclerView.setAdapter(movieAdapter);


            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {

            }
        });

    }
}
