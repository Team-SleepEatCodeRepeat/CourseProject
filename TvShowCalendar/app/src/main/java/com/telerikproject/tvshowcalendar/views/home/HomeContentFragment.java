package com.telerikproject.tvshowcalendar.views.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.telerikproject.tvshowcalendar.BaseApplication;
import com.telerikproject.tvshowcalendar.R;
import com.telerikproject.tvshowcalendar.adapters.GridAdapter;
import com.telerikproject.tvshowcalendar.views.home.base.IHomeContract;

import static com.telerikproject.tvshowcalendar.views.home.HomeActivity.moviesImages;
import static com.telerikproject.tvshowcalendar.views.home.HomeActivity.moviesSeasons;
import static com.telerikproject.tvshowcalendar.views.home.HomeActivity.moviesTitles;

public class HomeContentFragment extends Fragment implements IHomeContract.View {

    private IHomeContract.Presenter presenter;

    public HomeContentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_content, container, false);

        BaseApplication.bind(this, view);

        GridView gridView = (GridView) view.findViewById(R.id.gv_top_10);
        gridView.setAdapter(new GridAdapter(getActivity(), moviesTitles, moviesSeasons, moviesImages));

        return view;
    }

    @Override
    public void setPresenter(IHomeContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
