package com.suosi.zy.xueya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.suosi.zy.xueya.adapter.MovieAdapter;
import com.suosi.zy.xueya.bean.Movie;
import com.suosi.zy.xueya.loader.MovieLoader;
import com.suosi.zy.xueya.network.Fault;

import java.util.ArrayList;
import java.util.List;

import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {

    private MovieLoader movieLoader;
    private RecyclerView mRecyclerView;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        getMovieList();

    }

    private void initView() {
        mRecyclerView= (RecyclerView) findViewById(R.id.rxjava_retrofit_okhttp_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        movies = new ArrayList<>();
        adapter = new MovieAdapter(this, movies);
        mRecyclerView.setAdapter(adapter);
    }

    public void getMovieList() {

        movieLoader=new MovieLoader();

        movieLoader.getMovie(0,20).subscribe(new Action1<List<Movie>>() {
            @Override
            public void call(List<Movie> movies) {
                adapter.setMovies(movies);
                adapter.notifyDataSetChanged();
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Log.e("TAG","error message:"+throwable.getMessage());
                if(throwable instanceof Fault){
                    Fault fault = (Fault) throwable;
                    if(fault.getErrorCode() == 404){
                        //错误处理
                    }else if(fault.getErrorCode() == 500){
                        //错误处理
                    }else if(fault.getErrorCode() == 501){
                        //错误处理
                    }
                }
            }
        });
    }
}
