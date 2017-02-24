package com.telerikproject.tvshowcalendar.views.base;

public interface BasePresenter<T extends BaseView> {
    void load();

    void setView(T view);
}
