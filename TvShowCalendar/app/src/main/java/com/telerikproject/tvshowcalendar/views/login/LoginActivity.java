
package com.telerikproject.tvshowcalendar.views.login;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.telerikproject.tvshowcalendar.BaseApplication;
import com.telerikproject.tvshowcalendar.R;
import com.telerikproject.tvshowcalendar.factories.base.ILoadingFactory;
import com.telerikproject.tvshowcalendar.fragments.base.ILoadingFragment;
import com.telerikproject.tvshowcalendar.modules.ControllerModule;
import com.telerikproject.tvshowcalendar.views.login.base.ILoginContract;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity {
    @Inject
    ILoginContract.Presenter presenter;

    @Inject
    FragmentManager fragmentManager;

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
    }

    private void injectDependencies() {
        BaseApplication.bind(this)
                .from(this)
                .getAppComponent()
                .getControllerComponent(new ControllerModule(this, getSupportFragmentManager()))
                .inject(this);
    }
}


