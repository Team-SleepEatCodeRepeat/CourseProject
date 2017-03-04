package com.telerikproject.tvshowcalendar.models.popularTvShows.base;

import com.telerikproject.tvshowcalendar.models.popularTvShows.TvShowModel;

import java.util.ArrayList;

public interface IPopularTvShowsModel {
    ArrayList<TvShowModel> getResults();
}
