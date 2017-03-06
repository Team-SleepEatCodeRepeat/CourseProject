package com.telerikproject.tvshowcalendar.constants.base;

public interface ITheMovieDbConstants {
    String getPopularTvShowsUrl();

    String getSearchTvShowUrl(String searchString);

    String getTvDetailsUrl(String id);

    String getSeasonDetailsUrl(String id, int seasonNumber);

    String getEpisodeDetailsUrl(String id, int seasonNumber, int episodeNumber);

    String getImageUrl();
}
