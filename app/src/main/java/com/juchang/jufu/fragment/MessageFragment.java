package com.juchang.jufu.fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.juchang.jufu.R;
import com.juchang.jufu.base.BaseFragment;

import butterknife.BindView;

public class MessageFragment extends BaseFragment {
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

    private void initData() {

    }

    private void initView() {
        mTextView.setText("我是MessageFragment");

    }


}
