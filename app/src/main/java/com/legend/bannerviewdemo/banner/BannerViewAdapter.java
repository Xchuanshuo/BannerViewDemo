package com.legend.bannerviewdemo.banner;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.legend.bannerviewdemo.R;
import com.legend.bannerviewdemo.bean.TestBean;

import java.util.List;

/**
 * @author Legend
 * @data by on 2018/2/6.
 * @description
 */

public class BannerViewAdapter extends BannerViewBaseAdapter {

    private List<TestBean> mBeansList;
    private Context mContext;

    public BannerViewAdapter(List<TestBean> bannerBeans) {
        this.mBeansList = bannerBeans;
    }

    @Override
    public View getView(ViewGroup container, int position) {
        AppCompatImageView imageView;
        TextView title;

        if (mContext == null) {
            mContext = container.getContext();
        }
        View mView = LayoutInflater.from(mContext).inflate(R.layout.banner_item_layout,null);

        final TestBean bean = mBeansList.get(position);
        imageView = mView.findViewById(R.id.image);
        title = mView.findViewById(R.id.banner_title);
        title.setText(bean.getTitle());
        Glide.with(mContext).load(bean.getImageId())
                .error(R.drawable.ic_launcher_background)
                .into(imageView);
        notifyDataSetChanged();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"你点击了"+bean.getTitle(),Toast.LENGTH_SHORT).show();
            }
        });
        return mView;
    }

    @Override
    public int getSize() {
        return mBeansList.size();
    }
}
