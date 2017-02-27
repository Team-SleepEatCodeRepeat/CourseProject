package com.telerikproject.tvshowcalendar.models.base;

import com.telerikproject.tvshowcalendar.models.CreatorModel;
import com.telerikproject.tvshowcalendar.models.DetailedTvShowSeasonModel;
import com.telerikproject.tvshowcalendar.models.NetworksGenresModel;

import java.util.ArrayList;

public interface IDetailedTvShowModel {
    String getBackdropPath();
    int getVoteCount();
    double getVoteAverage();
    String getType();
    String getStatus();
    ArrayList<DetailedTvShowSeasonModel> getSeasons();
    ArrayList<NetworksGenresModel> getProductionCompanies();
    double getPopularity();
    String getOverview();
    String getOriginalName();
    String getOriginalLanguage();
    ArrayList<String> getOriginCountry();
    int getNumberOfSeasons();
    int getNumberOfEpisodes();
    ArrayList<NetworksGenresModel> getNetworks();
    String getName();
    String getLastAirDate();
    ArrayList<String> getLanguages();
    boolean isInProduction();
    int getId();
    String getHomepage();
    ArrayList<NetworksGenresModel> getGenres();
    String getFirstAirDate();
    ArrayList<Integer> getEpisodeRunTime();
    ArrayList<CreatorModel> getCreatedBy();

}
