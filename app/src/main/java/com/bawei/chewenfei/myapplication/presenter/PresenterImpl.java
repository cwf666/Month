package com.bawei.chewenfei.myapplication.presenter;

import com.bawei.chewenfei.myapplication.callback.MyCallBack;
import com.bawei.chewenfei.myapplication.modle.ModleImpl;
import com.bawei.chewenfei.myapplication.view.IView;

import java.util.HashMap;

/**
 * author:author${车文飞}
 * data:2019/1/20
 */
public class PresenterImpl implements IPresenter{
    private IView iView;
    private ModleImpl modle;

    public PresenterImpl(IView iView) {
        this.iView = iView;
        modle=new ModleImpl();
    }

    @Override
    public void requesGet(String url, HashMap<String, String> map, Class clas) {
        modle.getGetData(url, map, clas, new MyCallBack() {
            @Override
            public void setData(Object data) {
                if(iView!=null){
                    iView.onSuccessData(data);
                }
            }

            @Override
            public void setError(Object error) {
                if(iView!=null){
                    iView.onError(error);
                }

            }
        });

    }

    @Override
    public void requesPost(String url, HashMap<String, String> map, Class clas) {
        modle.getPostData(url, map, clas, new MyCallBack() {
            @Override
            public void setData(Object data) {
                if(iView!=null){
                    iView.onSuccessData(data);
                }
            }

            @Override
            public void setError(Object error) {
                if(iView!=null){
                    iView.onError(error);
                }

            }
        });

    }
}
