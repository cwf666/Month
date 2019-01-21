package com.bawei.chewenfei.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bawei.chewenfei.myapplication.fragment.FenLeiFragment;
import com.bawei.chewenfei.myapplication.fragment.HomeFragment;
import com.bawei.chewenfei.myapplication.fragment.MyFragment;
import com.bawei.chewenfei.myapplication.fragment.ShopCarFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rb1)
    RadioButton rb1;
    @BindView(R.id.rb2)
    RadioButton rb2;
    @BindView(R.id.rb3)
    RadioButton rb3;
    @BindView(R.id.rb4)
    RadioButton rb4;
    @BindView(R.id.rg)
    RadioGroup rg;
    @BindView(R.id.fr)
    FrameLayout fr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fr,new HomeFragment()).commit();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fr,new HomeFragment()).commit();
                        break;
                    case R.id.rb2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fr,new FenLeiFragment()).commit();
                        break;
                    case R.id.rb3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fr,new ShopCarFragment()).commit();
                        break;
                    case R.id.rb4:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fr,new MyFragment()).commit();
                        break;
                }
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
