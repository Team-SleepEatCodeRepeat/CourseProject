package com.telerikproject.tvshowcalendar;

import com.telerikproject.tvshowcalendar.activities.MainActivity;
import com.telerikproject.tvshowcalendar.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(MainActivity mainActivity);
}
