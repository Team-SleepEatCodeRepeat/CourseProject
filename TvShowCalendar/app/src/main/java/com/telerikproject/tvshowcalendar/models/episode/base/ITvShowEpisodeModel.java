package com.telerikproject.tvshowcalendar.models.episode.base;

import com.telerikproject.tvshowcalendar.models.misc.CrewMemberModel;
import com.telerikproject.tvshowcalendar.models.misc.GuestStarModel;

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
