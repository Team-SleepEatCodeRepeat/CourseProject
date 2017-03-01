package com.telerikproject.tvshowcalendar.views.home;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.telerikproject.tvshowcalendar.BaseApplication;
import com.telerikproject.tvshowcalendar.R;
import com.telerikproject.tvshowcalendar.fragments.ILoadingFragment;
import com.telerikproject.tvshowcalendar.modules.ControllerModule;
import com.telerikproject.tvshowcalendar.views.home.base.IHomeContract;

import javax.inject.Inject;

public class HomeActivity extends AppCompatActivity {
    @Inject
    IHomeContract.Presenter contentPresenter;

    @Inject
    FragmentManager fragmentManager;

    @Inject
    ILoadingFragment loadingFragment;

    ILoadingFragment loading;

    private HomeContentFragment content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.injectDependencies();

        content = (HomeContentFragment) fragmentManager.findFragmentById(R.id.fragment_home_content);

        contentPresenter.setView(content);
        content.setPresenter(contentPresenter);

        this.loading = this.loadingFragment.create(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.contentPresenter.getTopTvShows(this.loading);
    }

    private void injectDependencies() {
        BaseApplication.bind(this)
                .from(this)
                .getAppComponent()
                .getControllerComponent(new ControllerModule(this, getSupportFragmentManager()))
                .inject(this);
    }
}
