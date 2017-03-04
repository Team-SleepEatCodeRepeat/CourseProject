
package com.telerikproject.tvshowcalendar.views.login;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.telerikproject.tvshowcalendar.BaseApplication;
import com.telerikproject.tvshowcalendar.R;
import com.telerikproject.tvshowcalendar.fragments.ILoadingFragment;
import com.telerikproject.tvshowcalendar.modules.ControllerModule;
import com.telerikproject.tvshowcalendar.views.login.base.ILoginContract;
import com.telerikproject.tvshowcalendar.views.register.RegisterActivity;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity {
    @Inject
    ILoginContract.Presenter presenter;

    @Inject
    FragmentManager fragmentManager;

    @Inject
    ILoadingFragment loadingFragment;

    ILoadingFragment loading;

    private LoginFragment loginFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.injectDependencies();

        Toolbar toolbar = (Toolbar) this.findViewById(R.id.toolbar);
        this.setSupportActionBar(toolbar);

        loginFragment = (LoginFragment) fragmentManager.findFragmentById(R.id.fragment_login);

        loginFragment.setPresenter(presenter);

        presenter.setView(loginFragment);

        this.loading = loadingFragment.create(this);

    }


    private void injectDependencies() {
        BaseApplication.bind(this)
                .from(this)
                .getAppComponent()
                .getControllerComponent(new ControllerModule(this, getSupportFragmentManager()))
                .inject(this);
    }
}


