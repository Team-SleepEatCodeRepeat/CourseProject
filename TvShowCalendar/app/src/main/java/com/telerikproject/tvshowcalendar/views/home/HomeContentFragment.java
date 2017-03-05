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
import com.telerikproject.tvshowcalendar.adapters.SearchAdapter;
import com.telerikproject.tvshowcalendar.models.ITvShow;
import com.telerikproject.tvshowcalendar.modules.ControllerModule;
import com.telerikproject.tvshowcalendar.views.home.base.IHomeContract;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class HomeContentFragment extends Fragment implements IHomeContract.View {

    private IHomeContract.Presenter presenter;

    @Inject
    public Activity mActivity;

    private GridView gridView;
    private GridAdapter adapter;

    public HomeContentFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_content, container, false);
        injectDependencies();
        BaseApplication.bind(this, view);

        adapter = new GridAdapter(mActivity, new ArrayList<ITvShow>());
        gridView = (GridView) view.findViewById(R.id.gv_top_10);
        gridView.setAdapter(adapter);

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
    public void fillInfo(List<ITvShow> tvShows) {
        adapter.swap(tvShows);
    }
}