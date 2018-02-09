package com.legend.bannerviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.legend.bannerviewdemo.R;
import com.legend.bannerviewdemo.bean.ItemBean;

import java.util.List;

/**
 * @author Legend
 * @data by on 2018/2/9.
 * @description
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private Context mContext;

    private List<ItemBean> mList;

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView itemName;

        public ViewHolder(View view) {
            super(view);
            itemName = view.findViewById(R.id.item_name);
        }
    }

    public ItemAdapter(List<ItemBean> mList) {
        this.mList = mList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition()-2;
                ItemBean bean = mList.get(position);
                Toast.makeText(mContext,"我是"+bean.getItem(),Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemBean item = mList.get(position);
        holder.itemName.setText(item.getItem());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}

