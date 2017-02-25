package com.telerikproject.tvshowcalendar.models;

import com.telerikproject.tvshowcalendar.models.base.IPopularTvShowsModel;

import java.util.ArrayList;
import java.util.List;

public class PopularTvShowsResultModel implements IPopularTvShowsModel{
    private int page;
    private ArrayList<TvShowModel> results;

    public PopularTvShowsResultModel() {

    }

    public PopularTvShowsResultModel(int page, ArrayList<TvShowModel> results) {
        this.page = page;
        this.results = results;
    }

    public ArrayList<TvShowModel> getResults() {
        return results;
    }

    public int getPage() {
        return page;
    }
}
