package com.bawei.chewenfei.myapplication.callback;

/**
 * author:author${车文飞}
 * data:2019/1/20
 */
public interface MyCallBack<T> {
    void setData(T data);
    void setError(T error);
}
