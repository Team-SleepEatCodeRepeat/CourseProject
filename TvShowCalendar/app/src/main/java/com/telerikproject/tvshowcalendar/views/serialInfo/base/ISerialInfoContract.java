package com.telerikproject.tvshowcalendar.views.serialInfo.base;

import com.telerikproject.tvshowcalendar.fragments.base.ILoadingFragment;
import com.telerikproject.tvshowcalendar.views.base.BasePresenter;
import com.telerikproject.tvshowcalendar.views.base.BaseView;

public interface ISerialInfoContract {
    interface View extends BaseView<ISerialInfoContract.Presenter> {

        void setTitle(String title);
        void fillInfo(String tvRating, String image, String description, int numOfSeasons, String tvShowId);
    }

    interface Presenter extends BasePresenter<ISerialInfoContract.View> {

        void getSerial(String id, ILoadingFragment loading);
    }
}
