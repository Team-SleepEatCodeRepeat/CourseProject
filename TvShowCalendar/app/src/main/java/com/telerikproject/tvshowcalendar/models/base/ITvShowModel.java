package com.telerikproject.tvshowcalendar.models.base;

import java.util.ArrayList;

public interface ITvShowModel {
    String getPoster();

    String getPopularity();

    String getBackdrop();

    double getVote();

    String getOverview();

    String getFirstAirDate();

    ArrayList<String> getOriginCountry();

    ArrayList<Integer> getGenreIds();

    String getOriginalLanguage();

    int getVoteCount();

    String getName();

    String getOriginalName();
}
