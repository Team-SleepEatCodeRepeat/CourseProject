package com.telerikproject.tvshowcalendar.constants;


import com.telerikproject.tvshowcalendar.constants.base.ITheMovieDbConstants;

public final class TheMovieDbConstants implements ITheMovieDbConstants {
    private static String tMDBApiKey = "?api_key=f0da25f6492c7f3f3c1b40fa29de8f6c";
    private static String tMDBApiUrl = "https://api.themoviedb.org/3";
    private static String tvShowsBaseUrl = String.format("%s/tv", tMDBApiUrl);
    private static String popularTvShows = String.format("%s/tv/popular%s", tMDBApiUrl, tMDBApiKey);


    @Override
    public String getPopularTvShowsUrl() {
        return popularTvShows;
    }

    @Override
    public String getSearchTvShowUrl(String query) {
        return String.format("%s/search/tv%s&language=en-US&query=%s&page=1", tMDBApiUrl, tMDBApiKey, query);
    }

    @Override
    public String getTvDetailsUrl(String serialId) {
        return String.format("%s/%s%s", tvShowsBaseUrl, serialId, tMDBApiKey);
    }

    @Override
    public String getSeasonDetailsUrl(String id, int seasonNumber) {
        return String.format("%s%s/season/%s", tvShowsBaseUrl, id, seasonNumber);
    }

    @Override
    public String getEpisodeDetailsUrl(String id, int seasonNumber, int episodeNumber) {
        return String.format("%s%s/season/%s/episode/%s%s", tvShowsBaseUrl, id, seasonNumber, episodeNumber, tMDBApiKey);
    }


}
