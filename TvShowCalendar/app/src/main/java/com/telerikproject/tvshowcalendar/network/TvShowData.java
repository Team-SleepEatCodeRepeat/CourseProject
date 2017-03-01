package com.telerikproject.tvshowcalendar.network;

import com.telerikproject.tvshowcalendar.constants.TheMovieDbConstants;
import com.telerikproject.tvshowcalendar.constants.base.ITheMovieDbConstants;
import com.telerikproject.tvshowcalendar.models.base.IDetailedTvShowModel;
import com.telerikproject.tvshowcalendar.models.base.IDetailedTvShowSeasonModel;
import com.telerikproject.tvshowcalendar.models.base.IPopularTvShowsModel;
import com.telerikproject.tvshowcalendar.models.base.ITvShowModel;
import com.telerikproject.tvshowcalendar.network.base.ITvShowData;
import com.telerikproject.tvshowcalendar.utils.base.IJsonParser;
import com.telerikproject.tvshowcalendar.utils.base.IOkHttpRequester;
import com.telerikproject.tvshowcalendar.utils.base.IOkHttpResponse;

import java.lang.reflect.Type;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import okhttp3.ResponseBody;

public class TvShowData implements ITvShowData {

    private final IOkHttpRequester okHttpRequester;
    private final IJsonParser jsonParser;
    private final ITheMovieDbConstants tmdbConstants;
    private final Type tvShowModelType;
    private final Type popularTvShowsType;
    private final Type detailedTvShowModelType;

    @Inject
    public TvShowData(IOkHttpRequester okHttpRequester, IJsonParser jsonParser, Type tvShowModelType, Type popularTvShowsType, Type detailedTvShowType, ITheMovieDbConstants tmdbConstants) {
        this.okHttpRequester = okHttpRequester;
        this.jsonParser = jsonParser;
        this.tvShowModelType = tvShowModelType;
        this.popularTvShowsType = popularTvShowsType;
        this.detailedTvShowModelType  = detailedTvShowType;
        this.tmdbConstants = tmdbConstants;
    }

    @Override
    public Observable<IPopularTvShowsModel> getTopTvShows() {
        return okHttpRequester.get(tmdbConstants.getPopularTvShowsUrl())
                .map(new Function<IOkHttpResponse, IPopularTvShowsModel>() {
                    @Override
                    public IPopularTvShowsModel apply(IOkHttpResponse okHttpResponse) throws Exception {
                        ResponseBody respBody = okHttpResponse.getBody();
                        IPopularTvShowsModel tvShows = jsonParser.fromJson(respBody.string(), popularTvShowsType);

                        return tvShows;
                    }
                });
    }

    @Override
    public Observable<IDetailedTvShowModel> getTvShow(String id) {
        return okHttpRequester.get(tmdbConstants.getTvDetailsUrl(id))
                .map(new Function<IOkHttpResponse, IDetailedTvShowModel>() {
                    @Override
                    public IDetailedTvShowModel apply(IOkHttpResponse okHttpResponse) throws Exception {
                        ResponseBody respBody = okHttpResponse.getBody();
                        IDetailedTvShowModel tvShow = jsonParser.fromJson(respBody.string(), detailedTvShowModelType);
                        return tvShow;

                    }
                });
    }
}
