package com.telerikproject.tvshowcalendar.models.base;

import com.telerikproject.tvshowcalendar.models.CrewMemberModel;
import com.telerikproject.tvshowcalendar.models.GuestStarModel;

import java.util.ArrayList;

public interface ITvShowEpisodeModel {
    String getAirDate();
    ArrayList<CrewMemberModel> getCrew();
    int getEpisodeNumber();
    ArrayList<GuestStarModel> getGuestStars();
    String getName();
    String getOverview();
    int getId();
    String getProductionCode();
    String getStillPath();
    double getVoteAverage();
    int getVoteCount();
}
