package com.juchang.jufu.view.businessview.main;


import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.juchang.jufu.R;
import com.juchang.jufu.entity.Master;
import com.juchang.jufu.util.ToastUtil;
import com.juchang.jufu.view.adapter.BannerPagerAdapter;
import com.juchang.jufu.view.base.BaseFragment;
import com.jude.rollviewpager.OnItemClickListener;
import com.jude.rollviewpager.RollPagerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

public class HomeFragment extends BaseFragment implements HomeContract.View, SwipeRefreshLayout.OnRefreshListener{

    @BindView(R.id.nestedScrollView)
    NestedScrollView mNestedScrollView;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.rollPagerView)
    RollPagerView mRollPagerView;
    @BindView(R.id.masterRecyclerView)
    RecyclerView mRecyclerView;

    private HomeContract.Presenter mPresenter;
    //banner 图片
    private List<String> imgList = new ArrayList<>();
    private List<Master> mMasterList = new ArrayList<>();



    @OnClick({R.id.menu, R.id.search,R.id.today, R.id.treehole,
            R.id.music, R.id.exercise,R.id.more_text})
    public void buttonOnClick(View view){
//        Intent intent = new Intent();
//        intent.setClass(getHoldingActivity(), );
        switch (view.getId()){
            case R.id.menu:
                ToastUtil.showShort("菜单");
                break;
            case R.id.search:
                ToastUtil.showShort("搜索");
                break;
            case R.id.today:
                ToastUtil.showShort("今日");
                break;
            case R.id.treehole:
                ToastUtil.showShort("树洞");
                break;
            case R.id.music:
                ToastUtil.showShort("听经");
                break;
            case R.id.exercise:
                ToastUtil.showShort("禅修");
                break;
            case R.id.more_text:
                ToastUtil.showShort("更多。。。");
                break;
        }
    }
    @Override
    protected void initData() {
        mPresenter = new HomePresenter(this);
        for (int i = 0; i < 10; i++) {
            Master master = new Master();
            master.icon = "aaaaa";
            master.company = "大悲寺"+i;
            master.name = "弘一法师"+i;
            master.online = i%2;
            master.label = "情绪困扰 "+i;
            master.describe = "菩提本无树 "+i;
            master.loveNum = 100+i;

            mMasterList.add(master);
        }
    }
    private BannerPagerAdapter mBannerPagerAdapter;
    private BaseQuickAdapter mMaterAdapter;
    private LinearLayoutManager mLayoutManager;
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mNestedScrollView.setNestedScrollingEnabled(false);
        mNestedScrollView.smoothScrollTo(0,0);
        //列表数据
        mLayoutManager = new LinearLayoutManager(getHoldingActivity(), LinearLayoutManager.VERTICAL, false);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setLayoutManager(mLayoutManager);

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
//        mBannerPagerAdapter = new BannerPagerAdapter(mRollPagerView, imgList);
        mBannerPagerAdapter = new BannerPagerAdapter(mRollPagerView);
        mRollPagerView.setAdapter(mBannerPagerAdapter);

        final BitmapPool pool = Glide.get(getHoldingActivity()).getBitmapPool();
        mMaterAdapter = new BaseQuickAdapter(R.layout.home_item, mMasterList) {
            @Override
            protected void convert(BaseViewHolder baseViewHolder, Object o) {
                Master master = (Master) o;
                baseViewHolder.setText(R.id.company, master.company)
                        .setText(R.id.name, master.name)
                        .setText(R.id.online, master.online == 0 ? "离线" : "在线")
                        .setText(R.id.lable, master.label)
                        .setText(R.id.describe, master.describe);
                baseViewHolder.addOnClickListener(R.id.loveNum);

                Glide.with(getHoldingActivity())
                        .load(master.icon)
                        .error(R.drawable.usericon)
                        .bitmapTransform(new CropCircleTransformation(pool))
                        .into((ImageView) baseViewHolder.getView(R.id.usericon));
            }
        };
        mMaterAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mRecyclerView.addOnItemTouchListener(new com.chad.library.adapter.base.listener.OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int position) {
                ToastUtil.showShort(getHoldingActivity(), "onItemClick==" + position);
//                Intent intent = new Intent(getHoldingActivity(), GankDetailsActivity.class);
//                intent.putExtra("url", mNewsList.get(position).url);
//                startActivity(intent);
            }
        });

        mRecyclerView.setAdapter(mMaterAdapter);
    }


    private void initListener() {

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
        ToastUtil.showShort(message);
    }


}
