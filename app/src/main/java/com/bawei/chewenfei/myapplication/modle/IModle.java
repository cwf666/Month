package com.bawei.chewenfei.myapplication.modle;

import com.bawei.chewenfei.myapplication.callback.MyCallBack;

import java.util.HashMap;

/**
 * author:author${车文飞}
 * data:2019/1/20
 */
public interface IModle {
    void getGetData(String url, HashMap<String,String> map, Class clas, MyCallBack callBack);
    void getPostData(String url, HashMap<String,String> map, Class clas, MyCallBack callBack);
}
