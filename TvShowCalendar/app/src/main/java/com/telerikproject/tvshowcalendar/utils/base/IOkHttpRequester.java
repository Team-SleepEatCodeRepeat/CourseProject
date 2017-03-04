package com.telerikproject.tvshowcalendar.utils.base;

import java.util.Map;

import io.reactivex.Observable;

public interface IOkHttpRequester {
    Observable<IOkHttpResponse> get(final String url);

    Observable<IOkHttpResponse> post(final String url, final Map<String, String> body);
}
