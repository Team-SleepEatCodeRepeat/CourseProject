package com.telerikproject.tvshowcalendar.factories.base;

import com.telerikproject.tvshowcalendar.utils.base.IOkHttpResponse;

import okhttp3.ResponseBody;

public interface IHttpResponseFactory {
    IOkHttpResponse createResponse(final String body);
}
