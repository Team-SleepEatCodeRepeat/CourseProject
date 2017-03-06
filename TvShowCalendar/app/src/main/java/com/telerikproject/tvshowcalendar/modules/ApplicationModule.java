package com.telerikproject.tvshowcalendar.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.telerikproject.tvshowcalendar.constants.ApiConstants;
import com.telerikproject.tvshowcalendar.constants.TheMovieDbConstants;
import com.telerikproject.tvshowcalendar.constants.base.IApiConstants;
import com.telerikproject.tvshowcalendar.constants.base.ITheMovieDbConstants;
import com.telerikproject.tvshowcalendar.data.UserData;
import com.telerikproject.tvshowcalendar.data.base.IUserData;
import com.telerikproject.tvshowcalendar.factories.HttpResponseFactory;
import com.telerikproject.tvshowcalendar.factories.base.IHttpResponseFactory;
import com.telerikproject.tvshowcalendar.fragments.base.ILoadingFragment;
import com.telerikproject.tvshowcalendar.fragments.LoadingFragment;
import com.telerikproject.tvshowcalendar.modules.annotations.ApplicationContext;
import com.telerikproject.tvshowcalendar.modules.annotations.DetailedTvShowModel;
import com.telerikproject.tvshowcalendar.modules.annotations.PopularTvShowsResultModel;
import com.telerikproject.tvshowcalendar.modules.annotations.TvShowModel;
import com.telerikproject.tvshowcalendar.modules.annotations.TvShowSeasonModel;
import com.telerikproject.tvshowcalendar.data.TvShowData;
import com.telerikproject.tvshowcalendar.data.base.ITvShowData;
import com.telerikproject.tvshowcalendar.modules.annotations.UserModel;
import com.telerikproject.tvshowcalendar.utils.GsonParser;
import com.telerikproject.tvshowcalendar.utils.OkHttpRequester;
import com.telerikproject.tvshowcalendar.utils.base.IJsonParser;
import com.telerikproject.tvshowcalendar.utils.base.IOkHttpRequester;
import com.telerikproject.tvshowcalendar.utils.userSession.UserSession;
import com.telerikproject.tvshowcalendar.utils.userSession.base.IUserSession;

import java.lang.reflect.Type;

import javax.inject.Inject;

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
    @ApplicationContext
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
        return com.telerikproject.tvshowcalendar.models.popularTvShows.TvShowModel.class;
    }

    @Provides
    @DetailedTvShowModel
    Type provideDetailedTvShowModelType() {
        return com.telerikproject.tvshowcalendar.models.detailedTvShow.DetailedTvShowModel.class;
    }

    @Provides
    @PopularTvShowsResultModel
    Type providePopularTvShows() {
        return com.telerikproject.tvshowcalendar.models.popularTvShows.PopularTvShowsResultModel.class;
    }

    @Provides
    @TvShowSeasonModel
    Type provideTvShowSeasonModelType() {
        return com.telerikproject.tvshowcalendar.models.season.TvShowSeasonModel.class;
    }

    @Provides
    @UserModel
    Type provideUserModelType() {
        return com.telerikproject.tvshowcalendar.models.user.UserModel.class;
    }

    @Inject
    @Provides
    ITvShowData provideTvShowData(IOkHttpRequester okHttpRequester, IJsonParser jsonParser,
                                  @TvShowModel Type tvShowModelType, @PopularTvShowsResultModel Type TopTvShows,
                                  @DetailedTvShowModel Type detailedTvShowModelType, @TvShowSeasonModel Type tvShowSeasonModelType,
                                  ITheMovieDbConstants tmdbConstants) {
        return new TvShowData(okHttpRequester, jsonParser, tvShowModelType, TopTvShows, detailedTvShowModelType, tvShowSeasonModelType, tmdbConstants);
    }

    @Inject
    @Provides
    IUserData provideUserData(IOkHttpRequester okHttpRequester, IJsonParser jsonParser,
                              IApiConstants apiConstants, IUserSession userSession, @UserModel Type userModelType) {
        return new UserData(okHttpRequester, jsonParser, userSession, apiConstants, userModelType);
    }

    @Inject
    @Provides
    SharedPreferences provideSharedPreferences(@ApplicationContext Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Inject
    @Provides
    IUserSession provideUserSession(SharedPreferences sharedPreferences) {
        return new UserSession(sharedPreferences);
    }

    @Provides
    IApiConstants provideApiConstants() {
        return new ApiConstants();
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
