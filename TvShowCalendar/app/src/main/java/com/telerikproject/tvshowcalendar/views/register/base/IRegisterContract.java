package com.telerikproject.tvshowcalendar.views.register.base;

import com.telerikproject.tvshowcalendar.fragments.base.ILoadingFragment;
import com.telerikproject.tvshowcalendar.views.base.BasePresenter;
import com.telerikproject.tvshowcalendar.views.base.BaseView;

public interface IRegisterContract {

    interface View extends BaseView<Presenter> {
        void setLoadingFragment(ILoadingFragment loadingFragment);

        void showLoading();

        void hideLoading();

        void redirectToLogin();

        void successfullyRegistered(String username);

        void registrationFailed();
    }

    interface Presenter extends BasePresenter<View> {
        void register(String username, String password);
    }
}
