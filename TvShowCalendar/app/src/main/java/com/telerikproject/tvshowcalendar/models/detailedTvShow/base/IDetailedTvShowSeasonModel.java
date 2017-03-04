package com.telerikproject.tvshowcalendar.models.detailedTvShow.base;

public interface IDetailedTvShowSeasonModel {
    int getSeasonNumber();
    String getPosterPath();
    int getId();
    int getEpisodeCount();
    String getAirDate();
}
