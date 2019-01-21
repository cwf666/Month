package com.bawei.chewenfei.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.chewenfei.myapplication.R;
import com.bawei.chewenfei.myapplication.bean.ShoppingCarData;

import java.util.List;

/**
 * author:author${车文飞}
 * data:2019/1/20
 */
public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.ViewHolder> {
    private Context context;
    private List<ShoppingCarData.DataBean> list;

    public GroupAdapter(Context context, List<ShoppingCarData.DataBean> list) {
        this.context = context;
        this.list = list;
        //list.remove(0);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v=LayoutInflater.from(context).inflate(R.layout.group_item,viewGroup,false);

        ViewHolder holder=new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tv.setText(list.get(i).getSellerName()+"");
        viewHolder.recy.setLayoutManager(new LinearLayoutManager(context));
        ChildAdapter childAdapter=new ChildAdapter(context,list.get(i).getList());
        viewHolder.recy.setAdapter(childAdapter);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        RecyclerView recy;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.group_shangjia);
            recy=itemView.findViewById(R.id.child_recy);
        }
    }
}
