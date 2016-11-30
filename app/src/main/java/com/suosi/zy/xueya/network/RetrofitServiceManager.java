package com.suosi.zy.xueya.network;

import com.suosi.zy.xueya.utils.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by G on 2016/11/24.
 */

public class RetrofitServiceManager {

    private Retrofit mRetrofit;

    private RetrofitServiceManager(){
        //okhttp
        OkHttpClient.Builder builder=new OkHttpClient.Builder();
        builder.connectTimeout(Constants.DEFAULT_TIME_OUT, TimeUnit.SECONDS);//连接超时时间
        builder.readTimeout(Constants.DEFAULT_READ_TIME_OUT,TimeUnit.SECONDS);//读操作超时时间
        builder.writeTimeout(Constants.DEFAULT_READ_TIME_OUT,TimeUnit.SECONDS);//写操作超时时间
        //添加公共参数拦截器
        HttpCommonInterceptor commonInterceptor=new HttpCommonInterceptor.Builder()
                .addHeaderParams("platform","android")
                .addHeaderParams("userToken","1234343434dfdfd3434")
                .addHeaderParams("userId","123445")
                .build();
        builder.addInterceptor(commonInterceptor);

        // 创建Retrofit
        mRetrofit=new Retrofit.Builder().
                client(builder.build()).
                addCallAdapterFactory(RxJavaCallAdapterFactory.create()).
                addConverterFactory(GsonConverterFactory.create()).
                baseUrl(Constants.COMMONURL).
                build();

    }

    private static class SingletonHolder{
        private static final RetrofitServiceManager INSTANCE=new RetrofitServiceManager();
    }

    /**
     * 获取RetrofitServiceManager
     * @return
     */
    public static RetrofitServiceManager getInstance(){
        return SingletonHolder.INSTANCE;
    }


    /**
     * 获取对应的service
     * @param service
     * @param <T>
     * @return
     */
    public <T> T create(Class<T> service){
        return mRetrofit.create(service);
    }
}
