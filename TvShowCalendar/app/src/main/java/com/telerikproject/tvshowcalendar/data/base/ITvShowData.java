package com.telerikproject.tvshowcalendar.data.base;


import com.telerikproject.tvshowcalendar.models.ITvShow;
import com.telerikproject.tvshowcalendar.models.detailedTvShow.base.IDetailedTvShowModel;
import com.telerikproject.tvshowcalendar.models.popularTvShows.base.IPopularTvShowsModel;
import com.telerikproject.tvshowcalendar.models.popularTvShows.base.ITvShowModel;
import com.telerikproject.tvshowcalendar.models.season.base.ITvShowSeasonModel;

import java.util.List;

import io.reactivex.Observable;


public interface ITvShowData {
    Observable<List<ITvShow>> getTopTvShows();

    Observable<IDetailedTvShowModel> getTvShow(String id);

    Observable<ITvShowSeasonModel> getTvShowSeasonEpisodes(String seasonNumber, String tvShowId);

    Observable<List<ITvShow>> getTvShowsByQuery(String query);
}
