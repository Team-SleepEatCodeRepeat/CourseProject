package com.telerikproject.tvshowcalendar.views.logout;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.telerikproject.tvshowcalendar.R;
import com.telerikproject.tvshowcalendar.views.home.HomeActivity;

public class LogoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

}
