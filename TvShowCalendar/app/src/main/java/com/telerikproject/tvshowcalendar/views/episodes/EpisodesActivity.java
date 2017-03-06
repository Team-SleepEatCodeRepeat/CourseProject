package com.telerikproject.tvshowcalendar.views.episodes;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.telerikproject.tvshowcalendar.BaseApplication;
import com.telerikproject.tvshowcalendar.R;
import com.telerikproject.tvshowcalendar.factories.base.ILoadingFactory;
import com.telerikproject.tvshowcalendar.fragments.BackToolbarFragment;
import com.telerikproject.tvshowcalendar.fragments.base.ILoadingFragment;
import com.telerikproject.tvshowcalendar.modules.ControllerModule;
import com.telerikproject.tvshowcalendar.views.episodes.base.IEpisodesContract;

import javax.inject.Inject;

public class EpisodesActivity extends AppCompatActivity {

    @Inject
    FragmentManager fragmentManager;

    @Inject
    IEpisodesContract.Presenter presenter;

    @Inject
    ILoadingFactory loadingFactory;

    ILoadingFragment loading;

    private EpisodesFragment episodes;
    private String seasonNumber;
    private String tvShowId;
    BackToolbarFragment backFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episodes);
        this.injectDependencies();
        this.loading = loadingFactory.create();
        this.seasonNumber = getIntent().getStringExtra("seasonNumber");
        this.tvShowId = getIntent().getStringExtra("tvShowId");

        episodes = (EpisodesFragment) fragmentManager.findFragmentById(R.id.fragment_episodes);

        presenter.setView(episodes);
        episodes.setPresenter(presenter);
        backFragment = (BackToolbarFragment) fragmentManager.findFragmentById(R.id.back_toolbar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.presenter.getSeasonEpisodes(seasonNumber, tvShowId, loading);
        backFragment.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void injectDependencies() {
        BaseApplication.bind(this)
                .from(this)
                .getAppComponent()
                .getControllerComponent(new ControllerModule(this, getSupportFragmentManager()))
                .inject(this);
    }
}
