package com.telerikproject.tvshowcalendar.models;

import com.telerikproject.tvshowcalendar.models.base.IDetailedTvShowModel;

import java.util.ArrayList;

public class DetailedTvShowModel implements IDetailedTvShowModel {
    private String backdrop_path;
    private ArrayList<CreatorModel> created_by;
    private ArrayList<Integer> episode_run_time;
    private String first_air_date;
    private ArrayList<NetworksGenresModel> genres;
    private String homepage;
    private int id;
    private boolean in_production;
    private ArrayList<String> languages;
    private String last_air_date;
    private String name;
    private ArrayList<NetworksGenresModel> networks;
    private int number_of_episodes;
    private int number_of_seasons;
    private ArrayList<String> origin_country;
    private String original_language;
    private String original_name;
    private String overview;
    private double popularity;
    private ArrayList<NetworksGenresModel> production_companies;
    private ArrayList<DetailedTvShowSeasonModel> seasons;
    private String status;
    private String type;
    private double vote_average;
    private int vote_count;

    public DetailedTvShowModel() {

    }

    public DetailedTvShowModel(String backdrop_path, ArrayList<CreatorModel> created_by, ArrayList<Integer> episode_run_time,
                               String first_air_date, ArrayList<NetworksGenresModel> genres, String homepage,
                               int id, boolean in_production, ArrayList<String> languages, String last_air_date,
                               String name, ArrayList<NetworksGenresModel> networks, int number_of_episodes,
                               int number_of_seasons, ArrayList<String> origin_country, String original_language, String original_name,
                               String overview, double popularity, ArrayList<NetworksGenresModel> production_companies,
                               ArrayList<DetailedTvShowSeasonModel> seasons, String status, String type, double vote_average, int vote_count) {
        this.backdrop_path = backdrop_path;
        this.created_by = created_by;
        this.episode_run_time = episode_run_time;
        this.first_air_date = first_air_date;
        this.genres = genres;
        this.homepage = homepage;
        this.id = id;
        this.in_production = in_production;
        this.languages = languages;
        this.last_air_date = last_air_date;
        this.name = name;
        this.networks = networks;
        this.number_of_episodes = number_of_episodes;
        this.number_of_seasons = number_of_seasons;
        this.origin_country = origin_country;
        this.original_language = original_language;
        this.original_name = original_name;
        this.overview = overview;
        this.popularity = popularity;
        this.production_companies = production_companies;
        this.seasons = seasons;
        this.status = status;
        this.type = type;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
    }

    @Override
    public String getBackdropPath() {
        return backdrop_path;
    }

    @Override
    public int getVoteCount() {
        return vote_count;
    }

    @Override
    public double getVoteAverage() {
        return vote_average;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public ArrayList<DetailedTvShowSeasonModel> getSeasons() {
        return seasons;
    }

    @Override
    public ArrayList<NetworksGenresModel> getProductionCompanies() {
        return production_companies;
    }

    @Override
    public double getPopularity() {
        return popularity;
    }

    @Override
    public String getOverview() {
        return overview;
    }

    @Override
    public String getOriginalName() {
        return original_name;
    }

    @Override
    public String getOriginalLanguage() {
        return original_language;
    }

    @Override
    public ArrayList<String> getOriginCountry() {
        return origin_country;
    }

    @Override
    public int getNumberOfSeasons() {
        return number_of_seasons;
    }

    @Override
    public int getNumberOfEpisodes() {
        return number_of_episodes;
    }

    @Override
    public ArrayList<NetworksGenresModel> getNetworks() {
        return networks;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLastAirDate() {
        return last_air_date;
    }

    @Override
    public ArrayList<String> getLanguages() {
        return languages;
    }

    @Override
    public boolean isInProduction() {
        return in_production;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getHomepage() {
        return homepage;
    }

    @Override
    public ArrayList<NetworksGenresModel> getGenres() {
        return genres;
    }

    @Override
    public String getFirstAirDate() {
        return first_air_date;
    }

    @Override
    public ArrayList<Integer> getEpisodeRunTime() {
        return episode_run_time;
    }

    @Override
    public ArrayList<CreatorModel> getCreatedBy() {
        return created_by;
    }
}
