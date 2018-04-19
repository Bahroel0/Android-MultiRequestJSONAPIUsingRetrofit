package com.example.bahroel.retrofitmultirequest.Model;

import com.google.gson.annotations.SerializedName;

public class MovieDetail {
    @SerializedName("imdb_id")
    private String imdb_id;
    @SerializedName("overview")
    private String overview;

    public MovieDetail(MovieDetail movieDetail){
        this.imdb_id = movieDetail.imdb_id;
        this.overview = movieDetail.overview;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
