package com.telerikproject.tvshowcalendar.data;

import com.telerikproject.tvshowcalendar.constants.base.ITheMovieDbConstants;
import com.telerikproject.tvshowcalendar.models.detailedTvShow.base.IDetailedTvShowModel;
import com.telerikproject.tvshowcalendar.models.popularTvShows.base.IPopularTvShowsModel;
import com.telerikproject.tvshowcalendar.models.season.base.ITvShowSeasonModel;
import com.telerikproject.tvshowcalendar.data.base.ITvShowData;
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
    private final Type tvShowSeasonModelType;

    @Inject
    public TvShowData(IOkHttpRequester okHttpRequester, IJsonParser jsonParser, Type tvShowModelType, Type popularTvShowsType,
                      Type detailedTvShowType, Type tvShowSeasonModelType, ITheMovieDbConstants tmdbConstants) {
        this.okHttpRequester = okHttpRequester;
        this.jsonParser = jsonParser;
        this.tvShowModelType = tvShowModelType;
        this.popularTvShowsType = popularTvShowsType;
        this.detailedTvShowModelType  = detailedTvShowType;
        this.tvShowSeasonModelType = tvShowSeasonModelType;
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

    @Override
    public Observable<ITvShowSeasonModel> getTvShowSeasonEpisodes(final String seasonNumber, final String tvShowId) {
        return okHttpRequester.get(tmdbConstants.getSeasonDetailsUrl(tvShowId, Integer.valueOf(seasonNumber)))
                .map(new Function<IOkHttpResponse, ITvShowSeasonModel>() {
                    @Override
                    public ITvShowSeasonModel apply(IOkHttpResponse okHttpResponse) throws Exception {
                        ResponseBody respBody = okHttpResponse.getBody();
                        ITvShowSeasonModel season = jsonParser.fromJson(respBody.string(), tvShowSeasonModelType);

                        return season;
                    }
                });
    }
}
