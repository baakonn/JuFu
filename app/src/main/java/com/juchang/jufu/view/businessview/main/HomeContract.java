package com.juchang.jufu.view.businessview.main;


import com.juchang.jufu.view.base.BasePresenter;
import com.juchang.jufu.view.base.BaseView;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface HomeContract {

    interface View extends BaseView<Presenter> {
        void loadFirstOk(Object o);
        void loadFail(String message);

    }

    interface Presenter extends BasePresenter {
        void loadFirst();
    }
}
