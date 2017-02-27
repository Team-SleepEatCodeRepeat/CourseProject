package com.telerikproject.tvshowcalendar.views.home;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import com.telerikproject.tvshowcalendar.BaseApplication;
import com.telerikproject.tvshowcalendar.R;
import com.telerikproject.tvshowcalendar.adapters.GridAdapter;
import com.telerikproject.tvshowcalendar.fragments.ILoadingFragment;
import com.telerikproject.tvshowcalendar.models.TvShowModel;
import com.telerikproject.tvshowcalendar.models.base.IPopularTvShowsModel;
import com.telerikproject.tvshowcalendar.modules.ControllerModule;
import com.telerikproject.tvshowcalendar.network.base.ITvShowData;
import com.telerikproject.tvshowcalendar.views.home.base.IHomeContract;

import java.util.ArrayList;
import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class HomeContentFragment extends Fragment implements IHomeContract.View {

    private IHomeContract.Presenter presenter;

    @Inject
    ILoadingFragment loadingFragment;

    @Inject
    public Activity mActivity;

    @Inject
    ITvShowData tvShowData;


   public ArrayList<String> moviesImages;
// = {R.drawable.the_originals, R.drawable.game_of_thrones,
//            R.drawable.mr_robot, R.drawable.the_big_bang_theory,
//            R.drawable.the_vampire_diaries, R.drawable.un_barco_en_el_espejo};

    public ArrayList<String> moviesTitles;
    public ArrayList<String> moviesRating;
    public ArrayList<Integer> moviesIds;
    GridView gridView;


    public HomeContentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_content, container, false);
        injectDependencies();
        BaseApplication.bind(this, view);

        this.moviesImages = new ArrayList<>();
        this.moviesTitles = new ArrayList<>();
        this.moviesRating = new ArrayList<>();
        this.moviesIds = new ArrayList<>();

        ILoadingFragment loading = loadingFragment.create(mActivity);

        getTopTvShows(loading);


        gridView = (GridView) view.findViewById(R.id.gv_top_10);
//        gridView.setAdapter(new GridAdapter(mActivity, moviesTitles, moviesRating, moviesImages));

        return view;
    }


    @Override
    public void setPresenter(IHomeContract.Presenter presenter) {
        this.presenter = presenter;
    }

    private void injectDependencies() {
        BaseApplication
                .from(getContext())
                .getAppComponent()
                .getControllerComponent(new ControllerModule(
                        getActivity(), getFragmentManager()
                ))
                .inject(this);
    }

    private void getTopTvShows(final ILoadingFragment loading) {
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

                        for(TvShowModel tvShow: tvShows) {
                            String poster = "https://image.tmdb.org/t/p/w640" + tvShow.getPoster();
                            String name = tvShow.getName();
                            double vote = (double) Math.round(tvShow.getVote() * 10) / 10;
                            int id = tvShow.getId();
                            moviesImages.add(poster);
                            moviesTitles.add(name);
                            moviesRating.add(vote + " / 10");
                            moviesIds.add(id);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                        gridView.setAdapter(new GridAdapter(mActivity, moviesTitles, moviesRating, moviesImages, moviesIds));
                        loading.hide();
                    }
                });
    }
}
