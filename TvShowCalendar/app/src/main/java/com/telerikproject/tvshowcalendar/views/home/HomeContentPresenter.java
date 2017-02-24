package com.telerikproject.tvshowcalendar.views.home;

import com.telerikproject.tvshowcalendar.views.home.base.IHomeContract;

public class HomeContentPresenter implements IHomeContract.Presenter {

    private IHomeContract.View view;

    @Override
    public void load() {

    }

    @Override
    public void setView(IHomeContract.View view) {
        this.view = view;
    }
}
