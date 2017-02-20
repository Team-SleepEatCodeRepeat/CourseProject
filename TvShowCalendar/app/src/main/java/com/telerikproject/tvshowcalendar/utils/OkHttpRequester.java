package com.telerikproject.tvshowcalendar.utils;

import com.telerikproject.tvshowcalendar.factories.base.IHttpResponseFactory;
import com.telerikproject.tvshowcalendar.utils.base.IOkHttpRequester;
import com.telerikproject.tvshowcalendar.utils.base.IOkHttpResponse;

import java.io.IOException;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpRequester implements IOkHttpRequester {

    private final IHttpResponseFactory httpResponseFactory;
    private final OkHttpClient okHttpClient;

    @Inject
    public OkHttpRequester(IHttpResponseFactory HttpResponseFactory) {
        this.httpResponseFactory = HttpResponseFactory;
        this.okHttpClient = new OkHttpClient();
    }

    @Override
    public Observable<IOkHttpResponse> get(final String url) {
            return Observable.defer(new Callable<ObservableSource<? extends IOkHttpResponse>>() {
                @Override
                public ObservableSource<? extends IOkHttpResponse> call() throws Exception {
                    Request request = new Request.Builder().url(url).build();

                    return createResponse(request);
                }
            });
    }

    private Observable<IOkHttpResponse> createResponse(Request request) {
        try {
            Response response = this.okHttpClient.newCall(request).execute();

            IOkHttpResponse parsedResponse = httpResponseFactory.createResponse(response.body());

            return Observable.just(parsedResponse);


        } catch (IOException e) {
            return Observable.error(e);
        }

    }
}
