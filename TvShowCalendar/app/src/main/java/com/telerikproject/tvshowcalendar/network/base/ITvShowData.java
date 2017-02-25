package com.telerikproject.tvshowcalendar.network.base;


import com.telerikproject.tvshowcalendar.models.base.IPopularTvShowsModel;

import io.reactivex.Observable;


public interface ITvShowData {
    Observable<IPopularTvShowsModel> getTopTvShows();
}
