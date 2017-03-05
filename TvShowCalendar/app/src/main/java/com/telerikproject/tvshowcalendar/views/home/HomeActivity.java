package com.telerikproject.tvshowcalendar.views.home;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

import com.telerikproject.tvshowcalendar.BaseApplication;
import com.telerikproject.tvshowcalendar.R;
import com.telerikproject.tvshowcalendar.fragments.ILoadingFragment;
import com.telerikproject.tvshowcalendar.fragments.ToolbarFragment;
import com.telerikproject.tvshowcalendar.modules.ControllerModule;
import com.telerikproject.tvshowcalendar.views.home.base.IHomeContract;

import javax.inject.Inject;

public class HomeActivity extends AppCompatActivity {
    @Inject
    IHomeContract.Presenter contentPresenter;

    @Inject
    FragmentManager fragmentManager;

    private HomeContentFragment content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.injectDependencies();

        content = (HomeContentFragment) fragmentManager.findFragmentById(R.id.fragment_home_content);

        contentPresenter.setView(content);
        content.setPresenter(contentPresenter);

        Intent intent = getIntent();
        handleSearchQuery(intent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleSearchQuery(intent);
    }

    private void handleSearchQuery(Intent intent) {
        String query = intent.getStringExtra(SearchManager.QUERY);
        contentPresenter.getTvShowsByQuery(query);
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.contentPresenter.getTopTvShows();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        SearchManager searchManager =
                (SearchManager) getSystemService(this.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        return true;
    }

    private void injectDependencies() {
        BaseApplication.bind(this)
                .from(this)
                .getAppComponent()
                .getControllerComponent(new ControllerModule(this, getSupportFragmentManager()))
                .inject(this);
    }
}
