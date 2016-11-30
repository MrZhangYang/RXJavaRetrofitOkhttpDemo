package com.suosi.zy.xueya.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.suosi.zy.xueya.R;
import com.suosi.zy.xueya.bean.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by G on 2016/11/24.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MViewHolder> {

    private Context mContext;
    private List<Movie> movies;

    public MovieAdapter(Context mContext, ArrayList<Movie> movies) {
        this.mContext = mContext;
        this.movies=movies;
    }

    @Override
    public MViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        MViewHolder mViewHolder=new MViewHolder(LayoutInflater.from(mContext).inflate(R.layout.movie_item,parent,false));

        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(MViewHolder holder, int position) {
        holder.tv_name.setText(movies.get(position).getTitle());
        holder.tv_time.setText(movies.get(position).getYear());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void setMovies(List<Movie> movies){
        this.movies.addAll(movies);
    }

    class MViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_name;
        private TextView tv_time;
        private TextView tv_director;

        public MViewHolder(View itemView) {
            super(itemView);
            tv_name= (TextView) itemView.findViewById(R.id.tv_name);
            tv_time= (TextView) itemView.findViewById(R.id.tv_time);
            tv_director= (TextView) itemView.findViewById(R.id.tv_director);
        }
    }
}
