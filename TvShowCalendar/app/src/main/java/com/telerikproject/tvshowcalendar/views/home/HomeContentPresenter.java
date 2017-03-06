package com.telerikproject.tvshowcalendar.views.home;

import com.telerikproject.tvshowcalendar.models.ITvShow;
import com.telerikproject.tvshowcalendar.data.base.ITvShowData;
import com.telerikproject.tvshowcalendar.views.home.base.IHomeContract;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeContentPresenter implements IHomeContract.Presenter {

    private IHomeContract.View view;

    ITvShowData tvShowData;

    @Inject
    public HomeContentPresenter(ITvShowData tvShowData) {
        this.tvShowData = tvShowData;
    }

    @Override
    public void load() {
    }

    @Override
    public void setView(IHomeContract.View view) {
        this.view = view;
    }

    @Override
    public void getTopTvShows() {
        tvShowData.getTopTvShows()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ITvShow>>() {
                    private List<ITvShow> parsedTvShows;

                    @Override
                    public void onSubscribe(Disposable d) {
                        view.startLoading();
                    }

                    @Override
                    public void onNext(List<ITvShow> value) {
                        parsedTvShows = value;
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.stopLoading();
                    }

                    @Override
                    public void onComplete() {
                        view.fillInfo(parsedTvShows);
                        view.stopLoading();
                    }
                });
    }

    @Override
    public void getTvShowsByQuery(final String query) {
        if (query == null || query.isEmpty()) {
            return;
        }
        tvShowData.getTvShowsByQuery(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ITvShow>>() {
                    private List<ITvShow> parsedTvShows;

                    @Override
                    public void onSubscribe(Disposable d) {
                        view.startLoading();
                    }

                    @Override
                    public void onNext(List<ITvShow> value) {
                        parsedTvShows = value;
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.stopLoading();
                    }

                    @Override
                    public void onComplete() {
                        view.fillInfo(parsedTvShows);
                        view.stopLoading();
                    }
                });
    }
}