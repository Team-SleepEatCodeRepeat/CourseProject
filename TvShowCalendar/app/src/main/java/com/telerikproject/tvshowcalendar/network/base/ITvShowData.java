package com.telerikproject.tvshowcalendar.network.base;


import com.telerikproject.tvshowcalendar.models.base.IDetailedTvShowModel;
import com.telerikproject.tvshowcalendar.models.base.IPopularTvShowsModel;
import com.telerikproject.tvshowcalendar.models.base.ITvShowModel;

import io.reactivex.Observable;


public interface ITvShowData {
    Observable<IPopularTvShowsModel> getTopTvShows();

    Observable<IDetailedTvShowModel> getTvShow(int id);
}
