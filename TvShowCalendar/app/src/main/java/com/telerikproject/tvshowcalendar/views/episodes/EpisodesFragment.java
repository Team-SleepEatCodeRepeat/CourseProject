package com.telerikproject.tvshowcalendar.views.episodes;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.telerikproject.tvshowcalendar.R;
import com.telerikproject.tvshowcalendar.adapters.EpisodeListAdapter;
import com.telerikproject.tvshowcalendar.views.episodes.base.IEpisodesContract;

import java.util.ArrayList;

public class EpisodesFragment extends Fragment implements IEpisodesContract.View {

    private IEpisodesContract.Presenter presenter;

    ListView listView;

    public EpisodesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_episodes, container, false);
        listView = (ListView) view.findViewById(R.id.lv_episodes);

        return view;
    }

    @Override
    public void setPresenter(IEpisodesContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setTitle(String title) {
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(title);
    }

    @Override
    public void fillInfo(ArrayList<String> titles, ArrayList<String> episodeNumbers, ArrayList<String> datesRelease, ArrayList<String> yearsRelease) {
        listView.setAdapter(new EpisodeListAdapter(getActivity(), titles, episodeNumbers, datesRelease, yearsRelease));
    }
}
