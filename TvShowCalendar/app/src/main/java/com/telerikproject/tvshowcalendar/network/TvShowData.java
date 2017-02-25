package com.telerikproject.tvshowcalendar.network;

import com.telerikproject.tvshowcalendar.models.TvShowModel;
import com.telerikproject.tvshowcalendar.models.base.IPopularTvShowsModel;
import com.telerikproject.tvshowcalendar.models.base.ITvShowModel;
import com.telerikproject.tvshowcalendar.network.base.ITvShowData;
import com.telerikproject.tvshowcalendar.utils.base.IJsonParser;
import com.telerikproject.tvshowcalendar.utils.base.IOkHttpRequester;
import com.telerikproject.tvshowcalendar.utils.base.IOkHttpResponse;

import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import okhttp3.ResponseBody;

public class TvShowData implements ITvShowData {

    private final IOkHttpRequester okHttpRequester;


    private final IJsonParser jsonParser;

    private final Type tvShowModelType;
    private final Type popularTvShowsType;

    @Inject
    public TvShowData(IOkHttpRequester okHttpRequester, IJsonParser jsonParser, Type tvShowModelType, Type popularTvShowsType) {
        this.okHttpRequester = okHttpRequester;
        this.jsonParser = jsonParser;
        this.tvShowModelType = tvShowModelType;
        this.popularTvShowsType = popularTvShowsType;
    }

    @Override
    public Observable<IPopularTvShowsModel> getTopTvShows() {
        return okHttpRequester.get("https://api.themoviedb.org/3/tv/popular?api_key=f0da25f6492c7f3f3c1b40fa29de8f6c")
                .map(new Function<IOkHttpResponse, IPopularTvShowsModel>() {
                    @Override
                    public IPopularTvShowsModel apply(IOkHttpResponse okHttpResponse) throws Exception {
                        ResponseBody respBody = okHttpResponse.getBody();
                        IPopularTvShowsModel tvShows = jsonParser.fromJson(respBody.string(), popularTvShowsType);

                        return tvShows;
                    }
                });
    }
}
