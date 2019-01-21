package com.bawei.chewenfei.myapplication.modle;

import com.bawei.chewenfei.myapplication.callback.MyCallBack;
import com.bawei.chewenfei.myapplication.utils.RetroUtils;
import com.google.gson.Gson;

import java.util.HashMap;

/**
 * author:author${车文飞}
 * data:2019/1/20
 */
public class ModleImpl implements IModle{

    @Override
    public void getGetData(String url, HashMap<String, String> map, final Class clas, final MyCallBack callBack) {
        RetroUtils.getInsetence().getGetStr(url, map, new RetroUtils.HttpListener() {
            @Override
            public void onSuccess(String jsonStr) {
                Gson gson=new Gson();
                Object o = gson.fromJson(jsonStr, clas);
                if(callBack!=null){
                    callBack.setData(o);
                }
            }

            @Override
            public void onError(String error) {
                if(callBack!=null){
                    callBack.setError(error);
                }

            }
        });
    }

    @Override
    public void getPostData(String url, HashMap<String, String> map, final Class clas, final MyCallBack callBack) {
        RetroUtils.getInsetence().getPostStr(url, map, new RetroUtils.HttpListener() {
            @Override
            public void onSuccess(String jsonStr) {
                Gson gson=new Gson();
                Object o = gson.fromJson(jsonStr, clas);
                if(callBack!=null){
                    callBack.setData(o);
                }
            }

            @Override
            public void onError(String error) {
                if(callBack!=null){
                    callBack.setError(error);
                }

            }
        });

    }
}
