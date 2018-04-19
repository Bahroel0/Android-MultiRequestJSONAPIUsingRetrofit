package com.example.bahroel.retrofitmultirequest.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bahroel.retrofitmultirequest.Model.Movie;
import com.example.bahroel.retrofitmultirequest.R;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{
    private Context context;
    ArrayList<Movie> movieArrayList;

    public MovieAdapter(ArrayList<Movie> movieArrayList) {
        this.movieArrayList = movieArrayList;
    }

    public MovieAdapter(Context context) {
        this.context = context;
    }

    public MovieAdapter(Context context, ArrayList<Movie> movieArrayList) {
        this.context = context;
        this.movieArrayList = movieArrayList;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<Movie> getMovieArrayList() {
        return movieArrayList;
    }

    public void setMovieArrayList(ArrayList<Movie> movieArrayList) {
        this.movieArrayList = movieArrayList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(getMovieArrayList().get(position).getTitle());
        holder.imdb.setText(getMovieArrayList().get(position).getImdb_id());
        holder.budget.setText(Integer.toString(getMovieArrayList().get(position).getBudget()));
        holder.overview.setText(getMovieArrayList().get(position).getOverview());
    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView title, imdb, budget, overview;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tvTitle);
            imdb = (TextView) itemView.findViewById(R.id.tvImdb);
            budget = (TextView) itemView.findViewById(R.id.tvBudget);
            overview = (TextView) itemView.findViewById(R.id.tvOverview);
        }
    }
}
