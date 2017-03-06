package com.telerikproject.tvshowcalendar.factories;

import com.telerikproject.tvshowcalendar.factories.base.IHttpResponseFactory;
import com.telerikproject.tvshowcalendar.utils.base.IOkHttpResponse;

import okhttp3.ResponseBody;

public class HttpResponseFactory implements IHttpResponseFactory {

    @Override
    public IOkHttpResponse createResponse(final String body) {
        return new IOkHttpResponse() {

            @Override
            public String getBody() {
                return body;
            }
        };
    }
}
