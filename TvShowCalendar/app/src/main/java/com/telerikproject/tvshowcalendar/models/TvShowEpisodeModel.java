package com.telerikproject.tvshowcalendar.models;

import com.telerikproject.tvshowcalendar.models.base.ITvShowEpisodeModel;

import java.util.ArrayList;

public class TvShowEpisodeModel implements ITvShowEpisodeModel {

    private String air_date;

    private ArrayList<CrewMemberModel> crew;

    private int episode_number;

    private ArrayList<GuestStarModel> guest_stars;

    private String name;

    private String overview;

    private int id;

    private String production_code;

    private String still_path;

    private double vote_average;

    private int vote_count;

    public TvShowEpisodeModel() {

    }

    public TvShowEpisodeModel(String air_date, ArrayList<CrewMemberModel> crew, int episode_number,
                              ArrayList<GuestStarModel> guest_stars, String name, String overview, int id,
                              String production_code, String still_path, double vote_average, int vote_count) {
        this.air_date = air_date;
        this.crew = crew;
        this.episode_number = episode_number;
        this.guest_stars = guest_stars;
        this.name = name;
        this.overview = overview;
        this.id = id;
        this.production_code = production_code;
        this.still_path = still_path;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
    }

    @Override
    public String getAirDate() {
        return air_date;
    }

    @Override
    public ArrayList<CrewMemberModel> getCrew() {
        return crew;
    }

    @Override
    public int getEpisodeNumber() {
        return episode_number;
    }

    @Override
    public ArrayList<GuestStarModel> getGuestStars() {
        return guest_stars;
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
    public String getProductionCode() {
        return production_code;
    }

    @Override
    public String getStillPath() {
        return still_path;
    }

    @Override
    public double getVoteAverage() {
        return vote_average;
    }

    @Override
    public int getVoteCount() {
        return vote_count;
    }
}
