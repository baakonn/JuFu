package com.juchang.jufu.view.businessview.main;


import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.View;

import com.juchang.jufu.R;
import com.juchang.jufu.util.ToastUtil;
import com.juchang.jufu.view.adapter.BannerPagerAdapter;
import com.juchang.jufu.view.base.BaseFragment;
import com.jude.rollviewpager.OnItemClickListener;
import com.jude.rollviewpager.RollPagerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseFragment implements HomeContract.View, SwipeRefreshLayout.OnRefreshListener{

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.rollPagerView)
    RollPagerView mRollPagerView;

    private HomeContract.Presenter mPresenter;
    //banner 图片
    private List<String> imgList = new ArrayList<>();

    @Override
    protected void initData() {
        mPresenter = new HomePresenter(this);


    }
    private BannerPagerAdapter mBannerPagerAdapter;

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        //下拉刷新
        mSwipeRefreshLayout.setOnRefreshListener(this);
        //banner点击事件
        mRollPagerView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                ToastUtil.showShort(getHoldingActivity(), "banner 点击了--"+position);
            }
        });
        //TODO 修改BannerPagerAdapter数据
        mBannerPagerAdapter = new BannerPagerAdapter(mRollPagerView, imgList);
        mRollPagerView.setAdapter(mBannerPagerAdapter);

    }

    @Override
    protected int setLayout() {
        return R.layout.home_fragment;
    }

    @Override
    public void loadFirstOk(Object o) {
        mBannerPagerAdapter.changData();

    }

    @Override
    public void loadFail(String message) {

    }


    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        this.mPresenter = presenter;

    }

    @Override
    public void onRefresh() {
        //测试
        mSwipeRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(false);
                loadFirstOk(null);
            }
        }, 2000);
//        mPresenter.loadFirst();
    }

    @Override
    public void showProgress() {
        mSwipeRefreshLayout.setRefreshing(true);

    }

    @Override
    public void dismissProgress() {
        mSwipeRefreshLayout.setRefreshing(false);

    }

    @Override
    public void showTip(String message) {
        if(TextUtils.isEmpty(message)){
            return;
        }
        ToastUtil.showShort(getHoldingActivity(), message);
    }


}
