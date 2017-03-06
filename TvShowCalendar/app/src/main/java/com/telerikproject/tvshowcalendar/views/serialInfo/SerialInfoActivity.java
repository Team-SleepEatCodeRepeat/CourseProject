package com.telerikproject.tvshowcalendar.views.serialInfo;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.telerikproject.tvshowcalendar.BaseApplication;
import com.telerikproject.tvshowcalendar.R;
import com.telerikproject.tvshowcalendar.fragments.BackToolbarFragment;
import com.telerikproject.tvshowcalendar.fragments.base.ILoadingFragment;
import com.telerikproject.tvshowcalendar.modules.ControllerModule;
import com.telerikproject.tvshowcalendar.views.serialInfo.base.ISerialInfoContract;

import javax.inject.Inject;

public class SerialInfoActivity extends AppCompatActivity {

    @Inject
    ISerialInfoContract.Presenter contentPresenter;

    private String id;
    private ILoadingFragment loading;
    BackToolbarFragment backFragment;

    @Inject
    FragmentManager fragmentManager;

    @Inject
    ILoadingFragment loadingFragment;

    private SerialInfoContentFragment content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serial_info);
        this.injectDependencies();

        content = (SerialInfoContentFragment) fragmentManager.findFragmentById(R.id.fragment_serial_info_content);
        contentPresenter.setView(content);
        content.setPresenter(contentPresenter);

        this.id = getIntent().getStringExtra("id");
        this.loading = loadingFragment.create(this);

        backFragment = (BackToolbarFragment) fragmentManager.findFragmentById(R.id.back_toolbar);

        final Button followBtn = (Button)this.findViewById(R.id.btn_follow);
        followBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button)v;
                if(btn.getText() == "Follow")
                {
                    followBtn.setText("Following");
                }
                else
                {
                    followBtn.setText("Follow");
                }
            }
        });

        final Button watchedBtn = (Button)this.findViewById(R.id.btn_watched);
        watchedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button)v;
                if(btn.getText() == "Not Watched")
                {
                    watchedBtn.setText("Watched");
                }
                else
                {
                    watchedBtn.setText("Not Watched");
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.contentPresenter.getSerial(this.id, this.loading);
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