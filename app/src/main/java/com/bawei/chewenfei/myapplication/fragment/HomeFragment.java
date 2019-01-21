package com.bawei.chewenfei.myapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.chewenfei.myapplication.R;
import com.bawei.chewenfei.myapplication.adapter.FenLeiAdapter;
import com.bawei.chewenfei.myapplication.adapter.MiaoShaAdapter;
import com.bawei.chewenfei.myapplication.bean.HomeData;
import com.bawei.chewenfei.myapplication.presenter.PresenterImpl;
import com.bawei.chewenfei.myapplication.utils.Contacts;
import com.bawei.chewenfei.myapplication.view.IView;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements IView {


    @BindView(R.id.fly_banner)
    FlyBanner flyBanner;
    @BindView(R.id.fenlei_recy)
    RecyclerView fenleiRecy;
    @BindView(R.id.miaosha_recy)
    RecyclerView miaoshaRecy;
    Unbinder unbinder;
    private PresenterImpl presenter;
    List<HomeData.DataBean.FenleiBean> fenleiList=new ArrayList<>();
    private FenLeiAdapter fenLeiAdapter;
    List<HomeData.DataBean.MiaoshaBean.ListBean> miaoshaList=new ArrayList<>();
    private MiaoShaAdapter miaoShaAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, null);
        unbinder = ButterKnife.bind(this, view);
        presenter = new PresenterImpl(this);
        HashMap<String,String> map=new HashMap<>();
        fenLeiAdapter = new FenLeiAdapter(getActivity(),fenleiList);
        fenleiRecy.setLayoutManager(new GridLayoutManager(getActivity(),5));
        fenleiRecy.setAdapter(fenLeiAdapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        presenter.requesGet(Contacts.HOMR_URL,map,HomeData.class);
        miaoshaRecy.setLayoutManager(linearLayoutManager);
        miaoShaAdapter = new MiaoShaAdapter(getActivity(),miaoshaList);
        miaoshaRecy.setAdapter(miaoShaAdapter);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onSuccessData(Object data) {
        HomeData homeData= (HomeData) data;
        List<String> bannerList=new ArrayList<>();
        for (int i = 0; i < homeData.getData().getBanner().size(); i++) {
            bannerList.add(homeData.getData().getBanner().get(i).getIcon());
        }
        flyBanner.setImagesUrl(bannerList);
        fenleiList.addAll(homeData.getData().getFenlei());
        fenLeiAdapter.notifyDataSetChanged();
        miaoshaList.addAll(homeData.getData().getMiaosha().getList());
        miaoShaAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError(Object error) {

    }
}
