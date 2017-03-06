package com.telerikproject.tvshowcalendar.views.serialInfo;

import com.telerikproject.tvshowcalendar.fragments.base.ILoadingFragment;
import com.telerikproject.tvshowcalendar.models.detailedTvShow.base.IDetailedTvShowModel;
import com.telerikproject.tvshowcalendar.data.base.ITvShowData;
import com.telerikproject.tvshowcalendar.views.serialInfo.base.ISerialInfoContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SerialInfoContentPresenter implements ISerialInfoContract.Presenter {

    private ISerialInfoContract.View view;

    private final ITvShowData tvShowData;

    @Inject
    public SerialInfoContentPresenter(ITvShowData tvShowData) {
        this.tvShowData = tvShowData;
    }

    @Override
    public void load() {

    }

    @Override
    public void setView(ISerialInfoContract.View view) {
        this.view = view;
    }

    @Override
    public void getSerial(final String id, final ILoadingFragment loading) {
        tvShowData.getTvShow(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<IDetailedTvShowModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                        loading.show();
                    }

                    @Override
                    public void onNext(IDetailedTvShowModel value) {

                        String description = value.getOverview();
                        String image = String.format("%s%s", "https://image.tmdb.org/t/p/w640", value.getBackdropPath());
                        String rating = String.valueOf(value.getVoteAverage());
                        int numOfSeasons = value.getNumberOfSeasons();


                        view.setTitle(value.getName());
                        view.fillInfo(image, rating, description, numOfSeasons, id);
                    }

                    @Override
                    public void onError(Throwable e) {
                        int a = 5;
                    }

                    @Override
                    public void onComplete() {
                        loading.hide();
                    }
                });
    }
}
