package com.telerikproject.tvshowcalendar.data;

import com.telerikproject.tvshowcalendar.constants.base.ITheMovieDbConstants;
import com.telerikproject.tvshowcalendar.models.ITvShow;
import com.telerikproject.tvshowcalendar.models.TvShow;
import com.telerikproject.tvshowcalendar.models.detailedTvShow.base.IDetailedTvShowModel;
import com.telerikproject.tvshowcalendar.models.popularTvShows.TvShowModel;
import com.telerikproject.tvshowcalendar.models.popularTvShows.base.IPopularTvShowsModel;
import com.telerikproject.tvshowcalendar.models.season.base.ITvShowSeasonModel;
import com.telerikproject.tvshowcalendar.data.base.ITvShowData;
import com.telerikproject.tvshowcalendar.utils.base.IJsonParser;
import com.telerikproject.tvshowcalendar.utils.base.IHttpRequester;
import com.telerikproject.tvshowcalendar.utils.base.IHttpResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class TvShowData implements ITvShowData {

    private final IHttpRequester okHttpRequester;
    private final IJsonParser jsonParser;
    private final ITheMovieDbConstants tmdbConstants;
    private final Type tvShowModelType;
    private final Type popularTvShowsType;
    private final Type detailedTvShowModelType;
    private final Type tvShowSeasonModelType;

    @Inject
    public TvShowData(IHttpRequester okHttpRequester, IJsonParser jsonParser, Type tvShowModelType, Type popularTvShowsType,
                      Type detailedTvShowType, Type tvShowSeasonModelType, ITheMovieDbConstants tmdbConstants) {
        this.okHttpRequester = okHttpRequester;
        this.jsonParser = jsonParser;
        this.tvShowModelType = tvShowModelType;
        this.popularTvShowsType = popularTvShowsType;
        this.detailedTvShowModelType = detailedTvShowType;
        this.tvShowSeasonModelType = tvShowSeasonModelType;
        this.tmdbConstants = tmdbConstants;
    }

    @Override
    public Observable<List<ITvShow>> getTopTvShows() {
        return okHttpRequester.get(tmdbConstants.getPopularTvShowsUrl())
                .map(new Function<IHttpResponse, List<ITvShow>>() {
                    @Override
                    public List<ITvShow> apply(IHttpResponse okHttpResponse) throws Exception {
                        String respBody = okHttpResponse.getBody();
                        IPopularTvShowsModel tvShows = jsonParser.fromJson(respBody, popularTvShowsType);

                        List<TvShowModel> tvShowModels = tvShows.getResults();
                        return parseTvShowModels(tvShowModels);
                    }
                });
    }

    @Override
    public Observable<IDetailedTvShowModel> getTvShow(String id) {
        return okHttpRequester.get(tmdbConstants.getTvDetailsUrl(id))
                .map(new Function<IHttpResponse, IDetailedTvShowModel>() {
                    @Override
                    public IDetailedTvShowModel apply(IHttpResponse okHttpResponse) throws Exception {
                        String respBody = okHttpResponse.getBody();
                        IDetailedTvShowModel tvShow = jsonParser.fromJson(respBody, detailedTvShowModelType);
                        return tvShow;

                    }
                });
    }

    @Override
    public Observable<ITvShowSeasonModel> getTvShowSeasonEpisodes(final String seasonNumber, final String tvShowId) {
        return okHttpRequester.get(tmdbConstants.getSeasonDetailsUrl(tvShowId, Integer.valueOf(seasonNumber)))
                .map(new Function<IHttpResponse, ITvShowSeasonModel>() {
                    @Override
                    public ITvShowSeasonModel apply(IHttpResponse okHttpResponse) throws Exception {
                        String respBody = okHttpResponse.getBody();
                        ITvShowSeasonModel season = jsonParser.fromJson(respBody, tvShowSeasonModelType);

                        return season;
                    }
                });
    }

    @Override
    public Observable<List<ITvShow>> getTvShowsByQuery(String query) {
        return okHttpRequester.get(tmdbConstants.getSearchTvShowUrl(query))
                .map(new Function<IHttpResponse, List<ITvShow>>() {
                    @Override
                    public List<ITvShow> apply(IHttpResponse okHttpResponse) throws Exception {
                        String respBody = okHttpResponse.getBody();
                        IPopularTvShowsModel tvShows = jsonParser.fromJson(respBody, popularTvShowsType);

                        List<TvShowModel> tvShowModels = tvShows.getResults();
                        return parseTvShowModels(tvShowModels);
                    }
                });
    }

    private List<ITvShow> parseTvShowModels(List<TvShowModel> tvShowModels) {
        final List<ITvShow> parsedTvShows = new ArrayList<>();

        for (TvShowModel tvShow : tvShowModels) {
            String poster = tmdbConstants.getImageUrl() + tvShow.getPoster();
            String name = tvShow.getName();
            String vote = String.valueOf((double) Math.round(tvShow.getVote() * 10) / 10 + " / 10");
            String id = String.valueOf(tvShow.getId());

            ITvShow parsedTvShow = new TvShow(id, name, vote, poster);
            parsedTvShows.add(parsedTvShow);
        }

        return parsedTvShows;
    }
}