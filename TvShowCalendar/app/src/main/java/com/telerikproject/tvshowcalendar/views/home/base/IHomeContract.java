package com.telerikproject.tvshowcalendar.views.home.base;

import com.telerikproject.tvshowcalendar.fragments.ILoadingFragment;
import com.telerikproject.tvshowcalendar.views.base.BasePresenter;
import com.telerikproject.tvshowcalendar.views.base.BaseView;

import java.util.ArrayList;
import java.util.HashMap;

public interface IHomeContract {
    interface View extends BaseView<Presenter> {
        void fillInfo(ArrayList<String> titles, ArrayList<String> images, ArrayList<String> ids, ArrayList<String> ratings);
    }

    interface Presenter extends BasePresenter<View> {
        void getTopTvShows(ILoadingFragment loadingFragment);
    }
}
