package com.bawei.chewenfei.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.chewenfei.myapplication.R;
import com.bawei.chewenfei.myapplication.bean.HomeData;
import com.bawei.chewenfei.myapplication.ui.DetailActivity;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * author:author${车文飞}
 * data:2019/1/20
 */
public class MiaoShaAdapter extends RecyclerView.Adapter<MiaoShaAdapter.ViewHolder> {
    private Context context;
    private List<HomeData.DataBean.MiaoshaBean.ListBean> list;

    public MiaoShaAdapter(Context context, List<HomeData.DataBean.MiaoshaBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(context,R.layout.miaosha_item,null);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        String img=list.get(i).getImages();
        String replace = img.replace("https", "http");
        String[] split = replace.split("\\|");
        Glide.with(context).load(split[0]).into(viewHolder.image);
        viewHolder.price.setText(list.get(i).getPrice()+"");
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,DetailActivity.class);
                intent.putExtra("pid",list.get(i).getPid()+"");
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView price;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.miaosha_image);
            price=itemView.findViewById(R.id.miaosha_price);
        }
    }
}
