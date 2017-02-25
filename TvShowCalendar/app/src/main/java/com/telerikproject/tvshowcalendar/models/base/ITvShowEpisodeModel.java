package com.telerikproject.tvshowcalendar.models.base;

import com.telerikproject.tvshowcalendar.models.CrewMemberModel;

import java.util.ArrayList;

public interface ITvShowEpisodeModel {
    String getAirDate();
    ArrayList<CrewMemberModel> getCrew();
    int getEpisodeNumber();
    ArrayList<String> getGuestStars();
    String getName();
    String getOverview();
    int getId();
    String getProductionCode();
    String getStillPath();
    double getVoteAverage();
    double getVoteCount();
}
