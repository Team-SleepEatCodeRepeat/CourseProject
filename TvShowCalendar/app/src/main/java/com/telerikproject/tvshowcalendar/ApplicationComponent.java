package com.telerikproject.tvshowcalendar;

import com.telerikproject.tvshowcalendar.modules.ApplicationModule;
import com.telerikproject.tvshowcalendar.modules.ControllerModule;

import dagger.Component;

@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    ControllerComponent getControllerComponent(ControllerModule controllerModule);
}
