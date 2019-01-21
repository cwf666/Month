package com.bawei.chewenfei.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.chewenfei.myapplication.R;
import com.bawei.chewenfei.myapplication.bean.AddCarData;
import com.bawei.chewenfei.myapplication.bean.DetailData;
import com.bawei.chewenfei.myapplication.presenter.PresenterImpl;
import com.bawei.chewenfei.myapplication.utils.Contacts;
import com.bawei.chewenfei.myapplication.view.IView;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailActivity extends AppCompatActivity implements IView {


    @BindView(R.id.detail_title)
    TextView detailTitle;
    @BindView(R.id.detail_price)
    TextView detailPrice;

    @BindView(R.id.detail_image)
    FlyBanner detailImage;
    @BindView(R.id.detail_addcar)
    TextView detailAddcar;
    private PresenterImpl presenter;
    private String pid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        pid = intent.getStringExtra("pid");
        //Toast.makeText(this, pid+"", Toast.LENGTH_SHORT).show();
        HashMap<String, String> map = new HashMap<>();
        map.put("pid", pid);
        presenter = new PresenterImpl(this);
        presenter.requesGet(Contacts.DETAIL_URL, map, DetailData.class);

    }

    @Override
    public void onSuccessData(Object data) {
        if(data instanceof DetailData){
            DetailData detailData = (DetailData) data;
            String img = detailData.getData().getImages();
            String replace = img.replace("https", "http");
            String[] split = replace.split("\\|");
            List<String> bannerList = new ArrayList<>();
            for (int i = 0; i < split.length; i++) {
                bannerList.add(split[i]);
            }
            detailImage.setImagesUrl(bannerList);

            detailTitle.setText(detailData.getData().getTitle());
            detailPrice.setText("$" + detailData.getData().getPrice() + "");
        }
        if(data instanceof AddCarData){
            AddCarData addCarData= (AddCarData) data;
            Toast.makeText(this, addCarData.getMsg(), Toast.LENGTH_SHORT).show();
            if(addCarData.getCode().equals("0")){
                finish();
            }
        }



    }

    @Override
    public void onError(Object error) {

    }

    @OnClick(R.id.detail_addcar)
    public void onViewClicked() {
        HashMap<String,String> addCarMap=new HashMap<>();
        addCarMap.put("pid",pid);
        addCarMap.put("uid",71+"");
        presenter.requesGet(Contacts.ADDCAR_URL,addCarMap,AddCarData.class);
    }
}
