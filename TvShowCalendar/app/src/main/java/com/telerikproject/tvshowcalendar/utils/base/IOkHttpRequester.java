package com.telerikproject.tvshowcalendar.utils.base;

import io.reactivex.Observable;

public interface IOkHttpRequester {
    Observable<IOkHttpResponse> get(final String url);
}
