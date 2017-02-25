package com.telerikproject.tvshowcalendar.constants.base;

public interface ITheMovieDbConstants {
    String getPopularTvShowsUrl();

    String getSearchTvShowUrl(String searchString);

    String getTvDetailsUrl(int id);

    String getSeasonDetailsUrl(int id, int seasonNumber);

    String getEpisodeDetailsUrl(int id, int seasonNumber, int episodeNumber);
}
