package com.telerikproject.tvshowcalendar.fragments;

import android.content.Context;

public interface ILoadingFragment {
    void show();

    void hide();

    ILoadingFragment create(Context context);
}
