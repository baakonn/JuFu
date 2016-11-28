package com.juchang.jufu.view.businessview.main;

import com.juchang.jufu.util.ToastUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

public class HomePresenter implements HomeContract.Presenter {

    private final HomeContract.View view;

    public HomePresenter(HomeContract.View view) {
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void loadFirst() {
        view.showProgress();
        //请求网络
        OkHttpUtils.get().url("url")
                .addParams("type", "0")
                .addParams("page", "0")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        ToastUtil.showShort("OkHttpUtils-loadFail");

                        view.dismissProgress();
                        view.loadFail("loadFail");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        ToastUtil.showShort("OkHttpUtils-onResponse=" + response);

                        view.dismissProgress();
                        view.loadFirstOk("onResponse");
                    }
                });


    }

    @Override
    public void loadNextPage() {
        view.showProgress();
        //请求网络
        OkHttpUtils.get().url("url")
                .addParams("page", "1")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        ToastUtil.showShort("OkHttpUtils-loadFail");

                        view.dismissProgress();
                        view.loadFail("loadFail");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        ToastUtil.showShort("OkHttpUtils-onResponse=" + response);

                        view.dismissProgress();
                        view.loadFirstOk("onResponse");
                    }
                });

    }
}
