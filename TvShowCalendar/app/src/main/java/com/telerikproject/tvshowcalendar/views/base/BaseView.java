package com.telerikproject.tvshowcalendar.views.base;

public interface BaseView<T extends BasePresenter> {
    void setPresenter(T presenter);
}
