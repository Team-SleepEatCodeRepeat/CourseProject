package com.telerikproject.tvshowcalendar.models;

import com.telerikproject.tvshowcalendar.models.base.IDetailedTvShowSeasonModel;

public class DetailedTvShowSeasonModel implements IDetailedTvShowSeasonModel {

    private String air_date;
    private int episode_count;
    private int id;
    private String poster_path;
    private int season_number;

    public DetailedTvShowSeasonModel() {

    }

    public DetailedTvShowSeasonModel(String air_date, int episode_count, int id, String poster_path, int season_number) {
        this.air_date = air_date;
        this.episode_count = episode_count;
        this.id = id;
        this.poster_path = poster_path;
        this.season_number = season_number;
    }

    @Override
    public int getSeasonNumber() {
        return season_number;
    }

    @Override
    public String getPosterPath() {
        return poster_path;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getEpisodeCount() {
        return episode_count;
    }

    @Override
    public String getAirDate() {
        return air_date;
    }
}
