package com.telerikproject.tvshowcalendar;


import com.telerikproject.tvshowcalendar.network.base.ITvShowData;
import com.telerikproject.tvshowcalendar.views.home.HomeActivity;
import com.telerikproject.tvshowcalendar.modules.ControllerModule;
import com.telerikproject.tvshowcalendar.views.home.HomeContentFragment;

import dagger.Subcomponent;

@Subcomponent(modules = {ControllerModule.class})
public interface ControllerComponent {
    void inject(HomeActivity homeActivity);

    void inject(HomeContentFragment homeContentFragment);

    void inject(ITvShowData tvShowData);
}
