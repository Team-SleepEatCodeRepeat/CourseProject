package com.telerikproject.tvshowcalendar.views.register;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.telerikproject.tvshowcalendar.BaseApplication;
import com.telerikproject.tvshowcalendar.R;
import com.telerikproject.tvshowcalendar.fragments.base.ILoadingFragment;
import com.telerikproject.tvshowcalendar.modules.ControllerModule;
import com.telerikproject.tvshowcalendar.views.register.base.IRegisterContract;

import javax.inject.Inject;

public class RegisterActivity extends AppCompatActivity {

    @Inject
    IRegisterContract.Presenter presenter;

    @Inject
    FragmentManager fragmentManager;

    @Inject
    ILoadingFragment loadingFragment;

    ILoadingFragment loading;

    private RegisterFragment registerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        this.injectDependencies();

        Toolbar toolbar = (Toolbar) this.findViewById(R.id.toolbar);
        this.setSupportActionBar(toolbar);

        registerFragment = (RegisterFragment) fragmentManager.findFragmentById(R.id.fragment_register);
        registerFragment.setPresenter(presenter);
        presenter.setView(registerFragment);
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
