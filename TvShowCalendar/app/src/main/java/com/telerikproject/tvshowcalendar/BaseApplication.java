package com.telerikproject.tvshowcalendar;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import com.telerikproject.tvshowcalendar.modules.ApplicationModule;

import butterknife.ButterKnife;

public class BaseApplication extends Application {
    private ApplicationComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        this.appComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getAppComponent() {

        return this.appComponent;
    }

    public static BaseApplication from(@NonNull Context context) {
        return (BaseApplication) context.getApplicationContext();
    }

    public static BaseApplication bind(@NonNull Activity activity) {
        ButterKnife.bind(activity);
        return (BaseApplication) activity.getApplicationContext();
    }

    public static void bind(@NonNull Object obj, @NonNull View source) {
        ButterKnife.bind(obj, source);
    }
}
