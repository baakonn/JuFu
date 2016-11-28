package com.juchang.jufu.view.businessview.login;


import com.juchang.jufu.view.base.BasePresenter;
import com.juchang.jufu.view.base.BaseView;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface LoginContract {

    interface View extends BaseView<Presenter> {

        void loginSuccess(String user);

    }

    interface Presenter extends BasePresenter {

        void login(String username, String password);

    }
}
