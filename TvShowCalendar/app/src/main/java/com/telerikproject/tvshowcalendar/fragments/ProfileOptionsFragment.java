package com.telerikproject.tvshowcalendar.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.telerikproject.tvshowcalendar.R;
import com.telerikproject.tvshowcalendar.adapters.GridAdapter;

public class ProfileOptionsFragment extends Fragment {

    public ProfileOptionsFragment() {
        // Required empty public constructor
    }

    public static ProfileOptionsFragment createFragment(int position) {

        ProfileOptionsFragment fragment = new ProfileOptionsFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        int position = this.getArguments().getInt("position");

        View root = null;
        switch (position) {
            case 0:
                root = inflater.inflate(R.layout.fragment_profile_options, container, false);
                break;
            case 1:
                root = inflater.inflate(R.layout.profile_watched, container, false);
                break;
            case 2:
                root = inflater.inflate(R.layout.profile_coming_soon, container, false);
                break;
        }
        return root;
    }
}