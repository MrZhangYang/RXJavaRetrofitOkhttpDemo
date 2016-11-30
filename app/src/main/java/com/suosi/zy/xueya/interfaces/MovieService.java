package com.suosi.zy.xueya.interfaces;

import com.suosi.zy.xueya.bean.MovieSubject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by G on 2016/11/24.
 */

public interface MovieService {

    //获取豆瓣top250榜单
    @GET("top250")
    Observable<MovieSubject> getTop250(@Query("start") int start, @Query("count") int count);

    @FormUrlEncoded
    @POST("/x3/weather")
    Call<String> getWeather(@Field("cityId") String cityId,@Field("key") String key);
}
