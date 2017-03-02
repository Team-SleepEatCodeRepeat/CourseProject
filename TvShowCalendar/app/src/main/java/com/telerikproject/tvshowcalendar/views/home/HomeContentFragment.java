package com.telerikproject.tvshowcalendar.views.home;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import com.telerikproject.tvshowcalendar.BaseApplication;
import com.telerikproject.tvshowcalendar.R;
import com.telerikproject.tvshowcalendar.adapters.GridAdapter;
import com.telerikproject.tvshowcalendar.fragments.ILoadingFragment;
import com.telerikproject.tvshowcalendar.models.TvShowModel;
import com.telerikproject.tvshowcalendar.models.base.IPopularTvShowsModel;
import com.telerikproject.tvshowcalendar.modules.ControllerModule;
import com.telerikproject.tvshowcalendar.network.base.ITvShowData;
import com.telerikproject.tvshowcalendar.views.home.base.IHomeContract;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class HomeContentFragment extends Fragment implements IHomeContract.View {

    private IHomeContract.Presenter presenter;

    @Inject
    public Activity mActivity;

    public ArrayList<String> moviesImages;

    public ArrayList<String> moviesTitles;
    public ArrayList<String> moviesRating;
    public ArrayList<String> moviesIds;
    GridView gridView;


    public HomeContentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_content, container, false);
        injectDependencies();
        BaseApplication.bind(this, view);


        gridView = (GridView) view.findViewById(R.id.gv_top_10);

        return view;

    }


    @Override
    public void setPresenter(IHomeContract.Presenter presenter) {
        this.presenter = presenter;
    }

    private void injectDependencies() {
        BaseApplication
                .from(getContext())
                .getAppComponent()
                .getControllerComponent(new ControllerModule(
                        getActivity(), getFragmentManager()
                ))
                .inject(this);
    }

    @Override
    public void fillInfo(ArrayList<String> titles, ArrayList<String> images, ArrayList<String> ids, ArrayList<String> ratings) {
        this.moviesIds = ids;
        this.moviesRating = ratings;
        this.moviesTitles = titles;
        this.moviesImages = images;

        gridView.setAdapter(new GridAdapter(mActivity, moviesTitles, moviesRating, moviesImages, moviesIds));
    }
}
