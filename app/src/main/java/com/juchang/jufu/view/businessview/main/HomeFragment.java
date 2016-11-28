package com.juchang.jufu.view.businessview.main;


import android.os.Bundle;
import android.view.View;

import com.juchang.jufu.R;
import com.juchang.jufu.entity.Master;
import com.juchang.jufu.view.adapter.BannerPagerAdapter;
import com.juchang.jufu.view.base.BaseFragment;
import com.jude.rollviewpager.RollPagerView;

import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseFragment implements HomeContract.View{
//    @BindView(R.id.fragment_text)
//    TextView mTextView;
    @BindView(R.id.rollPagerView)
    RollPagerView mRollPagerView;

    private HomeContract.Presenter mPresenter;

    @Override
    protected void initData() {
        mPresenter = new HomePresenter(this);
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mRollPagerView.setAdapter(new BannerPagerAdapter(mRollPagerView));
    }

    @Override
    protected int setLayout() {
        return R.layout.home_fragment;
    }

    @Override
    public void loadFirstOk(Object o) {

    }

    @Override
    public void loadNextPageOk(List<Master> masterList) {

    }

    @Override
    public void loadFail(String message) {

    }


    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        this.mPresenter = presenter;

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void showTip(String message) {

    }
}
