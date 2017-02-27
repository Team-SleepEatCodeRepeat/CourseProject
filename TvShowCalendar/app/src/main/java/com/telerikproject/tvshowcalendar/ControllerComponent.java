package com.telerikproject.tvshowcalendar;


import com.telerikproject.tvshowcalendar.network.base.ITvShowData;
import com.telerikproject.tvshowcalendar.views.home.HomeActivity;
import com.telerikproject.tvshowcalendar.modules.ControllerModule;
import com.telerikproject.tvshowcalendar.views.home.HomeContentFragment;
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
}
