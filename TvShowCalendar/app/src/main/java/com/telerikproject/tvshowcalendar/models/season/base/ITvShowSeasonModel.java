package com.telerikproject.tvshowcalendar.models.season.base;

import com.telerikproject.tvshowcalendar.models.episode.TvShowEpisodeModel;

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
