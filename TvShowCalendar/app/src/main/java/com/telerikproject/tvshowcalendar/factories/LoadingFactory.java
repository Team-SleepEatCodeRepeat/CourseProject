package com.telerikproject.tvshowcalendar.factories;

import android.app.Activity;

import com.telerikproject.tvshowcalendar.factories.base.ILoadingFactory;
import com.telerikproject.tvshowcalendar.fragments.LoadingFragment;
import com.telerikproject.tvshowcalendar.fragments.base.ILoadingFragment;

import javax.inject.Inject;

public class LoadingFactory implements ILoadingFactory {

    Activity mActivity;

    @Inject
    public LoadingFactory(Activity activity) {
        this.mActivity = activity;
    }

    @Override
    public ILoadingFragment create() {
        LoadingFragment loadingFragment = new LoadingFragment();
        loadingFragment.setContext(mActivity);
        return loadingFragment;
    }
}
