package com.telerikproject.tvshowcalendar.modules;

import android.app.Application;
import android.content.Context;
import android.support.v4.app.FragmentManager;

import com.telerikproject.tvshowcalendar.constants.TheMovieDbConstants;
import com.telerikproject.tvshowcalendar.constants.base.ITheMovieDbConstants;
import com.telerikproject.tvshowcalendar.factories.HttpResponseFactory;
import com.telerikproject.tvshowcalendar.factories.base.IHttpResponseFactory;
import com.telerikproject.tvshowcalendar.fragments.ILoadingFragment;
import com.telerikproject.tvshowcalendar.fragments.LoadingFragment;
import com.telerikproject.tvshowcalendar.modules.annotations.DetailedTvShowModel;
import com.telerikproject.tvshowcalendar.modules.annotations.PopularTvShowsResultModel;
import com.telerikproject.tvshowcalendar.modules.annotations.TvShowModel;
import com.telerikproject.tvshowcalendar.modules.annotations.TvShowSeasonModel;
import com.telerikproject.tvshowcalendar.network.TvShowData;
import com.telerikproject.tvshowcalendar.network.base.ITvShowData;
import com.telerikproject.tvshowcalendar.utils.GsonParser;
import com.telerikproject.tvshowcalendar.utils.OkHttpRequester;
import com.telerikproject.tvshowcalendar.utils.base.IJsonParser;
import com.telerikproject.tvshowcalendar.utils.base.IOkHttpRequester;
import com.telerikproject.tvshowcalendar.utils.base.IOkHttpResponse;

import java.lang.reflect.Type;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private final Application application;

    @Inject
    public ApplicationModule(Application application) {

        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return this.application;
    }

    @Inject
    @Provides
    IOkHttpRequester provideOkHttpRequester(IHttpResponseFactory httpResponseFactory) {
        return new OkHttpRequester(httpResponseFactory);
    }


    @Provides
    IHttpResponseFactory provideHttpResponseFactory() {
        return new HttpResponseFactory();
    }

    @Provides
    IJsonParser provideJsonParser() {
        return new GsonParser();
    }

    @Provides
    @TvShowModel
    Type provideTvShowModelType() {
        return com.telerikproject.tvshowcalendar.models.TvShowModel.class;
    }

    @Provides
    @DetailedTvShowModel
    Type provideDetailedTvShowModelType() {
        return com.telerikproject.tvshowcalendar.models.DetailedTvShowModel.class;
    }

    @Provides
    @PopularTvShowsResultModel
    Type providePopularTvShows() {
        return com.telerikproject.tvshowcalendar.models.PopularTvShowsResultModel.class;
    }

    @Provides
    @TvShowSeasonModel
    Type provideTvShowSeasonModelType() {
        return com.telerikproject.tvshowcalendar.models.TvShowSeasonModel.class;
    }

    @Inject
    @Provides
    ITvShowData provideTvShowData(IOkHttpRequester okHttpRequester, IJsonParser jsonParser,
                                  @TvShowModel Type tvShowModelType, @PopularTvShowsResultModel Type TopTvShows,
                                  @DetailedTvShowModel Type detailedTvShowModelType, @TvShowSeasonModel Type tvShowSeasonModelType,
                                  ITheMovieDbConstants tmdbConstants) {
        return new TvShowData(okHttpRequester, jsonParser, tvShowModelType, TopTvShows, detailedTvShowModelType, tvShowSeasonModelType, tmdbConstants);
    }

    @Provides
    ILoadingFragment provideLoadingFragment() {
        return new LoadingFragment();
    }

    @Provides
    ITheMovieDbConstants provideTMDBConstants() {
        return new TheMovieDbConstants();
    }
}
