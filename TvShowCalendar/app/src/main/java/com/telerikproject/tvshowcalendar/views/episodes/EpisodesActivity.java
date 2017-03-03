package com.telerikproject.tvshowcalendar.views.episodes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.telerikproject.tvshowcalendar.BaseApplication;
import com.telerikproject.tvshowcalendar.R;
import com.telerikproject.tvshowcalendar.fragments.ILoadingFragment;
import com.telerikproject.tvshowcalendar.modules.ControllerModule;
import com.telerikproject.tvshowcalendar.views.episodes.base.IEpisodesContract;

import javax.inject.Inject;

public class EpisodesActivity extends AppCompatActivity {

    @Inject
    FragmentManager fragmentManager;

    @Inject
    IEpisodesContract.Presenter presenter;

    @Inject
    ILoadingFragment loadingFragment;

    ILoadingFragment loading;

    private EpisodesFragment episodes;
    private String seasonNumber;
    private String tvShowId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episodes);
        this.injectDependencies();
        this.loading = loadingFragment.create(this);
        this.seasonNumber = getIntent().getStringExtra("seasonNumber");
        this.tvShowId = getIntent().getStringExtra("tvShowId");

        episodes = (EpisodesFragment) fragmentManager.findFragmentById(R.id.fragment_episodes);

        presenter.setView(episodes);

        episodes.setPresenter(presenter);


    }

    @Override
    protected void onStart() {
        super.onStart();
        this.presenter.getSeasonEpisodes(seasonNumber, tvShowId, loading);
    }

    private void injectDependencies() {
        BaseApplication.bind(this)
                .from(this)
                .getAppComponent()
                .getControllerComponent(new ControllerModule(this, getSupportFragmentManager()))
                .inject(this);
    }
}
