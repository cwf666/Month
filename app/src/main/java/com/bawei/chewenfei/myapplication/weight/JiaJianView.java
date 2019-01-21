package com.bawei.chewenfei.myapplication.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.chewenfei.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * author:author${车文飞}
 * data:2019/1/20
 */
public class JiaJianView extends LinearLayout implements View.OnClickListener {

    ImageView imageJian;
    TextView num;
    ImageView imageJia;
    Context context;
    private int mcount;

    public void setCount(int count) {
        this.mcount = count;
        num.setText(count+"");

    }


    public JiaJianView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        //ButterKnife.bind(this);

        LayoutInflater.from(context).inflate(R.layout.jiajian_item, this);
        imageJia=findViewById(R.id.image_jia);
        imageJian= findViewById(R.id.image_jian);
        num=findViewById(R.id.num);
        imageJian.setOnClickListener(this);
        imageJia.setOnClickListener(this);


    }

    JiaJianListenter jiaJianListenter;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_jian:
                if(mcount==1){
                    Toast.makeText(context, "不能再减了", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(jiaJianListenter!=null){
                    mcount--;
                    jiaJianListenter.setNumText(mcount);
                }
                break;
            case R.id.image_jia:
                if(jiaJianListenter!=null){
                    mcount++;
                    jiaJianListenter.setNumText(mcount);
                }
                break;
        }

    }

    public interface JiaJianListenter{
        void setNumText(int num);
    }

    public void setJiaJianListenter(JiaJianListenter jiaJianListenter) {
        this.jiaJianListenter = jiaJianListenter;
    }
}
