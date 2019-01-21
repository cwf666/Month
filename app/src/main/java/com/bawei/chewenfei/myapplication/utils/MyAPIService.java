package com.bawei.chewenfei.myapplication.utils;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * author:author${车文飞}
 * data:2019/1/20
 */
public interface MyAPIService {
    @GET
    Observable<ResponseBody> get(@Url String url, @QueryMap HashMap<String,String>map);
    @POST
    Observable<ResponseBody> post(@Url String url, @QueryMap HashMap<String,String>map);

}
