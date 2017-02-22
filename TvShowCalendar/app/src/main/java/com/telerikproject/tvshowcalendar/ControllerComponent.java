package com.telerikproject.tvshowcalendar;


import com.telerikproject.tvshowcalendar.activities.MainActivity;
import com.telerikproject.tvshowcalendar.modules.ControllerModule;

import dagger.Subcomponent;

@Subcomponent(modules = {ControllerModule.class})
public interface ControllerComponent {
    void inject(MainActivity mainActivity);
}
