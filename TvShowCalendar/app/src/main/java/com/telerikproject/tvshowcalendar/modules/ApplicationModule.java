package com.telerikproject.tvshowcalendar.modules;

import android.content.Context;

import com.telerikproject.tvshowcalendar.factories.HttpResponseFactory;
import com.telerikproject.tvshowcalendar.factories.base.IHttpResponseFactory;
import com.telerikproject.tvshowcalendar.utils.GsonParser;
import com.telerikproject.tvshowcalendar.utils.OkHttpRequester;
import com.telerikproject.tvshowcalendar.utils.base.IJsonParser;
import com.telerikproject.tvshowcalendar.utils.base.IOkHttpRequester;

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

    @Inject
    @Provides
    IOkHttpRequester provideOkHttpRequester(IHttpResponseFactory httpResponseFactory) {
        return new OkHttpRequester(httpResponseFactory);
    }

    @Provides
    IHttpResponseFactory provideHttpResponseFactory() {
        return new HttpResponseFactory();
    }

    @Provides
    IJsonParser provideJsonParser() {
        return new GsonParser();
    }
}
