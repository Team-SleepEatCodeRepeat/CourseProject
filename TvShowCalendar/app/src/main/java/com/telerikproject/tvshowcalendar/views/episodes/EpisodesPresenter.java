package com.telerikproject.tvshowcalendar.views.episodes;

import com.telerikproject.tvshowcalendar.fragments.ILoadingFragment;
import com.telerikproject.tvshowcalendar.models.episode.TvShowEpisodeModel;
import com.telerikproject.tvshowcalendar.models.season.base.ITvShowSeasonModel;
import com.telerikproject.tvshowcalendar.data.base.ITvShowData;
import com.telerikproject.tvshowcalendar.views.episodes.base.IEpisodesContract;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class EpisodesPresenter implements IEpisodesContract.Presenter {

    private IEpisodesContract.View view;

    ITvShowData tvShowData;

    public EpisodesPresenter(ITvShowData tvShowData) {
        this.tvShowData = tvShowData;
    }

    @Override
    public void load() {

    }

    @Override
    public void setView(IEpisodesContract.View view) {
        this.view = view;
    }

    @Override
    public void getSeasonEpisodes(String seasonNumber, String tvShowId, final ILoadingFragment loading) {
        final ArrayList<String> titles = new ArrayList<>();
        final ArrayList<String> episodeNumbers = new ArrayList<>();
        final ArrayList<String> datesRelease = new ArrayList<>();
        final ArrayList<String> yearsRelease = new ArrayList<>();

        tvShowData.getTvShowSeasonEpisodes(seasonNumber, tvShowId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ITvShowSeasonModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        loading.show();
                    }

                    @Override
                    public void onNext(ITvShowSeasonModel value) {
                        ArrayList<TvShowEpisodeModel> episodes = value.getEpisodes();

                        for (TvShowEpisodeModel episode : episodes) {
                            String title = episode.getName();
                            String number = String.valueOf(episode.getEpisodeNumber());
                            String airDate = episode.getAirDate();
                            String year = airDate.substring(0, 4);
                            String date = airDate.substring(5);

                            titles.add(title);
                            episodeNumbers.add(number);
                            datesRelease.add(date);
                            yearsRelease.add(year);
                        }

                        String title = String.format("Season %s", value.getSeasonNumber());
                        view.setTitle(title);
                    }

                    @Override
                    public void onError(Throwable e) {
                        int a = 5;
                    }

                    @Override
                    public void onComplete() {
                        view.fillInfo(titles, episodeNumbers, datesRelease, yearsRelease);
                        loading.hide();
                    }
                });
    }
}
