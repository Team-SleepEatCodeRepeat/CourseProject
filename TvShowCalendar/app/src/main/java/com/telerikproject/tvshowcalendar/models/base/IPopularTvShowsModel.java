package com.telerikproject.tvshowcalendar.models.base;

import com.telerikproject.tvshowcalendar.models.TvShowModel;

import java.util.ArrayList;
import java.util.List;

public interface IPopularTvShowsModel {
    ArrayList<TvShowModel> getResults();
}
