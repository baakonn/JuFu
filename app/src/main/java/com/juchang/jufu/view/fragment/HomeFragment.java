package com.juchang.jufu.view.fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.juchang.jufu.R;
import com.juchang.jufu.view.base.BaseFragment;

import butterknife.BindView;

public class HomeFragment extends BaseFragment {
    @BindView(R.id.fragment_text)
    TextView mTextView;


    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        initData();
        initView();
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_layout;
    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View mMainView = inflater.inflate(R.layout.fragment_layout, container, false);
//        ButterKnife.bind(this, mMainView);
//        initData();
//        initView();
//        return mMainView;
//    }

    private void initData() {
    }

    private void initView() {
        mTextView.setText("我是HomeFragment");

    }


}
