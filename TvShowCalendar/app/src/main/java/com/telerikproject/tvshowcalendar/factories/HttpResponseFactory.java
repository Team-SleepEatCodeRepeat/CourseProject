package com.telerikproject.tvshowcalendar.factories;

import com.telerikproject.tvshowcalendar.factories.base.IHttpResponseFactory;
import com.telerikproject.tvshowcalendar.utils.base.IHttpResponse;

public class HttpResponseFactory implements IHttpResponseFactory {

    @Override
    public IHttpResponse createResponse(final String body) {
        return new IHttpResponse() {

            @Override
            public String getBody() {
                return body;
            }
        };
    }
}
