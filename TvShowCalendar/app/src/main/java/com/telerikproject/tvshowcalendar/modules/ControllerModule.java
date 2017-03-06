package com.telerikproject.tvshowcalendar.modules;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;

import com.telerikproject.tvshowcalendar.data.base.ITvShowData;
import com.telerikproject.tvshowcalendar.data.base.IUserData;
import com.telerikproject.tvshowcalendar.models.user.base.IUserModel;
import com.telerikproject.tvshowcalendar.views.episodes.EpisodesPresenter;
import com.telerikproject.tvshowcalendar.views.episodes.base.IEpisodesContract;
import com.telerikproject.tvshowcalendar.views.home.HomeContentPresenter;
import com.telerikproject.tvshowcalendar.views.home.base.IHomeContract;
import com.telerikproject.tvshowcalendar.views.login.LoginPresenter;
import com.telerikproject.tvshowcalendar.views.login.base.ILoginContract;
import com.telerikproject.tvshowcalendar.views.register.RegisterPresenter;
import com.telerikproject.tvshowcalendar.views.register.base.IRegisterContract;
import com.telerikproject.tvshowcalendar.views.serialInfo.SerialInfoContentPresenter;
import com.telerikproject.tvshowcalendar.views.serialInfo.base.ISerialInfoContract;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

@Module
public class ControllerModule {

    private final Activity activity;
    private final FragmentManager fragmentManager;

    public ControllerModule(Activity activity, FragmentManager fragmentManager) {
        this.activity = activity;
        this.fragmentManager = fragmentManager;
    }

    @Provides
    Activity provideActivity() {
        return this.activity;
    }

    @Provides
    Context provideContext() {
        return this.activity;
    }

    @Provides
    FragmentManager provideFragmentManager() {
        return this.fragmentManager;
    }

    @Inject
    @Provides
    IHomeContract.Presenter provideHomeContentPresenter(ITvShowData tvShowData) {
        return new HomeContentPresenter(tvShowData);
    }

    @Inject
    @Provides
    ISerialInfoContract.Presenter provideSerialInfoContentPresenter(ITvShowData tvShowData) {
        return new SerialInfoContentPresenter(tvShowData);
    }


    @Inject
    @Provides
    IEpisodesContract.Presenter provideEpisodesPresenter(ITvShowData tvShowData) {
        return new EpisodesPresenter(tvShowData);
    }

    @Inject
    @Provides
    ILoginContract.Presenter provideLoginPresenter(IUserData userData) {
        return new LoginPresenter(userData);
    }

    @Inject
    @Provides
    IRegisterContract.Presenter provideRegisterPresenter(IUserData userData) {
        return new RegisterPresenter(userData);
    }
}
