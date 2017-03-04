package com.telerikproject.tvshowcalendar.models.season;

import com.telerikproject.tvshowcalendar.models.episode.TvShowEpisodeModel;
import com.telerikproject.tvshowcalendar.models.season.base.ITvShowSeasonModel;

import java.util.ArrayList;

public class TvShowSeasonModel implements ITvShowSeasonModel {
    private String _id;

    private String air_date;

    private ArrayList<TvShowEpisodeModel> episodes;

    private String name;

    private String overview;

    private int id;

    private String poster_path;

    private int season_number;

    public TvShowSeasonModel() {

    }

    public TvShowSeasonModel(String _id, String air_date, ArrayList<TvShowEpisodeModel> episodes, String name, String overview,
                             int id, String poster_path, int season_number) {
        this._id = _id;
        this.air_date = air_date;
        this.episodes = episodes;
        this.name = name;
        this.overview = overview;
        this.id = id;
        this.poster_path = poster_path;
        this.season_number = season_number;
    }

    public TvShowSeasonModel(String _id, String air_date, ArrayList<TvShowEpisodeModel> episodes, String name, String overview,
                             int id, int season_number) {
        this._id = _id;
        this.air_date = air_date;
        this.episodes = episodes;
        this.name = name;
        this.overview = overview;
        this.id = id;
        this.season_number = season_number;
    }

    @Override
    public String get_id() {
        return _id;
    }

    @Override
    public String getAirDate() {
        return air_date;
    }

    @Override
    public ArrayList<TvShowEpisodeModel> getEpisodes() {
        return episodes;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getOverview() {
        return overview;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getPosterPath() {
        return poster_path;
    }

    @Override
    public int getSeasonNumber() {
        return season_number;
    }
}
