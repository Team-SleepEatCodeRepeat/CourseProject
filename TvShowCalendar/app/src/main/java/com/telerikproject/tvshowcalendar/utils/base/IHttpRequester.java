package com.telerikproject.tvshowcalendar.utils.base;

import java.util.Map;

import io.reactivex.Observable;

public interface IHttpRequester {
    Observable<IHttpResponse> get(final String url);

    Observable<IHttpResponse> post(final String url, final Map<String, String> body);
}
