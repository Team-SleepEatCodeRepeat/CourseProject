package com.telerikproject.tvshowcalendar.views.home.base;

import com.telerikproject.tvshowcalendar.models.ITvShow;
import com.telerikproject.tvshowcalendar.views.base.BasePresenter;
import com.telerikproject.tvshowcalendar.views.base.BaseView;

import java.util.List;

public interface IHomeContract {
    interface View extends BaseView<Presenter> {
        void fillInfo(List<ITvShow> tvShows);

        void startLoading();

        void stopLoading();
    }

    interface Presenter extends BasePresenter<View> {
        void getTopTvShows();

        void getTvShowsByQuery(final String query);
    }
}
