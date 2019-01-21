package com.bawei.chewenfei.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.chewenfei.myapplication.R;
import com.bawei.chewenfei.myapplication.bean.ShoppingCarData;
import com.bawei.chewenfei.myapplication.weight.JiaJianView;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * author:author${车文飞}
 * data:2019/1/20
 */
public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ViewHolder> {
    Context context;
    private List<ShoppingCarData.DataBean.ListBean> list;

    public ChildAdapter(Context context, List<ShoppingCarData.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.child_item,viewGroup,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        String img=list.get(i).getImages();
        String replace = img.replace("https", "http");
        String[] split = replace.split("\\|");
        Glide.with(context).load(split[0]).into(viewHolder.image);
        viewHolder.title.setText(list.get(i).getTitle()+"");
        viewHolder.price.setText(list.get(i).getPrice()+"");
        viewHolder.jianView.setCount(list.get(i).getNum());
        viewHolder.jianView.setJiaJianListenter(new JiaJianView.JiaJianListenter() {
            @Override
            public void setNumText(int num) {
                list.get(i).setNum(num);
               // viewHolder.jianView.setCount();
                notifyDataSetChanged();
                //viewHolder.jianView.setCount(list.get(i).getNum());
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox cb;
        ImageView image;
        TextView title,price;
        JiaJianView jianView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cb=itemView.findViewById(R.id.child_cb);
            image=itemView.findViewById(R.id.child_image);
            title=itemView.findViewById(R.id.child_title);
            price=itemView.findViewById(R.id.child_price);
            jianView=itemView.findViewById(R.id.jianjian_view);
        }
    }
}
