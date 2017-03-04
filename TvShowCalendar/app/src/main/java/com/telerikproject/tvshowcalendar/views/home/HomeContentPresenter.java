package com.telerikproject.tvshowcalendar.views.home;

import com.telerikproject.tvshowcalendar.fragments.ILoadingFragment;
import com.telerikproject.tvshowcalendar.models.popularTvShows.TvShowModel;
import com.telerikproject.tvshowcalendar.models.popularTvShows.base.IPopularTvShowsModel;
import com.telerikproject.tvshowcalendar.data.base.ITvShowData;
import com.telerikproject.tvshowcalendar.views.home.base.IHomeContract;

import java.util.ArrayList;

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
    public void getTopTvShows(final ILoadingFragment loading) {
        final ArrayList<String> posters = new ArrayList<>();
        final ArrayList<String> names = new ArrayList<>();
        final ArrayList<String> ids = new ArrayList<>();
        final ArrayList<String> votes = new ArrayList<>();


        tvShowData.getTopTvShows()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<IPopularTvShowsModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        loading.show();
                    }

                    @Override
                    public void onNext(IPopularTvShowsModel value) {

                        ArrayList<TvShowModel> tvShows = value.getResults();

                        for (TvShowModel tvShow : tvShows) {
                            String poster = "https://image.tmdb.org/t/p/w640" + tvShow.getPoster();
                            String name = tvShow.getName();
                            String vote = String.valueOf((double) Math.round(tvShow.getVote() * 10) / 10 + " / 10");
                            String id = String.valueOf(tvShow.getId());

                            posters.add(poster);
                            names.add(name);
                            ids.add(id);
                            votes.add(vote);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                        view.fillInfo(names, posters, ids, votes);
                        loading.hide();
                    }
                });
    }
}

