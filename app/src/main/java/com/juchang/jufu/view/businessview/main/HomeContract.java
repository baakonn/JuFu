package com.juchang.jufu.view.businessview.main;


import com.juchang.jufu.entity.Master;
import com.juchang.jufu.view.base.BasePresenter;
import com.juchang.jufu.view.base.BaseView;

import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface HomeContract {

    interface View extends BaseView<Presenter> {
        void loadFirstOk(Object o);
        void loadNextPageOk(List<Master> masterList);
        void loadFail(String message);

    }

    interface Presenter extends BasePresenter {
        void loadFirst();
        void loadNextPage();

    }
}
