package com.telerikproject.tvshowcalendar.modules;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;

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
}
