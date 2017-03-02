package com.telerikproject.tvshowcalendar.models;

import com.telerikproject.tvshowcalendar.models.base.ITvShowModel;

import java.util.ArrayList;


public class TvShowModel implements ITvShowModel {
    private String poster_path;
    private String popularity;
    private int id;
    private String backdrop_path;
    private double vote_average;
    private String overview;
    private String first_air_date;
    private ArrayList<String> origin_country;
    private ArrayList<Integer> genre_ids;
    private String original_language;
    private int vote_count;
    private String name;
    private String original_name;

    public TvShowModel() {

    }

    public TvShowModel(String poster_path, String popularity, int id, String backdrop_path, double vote_average, String overview,
                       String first_air_date, ArrayList<String> origin_country, ArrayList<Integer> genre_ids,
                       String original_language, int vote_count, String name, String original_name) {
        this.poster_path = poster_path;
        this.popularity = popularity;
        this.id = id;
        this.backdrop_path = backdrop_path;
        this.vote_average = vote_average;
        this.overview = overview;
        this.first_air_date = first_air_date;
        this.origin_country = origin_country;
        this.genre_ids = genre_ids;
        this.original_language = original_language;
        this.vote_count = vote_count;
        this.name = name;
        this.original_name = original_name;
    }

    public String getPoster() {
        return poster_path;
    }

    public String getPopularity() {
        return popularity;
    }

    public int getId() {
        return id;
    }

    public String getBackdrop() {
        return backdrop_path;
    }

    public double getVote() {
        return vote_average;
    }

    public String getOverview() {
        return overview;
    }

    public String getFirstAirDate() {
        return first_air_date;
    }

    public ArrayList<String> getOriginCountry() {
        return origin_country;
    }

    public ArrayList<Integer> getGenreIds() {
        return genre_ids;
    }

    public String getOriginalLanguage() {
        return original_language;
    }

    public int getVoteCount() {
        return vote_count;
    }

    public String getName() {
        return name;
    }

    public String getOriginalName() {
        return original_name;
    }
}
