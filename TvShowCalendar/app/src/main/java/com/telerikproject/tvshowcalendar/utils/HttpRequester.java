package com.telerikproject.tvshowcalendar.utils;

import com.telerikproject.tvshowcalendar.factories.base.IHttpResponseFactory;
import com.telerikproject.tvshowcalendar.utils.base.IHttpRequester;
import com.telerikproject.tvshowcalendar.utils.base.IHttpResponse;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpRequester implements IHttpRequester {

    private final IHttpResponseFactory httpResponseFactory;
    private final OkHttpClient okHttpClient;

    @Inject
    public HttpRequester(IHttpResponseFactory HttpResponseFactory) {
        this.httpResponseFactory = HttpResponseFactory;
        this.okHttpClient = new OkHttpClient();
    }

    @Override
    public Observable<IHttpResponse> get(final String url) {
            return Observable.defer(new Callable<ObservableSource<? extends IHttpResponse>>() {
                @Override
                public ObservableSource<? extends IHttpResponse> call() throws Exception {
                    Request request = new Request.Builder().url(url).build();

                    return createResponse(request);
                }
            });
    }

    @Override
    public Observable<IHttpResponse> post(final String url, final Map<String, String> body) {
        return Observable.defer(new Callable<ObservableSource<? extends IHttpResponse>>() {
            @Override
            public ObservableSource<? extends IHttpResponse> call() throws Exception {
                RequestBody requestBody = createRequestBody(body);

                Request request = new Request.Builder()
                        .url(url)
                        .post(requestBody)
                        .build();

                return createResponse(request);
            }
        });
    }

    private Observable<IHttpResponse> createResponse(Request request) {
        try {
            Response response = this.okHttpClient.newCall(request).execute();

            IHttpResponse parsedResponse = httpResponseFactory.createResponse(response.body().string());

            return Observable.just(parsedResponse);


        } catch (IOException e) {
            return Observable.error(e);
        }

    }


    private RequestBody createRequestBody(Map<String, String> bodyMap) {
        FormBody.Builder bodyBuilder = new FormBody.Builder();

        for (Map.Entry<String, String> pair : bodyMap.entrySet()) {
            bodyBuilder.add(pair.getKey(), pair.getValue());
        }

        RequestBody requestBody = bodyBuilder.build();
        return requestBody;
    }
}
