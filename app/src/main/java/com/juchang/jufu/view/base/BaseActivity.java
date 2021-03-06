package com.juchang.jufu.view.base;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;

import butterknife.ButterKnife;

/**
 * BaseActivity 2016-11-25
 */
public abstract class BaseActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseConfig();
        setContentView(setLayout());

        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void setBaseConfig() {
//        initTheme();
        AppManager.getAppManager().addActivity(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        SetStatusBarColor();
    }

    //初始化view
    protected abstract void initView();
    //初始化data
    protected abstract void initData();
    //获取布局文件id
    protected abstract int setLayout();

}