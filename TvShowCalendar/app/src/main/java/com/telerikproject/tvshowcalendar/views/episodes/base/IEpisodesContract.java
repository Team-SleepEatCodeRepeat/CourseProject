package com.telerikproject.tvshowcalendar.views.episodes.base;

import com.telerikproject.tvshowcalendar.fragments.ILoadingFragment;
import com.telerikproject.tvshowcalendar.views.base.BasePresenter;
import com.telerikproject.tvshowcalendar.views.base.BaseView;

import java.util.ArrayList;

public interface IEpisodesContract {
    interface View extends BaseView<Presenter> {
        void fillInfo(ArrayList<String> titles, ArrayList<String> episodeNumbers, ArrayList<String> datesRelease, ArrayList<String> yearsRelease);
    }

    interface Presenter extends BasePresenter<View> {
        void getSeasonEpisodes(String seasonNumber, String tvShowId, ILoadingFragment loading);
    }
}
