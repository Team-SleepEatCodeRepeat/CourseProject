package com.telerikproject.tvshowcalendar.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.telerikproject.tvshowcalendar.R;

public class BackToolbarFragment extends Fragment {

    Toolbar toolbar;
    private AppCompatActivity currentActivity;
    ActionBar actionBar;

    public BackToolbarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_back_toolbar, container, false);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

//        currentActivity = (AppCompatActivity) getActivity();
//        toolbar = (Toolbar) currentActivity.findViewById(R.id.toolbar);
//        currentActivity.setSupportActionBar(toolbar);
//        actionBar = currentActivity.getSupportActionBar();
    }

//    public void setNavigationOnClickListener(View.OnClickListener clickListener) {
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setDisplayShowHomeEnabled(true);
//        toolbar.setNavigationOnClickListener(clickListener);
//    }
}


