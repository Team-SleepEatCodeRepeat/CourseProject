package com.telerikproject.tvshowcalendar.views.home.base;

import com.telerikproject.tvshowcalendar.fragments.ILoadingFragment;
import com.telerikproject.tvshowcalendar.models.ITvShow;
import com.telerikproject.tvshowcalendar.views.base.BasePresenter;
import com.telerikproject.tvshowcalendar.views.base.BaseView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface IHomeContract {
    interface View extends BaseView<Presenter> {
        void fillInfo(List<ITvShow> tvShows);
    }

    interface Presenter extends BasePresenter<View> {
        void getTopTvShows(ILoadingFragment loadingFragment);

        void getTvShowsByQuery(final String query);
    }
}
