package com.example.bahroel.retrofitmultirequest.API;

import com.example.bahroel.retrofitmultirequest.Model.Movie;
import com.example.bahroel.retrofitmultirequest.Model.MovieDetail;
import com.google.gson.annotations.SerializedName;

public class JSONResponse {
    @SerializedName("result")
    private Movie[] movies;

    public MovieDetail getMovieDetail() {
        return movieDetail;
    }

    private MovieDetail movieDetail;

    public Movie[] getMovies() {
        return movies;
    }
}
