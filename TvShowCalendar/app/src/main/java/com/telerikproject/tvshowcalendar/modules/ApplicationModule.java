package com.telerikproject.tvshowcalendar.modules;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private final Context ctx;

    @Inject
    public ApplicationModule(Context ctx) {

        this.ctx = ctx;
    }

    @Provides
    @Singleton
    public Context provideCtx() {
        return this.ctx;
    }
}
