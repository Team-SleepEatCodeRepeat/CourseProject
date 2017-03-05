package com.telerikproject.tvshowcalendar;


import com.telerikproject.tvshowcalendar.data.base.ITvShowData;
import com.telerikproject.tvshowcalendar.fragments.ToolbarFragment;
import com.telerikproject.tvshowcalendar.views.episodes.EpisodesActivity;
import com.telerikproject.tvshowcalendar.views.episodes.EpisodesFragment;
import com.telerikproject.tvshowcalendar.views.episodes.EpisodesPresenter;
import com.telerikproject.tvshowcalendar.views.home.HomeActivity;
import com.telerikproject.tvshowcalendar.modules.ControllerModule;
import com.telerikproject.tvshowcalendar.views.home.HomeContentFragment;
import com.telerikproject.tvshowcalendar.views.home.HomeContentPresenter;
import com.telerikproject.tvshowcalendar.views.login.LoginActivity;
import com.telerikproject.tvshowcalendar.views.login.LoginFragment;
import com.telerikproject.tvshowcalendar.views.login.LoginPresenter;
import com.telerikproject.tvshowcalendar.views.register.RegisterActivity;
import com.telerikproject.tvshowcalendar.views.register.RegisterFragment;
import com.telerikproject.tvshowcalendar.views.register.RegisterPresenter;
import com.telerikproject.tvshowcalendar.views.serialInfo.SerialInfoActivity;
import com.telerikproject.tvshowcalendar.views.serialInfo.SerialInfoContentFragment;
import com.telerikproject.tvshowcalendar.views.serialInfo.SerialInfoContentPresenter;

import dagger.Subcomponent;

@Subcomponent(modules = {ControllerModule.class})
public interface ControllerComponent {
    void inject(HomeActivity homeActivity);

    void inject(HomeContentFragment homeContentFragment);

    void inject(ITvShowData tvShowData);

    void inject(SerialInfoContentFragment serialInfoContentFragment);

    void inject(SerialInfoActivity serialInfoActivity);

    void inject(SerialInfoContentPresenter serialInfoContentPresenter);

    void inject(HomeContentPresenter homeContentPresenter);

    void inject(EpisodesFragment episodesFragment);

    void inject(EpisodesActivity episodesActivity);

    void inject(EpisodesPresenter episodesPresenter);

    void inject(LoginActivity loginActivity);

    void inject(LoginFragment loginFragment);

    void inject(LoginPresenter loginPresenter);

    void inject(RegisterActivity registerActivity);

    void inject(RegisterPresenter registerPresenter);

    void inject(RegisterFragment registerFragment);

    void inject(ToolbarFragment toolbarFragment);

}
