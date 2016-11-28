package com.juchang.jufu.view.fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.juchang.jufu.R;
import com.juchang.jufu.view.base.BaseFragment;

import butterknife.BindView;

public class MeFragment extends BaseFragment {
    @BindView(R.id.fragment_text)
    TextView mTextView;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mTextView.setText("我是MeFragment");
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_layout;
    }


}
