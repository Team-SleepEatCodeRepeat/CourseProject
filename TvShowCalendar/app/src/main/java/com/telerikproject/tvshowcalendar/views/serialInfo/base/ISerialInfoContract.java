package com.telerikproject.tvshowcalendar.views.serialInfo.base;

import com.telerikproject.tvshowcalendar.fragments.ILoadingFragment;
import com.telerikproject.tvshowcalendar.views.base.BasePresenter;
import com.telerikproject.tvshowcalendar.views.base.BaseView;

public interface ISerialInfoContract {
    interface View extends BaseView<ISerialInfoContract.Presenter> {
        void fillInfo(String tvRating, String image, String description);
    }

    interface Presenter extends BasePresenter<ISerialInfoContract.View> {

        void getSerial(int id, ILoadingFragment loading);
    }
}
