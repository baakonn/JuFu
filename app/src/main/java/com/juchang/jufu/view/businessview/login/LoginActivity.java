package com.juchang.jufu.view.businessview.login;


import com.juchang.jufu.R;
import com.juchang.jufu.view.base.BaseActivity;

public class LoginActivity extends BaseActivity implements LoginContract.View {

    // mLoginPresenter
    private LoginContract.Presenter mLoginPresenter;

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mLoginPresenter.login("test", "test");
    }

    @Override
    public void loginSuccess(String user) {

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

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.mLoginPresenter = presenter;
    }
}
