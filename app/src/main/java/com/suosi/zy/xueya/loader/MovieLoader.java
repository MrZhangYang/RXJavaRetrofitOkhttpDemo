package com.suosi.zy.xueya.loader;

import com.suosi.zy.xueya.bean.Movie;
import com.suosi.zy.xueya.bean.MovieSubject;
import com.suosi.zy.xueya.interfaces.MovieService;
import com.suosi.zy.xueya.network.RetrofitServiceManager;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by G on 2016/11/24.
 */

public class MovieLoader extends ObjectLoader {

    private MovieService mMovieService;
    public MovieLoader(){
        mMovieService= RetrofitServiceManager.getInstance().create(MovieService.class);
    }

    public Observable<List<Movie>> getMovie(int start,int count){


        return observe(mMovieService.getTop250(start,count))
                .map(new Func1<MovieSubject,List<Movie>>(){

                    @Override
                    public List<Movie> call(MovieSubject movieSubject) {
                        return movieSubject.subjects;
                    }
                });
//        return observe(mMovieService.getTop250(start,count))
//                .map(new PayLoad<BaseResponse<List<Movie>>>());
    }

    public Observable<String> getWeatherList(String cityId,String key){
        return observe((Observable<String>) mMovieService.getWeather(cityId,key))
                .map(new Func1<String,String>(){
                    @Override
                    public String call(String s) {
                        return s;
                    }
                });
    }
}
