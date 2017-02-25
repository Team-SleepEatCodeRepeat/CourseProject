package com.telerikproject.tvshowcalendar.models.base;

import com.telerikproject.tvshowcalendar.models.TvShowEpisodeModel;

import java.util.ArrayList;

public interface ITvShowSeasonModel {
    String get_id();
    String getAirDate();
    ArrayList<TvShowEpisodeModel> getEpisodes();
    String getName();
    String getOverview();
    int getId();
    String getPosterPath();
    int getSeasonNumber();
}
