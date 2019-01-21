package com.bawei.chewenfei.myapplication.view;

/**
 * author:author${车文飞}
 * data:2019/1/20
 */
public interface IView<T> {
    void onSuccessData(T data);
    void onError(T error);
}
