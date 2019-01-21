package com.bawei.chewenfei.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.chewenfei.myapplication.R;
import com.bawei.chewenfei.myapplication.bean.HomeData;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * author:author${车文飞}
 * data:2019/1/20
 */
public class FenLeiAdapter extends RecyclerView.Adapter<FenLeiAdapter.ViewHolder> {
    Context context;
    List<HomeData.DataBean.FenleiBean> list;

    public FenLeiAdapter(Context context, List<HomeData.DataBean.FenleiBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(context, R.layout.feilei_item,null);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(context).load(list.get(i).getIcon()).into(viewHolder.image);
        viewHolder.name.setText(list.get(i).getName());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.fenlei_image);
            name=itemView.findViewById(R.id.fenlei_name);
        }
    }
}
