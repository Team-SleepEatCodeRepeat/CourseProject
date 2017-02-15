package com.telerikproject.tvshowcalendar.fragments;

import android.content.Context;
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
import com.yalantis.guillotine.animation.GuillotineAnimation;

public class ToolbarFragment extends Fragment {

    private static final long RIPPLE_DURATION = 250;

    Toolbar toolbar;
    RelativeLayout root;
    View contentHamburger;
    Context context;

    public ToolbarFragment() {
    }

    @Override
    public void onStart() {
        super.onStart();
        AppCompatActivity activity = (AppCompatActivity) getActivity();

        toolbar = (Toolbar) activity.findViewById(R.id.toolbar);
        root = (RelativeLayout) activity.findViewById(R.id.activity_main);
        contentHamburger = activity.findViewById(R.id.content_hamburger);
        context = activity;

        if (toolbar != null) {
            activity.setSupportActionBar(toolbar);
            activity.getSupportActionBar().setTitle(null);
        }

        View guillotineMenu = LayoutInflater.from(activity).inflate(R.layout.guillotine, null);
        root.addView(guillotineMenu);


        new GuillotineAnimation.GuillotineBuilder(guillotineMenu, guillotineMenu.findViewById(R.id.guillotine_hamburger), contentHamburger)
                .setStartDelay(RIPPLE_DURATION)
                .setActionBarViewForAnimation(toolbar)
                .setClosedOnStart(true)
                .build();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_toolbar, container, false);
    }
}
