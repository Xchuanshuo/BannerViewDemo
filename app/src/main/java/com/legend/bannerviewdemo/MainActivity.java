package com.legend.bannerviewdemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.legend.bannerviewdemo.adapter.ItemAdapter;
import com.legend.bannerviewdemo.adapter.XRecyclerViewDivider;
import com.legend.bannerviewdemo.banner.BannerView;
import com.legend.bannerviewdemo.banner.BannerViewAdapter;
import com.legend.bannerviewdemo.bean.ItemBean;
import com.legend.bannerviewdemo.bean.TestBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HP
 */
public class MainActivity extends AppCompatActivity {

    private XRecyclerView mRecyclerView;
    private BannerView mBannerView;
    private BannerViewAdapter adapter;
    private ItemAdapter itemAdapter;
    private SwipeRefreshLayout mSwipeRefresh;
    private List<TestBean> list = new ArrayList<>();
    private List<ItemBean> itemBeanList = new ArrayList<>();
    private TestBean[] beans = {new TestBean("apple",R.drawable.apple),
                            new TestBean("banana",R.drawable.banana),
                            new TestBean("cherry",R.drawable.cherry),
                            new TestBean("grape",R.drawable.grape),
                            new TestBean("mango",R.drawable.mango)};

    private ItemBean itemBean;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiView();
        initListener();
    }

    private void intiView() {
        mRecyclerView = findViewById(R.id.mRecyclerView);
        mSwipeRefresh = findViewById(R.id.mSwipeRefresh);
        mRecyclerView.setPullRefreshEnabled(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mRecyclerView.addItemDecoration(new XRecyclerViewDivider(this,LinearLayoutManager.HORIZONTAL,"1"));
        mBannerView = (BannerView) LayoutInflater.from(this)
                .inflate(R.layout.banner_view_layout,null);
        for (int i=0;i < 5;i++) {
            list.add(beans[i]);
        }
        for (int i=0;i < 10;i++) {
            itemBean = new ItemBean("我是第"+i+"个item");
            itemBeanList.add(itemBean);
        }
        itemAdapter = new ItemAdapter(itemBeanList);
        itemAdapter.notifyDataSetChanged();
        adapter = new BannerViewAdapter(list);
        mBannerView.setAdapter(adapter);

        mRecyclerView.addHeaderView(mBannerView);
        adapter.notifyDataSetChanged();
        mRecyclerView.setAdapter(itemAdapter);
    }

    private void initListener() {
        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSwipeRefresh.setRefreshing(false);
                    }
                },500);
            }
        });
    }
}
