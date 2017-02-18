package com.telerikproject.tvshowcalendar;

import android.app.Application;

import com.telerikproject.tvshowcalendar.modules.ApplicationModule;

public class BaseApplication extends Application {
    private ApplicationComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        this.appComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }

    public ApplicationComponent getAppComponent() {

        return this.appComponent;
    }
}
