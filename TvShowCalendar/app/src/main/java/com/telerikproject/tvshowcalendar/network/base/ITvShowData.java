package com.telerikproject.tvshowcalendar.network.base;


import com.telerikproject.tvshowcalendar.models.base.IDetailedTvShowModel;
import com.telerikproject.tvshowcalendar.models.base.IPopularTvShowsModel;
import com.telerikproject.tvshowcalendar.models.base.ITvShowModel;
import com.telerikproject.tvshowcalendar.models.base.ITvShowSeasonModel;

import io.reactivex.Observable;


public interface ITvShowData {
    Observable<IPopularTvShowsModel> getTopTvShows();

    Observable<IDetailedTvShowModel> getTvShow(String id);

    Observable<ITvShowSeasonModel> getTvShowSeasonEpisodes(String seasonNumber, String tvShowId);
}
