package com.bawei.chewenfei.myapplication.presenter;

import java.util.HashMap;

/**
 * author:author${车文飞}
 * data:2019/1/20
 */
public interface IPresenter {
    void requesGet(String url, HashMap<String,String> map,Class clas);
    void requesPost(String url, HashMap<String,String> map,Class clas);
}
