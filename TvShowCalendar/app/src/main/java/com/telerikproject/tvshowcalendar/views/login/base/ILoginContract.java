package com.telerikproject.tvshowcalendar.views.login.base;

import com.telerikproject.tvshowcalendar.fragments.ILoadingFragment;
import com.telerikproject.tvshowcalendar.views.base.BasePresenter;
import com.telerikproject.tvshowcalendar.views.base.BaseView;

public interface ILoginContract {
    interface View extends BaseView<Presenter> {

        void setLoadingFragment(ILoadingFragment loadingFragment);

        void showLoading();

        void hideLoading();

        void redirectToHome();

        void loginSuccessful(String username);

        void loginFailed();
    }

    interface Presenter extends BasePresenter<View> {
        void login(String username, String password);
    }
}
