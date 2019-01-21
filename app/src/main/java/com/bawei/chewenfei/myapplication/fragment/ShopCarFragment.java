package com.bawei.chewenfei.myapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bawei.chewenfei.myapplication.R;
import com.bawei.chewenfei.myapplication.adapter.GroupAdapter;
import com.bawei.chewenfei.myapplication.bean.ShoppingCarData;
import com.bawei.chewenfei.myapplication.presenter.PresenterImpl;
import com.bawei.chewenfei.myapplication.utils.Contacts;
import com.bawei.chewenfei.myapplication.view.IView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopCarFragment extends Fragment implements IView {


    @BindView(R.id.cb_checkAll)
    CheckBox cbCheckAll;
    @BindView(R.id.xiadan)
    Button xiadan;
    @BindView(R.id.all_price)
    TextView allPrice;
    @BindView(R.id.rela)
    RelativeLayout rela;
    @BindView(R.id.group_recy)
    RecyclerView groupRecy;
    Unbinder unbinder;
    private List<ShoppingCarData.DataBean> list=new ArrayList<>();
    private GroupAdapter groupAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shop_car, null);

        unbinder = ButterKnife.bind(this, view);
        PresenterImpl presenter=new PresenterImpl(this);
        HashMap<String,String> map=new HashMap<>();
        map.put("uid","71");
        groupRecy.setLayoutManager(new LinearLayoutManager(getActivity()));

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getList()==null){
                list.remove(list.get(i));
            }
        }

        groupAdapter = new GroupAdapter(getActivity(),list);
        groupRecy.setAdapter(groupAdapter);

        presenter.requesGet(Contacts.SELECT_URL,map,ShoppingCarData.class);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.cb_checkAll, R.id.xiadan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cb_checkAll:
                break;
            case R.id.xiadan:
                break;
        }
    }

    @Override
    public void onSuccessData(Object data) {
        ShoppingCarData shoppingCarData= (ShoppingCarData) data;
        list.addAll(shoppingCarData.getData());
        groupAdapter.notifyDataSetChanged();

    }

    @Override
    public void onError(Object error) {

    }
}
