package com.telerikproject.tvshowcalendar.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.*;

import com.telerikproject.tvshowcalendar.R;
import com.telerikproject.tvshowcalendar.activities.LoginActivity;
import com.telerikproject.tvshowcalendar.activities.ProfileActivity;
import com.yalantis.guillotine.animation.GuillotineAnimation;

public class ToolbarFragment extends Fragment implements View.OnClickListener

{
    private static final long RIPPLE_DURATION = 250;
    private View contentHamburger;
    private Toolbar toolbar;
    private AppCompatActivity currentActivity;
    private View guillotineMenu;
     ViewGroup viewGroup;

    public ToolbarFragment() {
    }


    @Override
    public void onStart() {
        super.onStart();

        this.currentActivity = (AppCompatActivity) getActivity();
        this.toolbar = (Toolbar) this.currentActivity.findViewById(R.id.toolbar);

        viewGroup = (ViewGroup) ((ViewGroup) currentActivity.findViewById(android.R.id.content)).getChildAt(0);

        contentHamburger = currentActivity.findViewById(R.id.content_hamburger);

        guillotineMenu = LayoutInflater.from(currentActivity).inflate(R.layout.guillotine, null);
        viewGroup.addView(guillotineMenu);

        new GuillotineAnimation.GuillotineBuilder(guillotineMenu, guillotineMenu.findViewById(R.id.guillotine_hamburger), contentHamburger)
                .setStartDelay(RIPPLE_DURATION)
                .setActionBarViewForAnimation(toolbar)
                .setClosedOnStart(true)
                .build();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_toolbar, container, false);
    }

    @Override
    public void onClick(View v) {
//        Toast.makeText(getContext() , v.getId() + " " , Toast.LENGTH_LONG).show();
    }
}

//        guillotineMenu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                switch (v.getId()) {
//                    case R.id.log_in_group:
//                        Intent login = new Intent(getContext(), LoginActivity.class);
//                        startActivity(login);
//                        break;
//                    case R.id.profile_group:
//                        Intent profile = new Intent(getContext(), ProfileActivity.class);
//                        startActivity(profile);
//                        break;
//                }
//            }
//        });


