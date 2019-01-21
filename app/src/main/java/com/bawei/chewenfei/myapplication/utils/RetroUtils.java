package com.bawei.chewenfei.myapplication.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * author:author${车文飞}
 * data:2019/1/20
 */
public class RetroUtils {

    private final MyAPIService myAPIService;

    public RetroUtils() {
        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .connectTimeout(20,TimeUnit.SECONDS)
                .readTimeout(20,TimeUnit.SECONDS)
                .writeTimeout(20,TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();
        Retrofit retrofit=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Contacts.BASE_URL)
                .client(okHttpClient)
                .build();
        myAPIService = retrofit.create(MyAPIService.class);
    }
    private static class RetroHolder{
        private static final RetroUtils retroUtils=new RetroUtils();
    }
    public static RetroUtils getInsetence(){
        return RetroHolder.retroUtils;
    }
    public void getGetStr(String url, HashMap<String,String>map, final HttpListener httpListener){
        Observer<ResponseBody> observer=new Observer<ResponseBody>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                if(httpListener!=null){
                    httpListener.onError(e.getMessage());
                }

            }

            @Override
            public void onNext(ResponseBody responseBody) {
                if(httpListener!=null){
                    try {
                        httpListener.onSuccess(responseBody.string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        myAPIService.get(url,map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }
    public void getPostStr(String url, HashMap<String,String>map, final HttpListener httpListener){
        Observer<ResponseBody> observer=new Observer<ResponseBody>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                if(httpListener!=null){
                    httpListener.onError(e.getMessage());
                }

            }

            @Override
            public void onNext(ResponseBody responseBody) {
                if(httpListener!=null){
                    try {
                        httpListener.onSuccess(responseBody.string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        myAPIService.post(url,map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }
    public interface HttpListener{
        void onSuccess(String jsonStr);
        void onError(String error);

    }
}
